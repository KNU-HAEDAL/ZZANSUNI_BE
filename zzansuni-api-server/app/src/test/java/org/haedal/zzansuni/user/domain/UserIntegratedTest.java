package org.haedal.zzansuni.user.domain;

import org.haedal.zzansuni.challengegroup.domain.Challenge;
import org.haedal.zzansuni.challengegroup.domain.ChallengeCategory;
import org.haedal.zzansuni.challengegroup.domain.ChallengeGroup;
import org.haedal.zzansuni.challengegroup.infrastructure.ChallengeGroupRepository;
import org.haedal.zzansuni.challengegroup.infrastructure.ChallengeRepository;
import org.haedal.zzansuni.global.security.Role;
import org.haedal.zzansuni.user.domain.port.UserReader;
import org.haedal.zzansuni.user.infrastructure.UserRepository;
import org.haedal.zzansuni.userchallenge.domain.*;
import org.haedal.zzansuni.userchallenge.domain.port.UserChallengeReader;
import org.haedal.zzansuni.userchallenge.infrastructure.ChallengeVerificationRepository;
import org.haedal.zzansuni.userchallenge.infrastructure.UserChallengeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserIntegratedTest {
    @Autowired
    private UserReader userReader;
    @Autowired
    private UserChallengeReader userChallengeReader;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChallengeGroupRepository challengeGroupRepository;
    @Autowired
    private ChallengeRepository challengeRepository;
    @Autowired
    private UserChallengeRepository userChallengeRepository;
    @Autowired
    private ChallengeVerificationRepository challengeVerificationRepository;


    @DisplayName("전체 사용자 랭킹이 내림차순으로 나타난다.")
    @Test
    public void getUserPagingByRankingOrder(){
        Pageable pageable = Pageable.ofSize(5).withPage(0);
        List<User> userList = createUsers(5);
        userRepository.saveAll(userList);

        //when
        List<User> users = userReader.getUserPagingByRanking(pageable).getContent();

        //then
        assertThat(users.size()).isEqualTo(5);
        assertThat(users.get(0).getNickname()).isEqualTo("user5");
        assertThat(users.get(1).getNickname()).isEqualTo("user4");
        assertThat(users.get(2).getNickname()).isEqualTo("user3");
        assertThat(users.get(3).getNickname()).isEqualTo("user2");
        assertThat(users.get(4).getNickname()).isEqualTo("user1");

        assertThat(users.get(0).getExp()).isGreaterThan(users.get(1).getExp());
        assertThat(users.get(1).getExp()).isGreaterThan(users.get(2).getExp());
        assertThat(users.get(2).getExp()).isGreaterThan(users.get(3).getExp());
        assertThat(users.get(3).getExp()).isGreaterThan(users.get(4).getExp());
    }


    @DisplayName("유저의 스트릭을 조회한다.")
    @Test
    @Transactional
    public void getUserStreak(){
        User user = createUser("테스트유저");
        userRepository.save(user);

        ChallengeGroup challengeGroup = createChallengeGroup();
        challengeGroupRepository.save(challengeGroup);

        Challenge challenge1 = createChallenge(challengeGroup);
        Challenge challenge2 = createChallenge(challengeGroup);
        challengeRepository.saveAll(List.of(challenge1, challenge2));

        LocalDate date = LocalDate.now();
        UserChallenge userChallenge1 = createUserChallenge(user, challenge1, date);
        UserChallenge userChallenge2 = createUserChallenge(user, challenge2, date);
        userChallengeRepository.saveAll(List.of(userChallenge1, userChallenge2));
        LocalDateTime time1 = LocalDateTime.now().minusDays(5);
        LocalDateTime time2 = LocalDateTime.now().minusDays(4);
        // userChallenge 생성일자 수정
        ReflectionTestUtils.setField(userChallenge1, "createdAt", time1);
        ReflectionTestUtils.setField(userChallenge2, "createdAt", time2);
        userChallengeRepository.saveAll(List.of(userChallenge1, userChallenge2));


        ChallengeVerification challengeVerification1 = createChallengeVerification(userChallenge1);
        ChallengeVerification challengeVerification2 = createChallengeVerification(userChallenge2);
        challengeVerificationRepository.saveAll(List.of(challengeVerification1, challengeVerification2));
        // challengeVerification 생성일자 수정
        ReflectionTestUtils.setField(challengeVerification1, "createdAt", time1);
        ReflectionTestUtils.setField(challengeVerification2, "createdAt", time2);
        challengeVerificationRepository.saveAll(List.of(challengeVerification1, challengeVerification2));


        //when
        List<DayCountType> userStreaks = userChallengeReader.countAllByUserIdAndDate(user.getId(), LocalDate.now().minusDays(7), LocalDate.now());

        //then
        assertThat(userStreaks.size()).isEqualTo(2);
        assertThat(userStreaks.get(0).getDate()).isEqualTo(LocalDate.now().minusDays(5));
        assertThat(userStreaks.get(0).getCount()).isEqualTo(1);
        assertThat(userStreaks.get(1).getDate()).isEqualTo(LocalDate.now().minusDays(4));
        assertThat(userStreaks.get(1).getCount()).isEqualTo(1);

        System.out.println("userStreak: ");
        for (DayCountType dayCountType : userStreaks) {
            System.out.println(dayCountType.getDate() + " : " + dayCountType.getCount());
        }
    }


    User createUser(String nickname, Integer exp){
        return User.builder()
                .nickname(nickname)
                .email(null)
                .password(null)
                .role(Role.USER)
                .provider(null)
                .authToken(null)
                .exp(exp)
                .profileImageUrl(null)
                .build();
    }

    List<User> createUsers(int size){
        return  LongStream.range(1, size+1)
                .mapToObj(i -> createUser("user" + i, (int) (i * 100)))
                .collect(Collectors.toList());
    }
    User createUser(String nickname){
        return User.builder()
                .nickname(nickname)
                .email(null)
                .password(null)
                .role(Role.USER)
                .provider(null)
                .authToken(null)
                .exp(0)
                .profileImageUrl(null)
                .build();
    }

    ChallengeGroup createChallengeGroup(){
        return ChallengeGroup.builder()
                .title("Test Challenge Group")
                .category(ChallengeCategory.ETC)
                .content("Test Challenge Group Content")
                .guide("Test Challenge Group Guide")
                .cumulativeCount(0)
                .joinStartDate(LocalDate.now().minusDays(10))
                .joinEndDate(LocalDate.now().minusDays(3))
                .build();
    }

    Challenge createChallenge(ChallengeGroup challengeGroup){
        return Challenge.builder()
                .challengeGroup(challengeGroup)
                .requiredCount(10)
                .onceExp(10)
                .successExp(50)
                .difficulty(1)
                .activePeriod(7)
                .build();
    }

    ChallengeVerification createChallengeVerification(UserChallenge userChallenge){
        return ChallengeVerification.builder()
                .userChallenge(userChallenge)
                .imageUrl("http://example.com/image.jpg")
                .content("Test Verification")
                .status(ChallengeVerificationStatus.APPROVED)
                .build();
    }

    UserChallenge createUserChallenge(User user, Challenge challenge, LocalDate date){
        return UserChallenge.builder()
                .challenge(challenge)
                .status(ChallengeStatus.PROCEEDING)
                .user(user)
                .activeStartDate(date)
                .activeEndDate(date.plusDays(7))
                .build();
    }
}