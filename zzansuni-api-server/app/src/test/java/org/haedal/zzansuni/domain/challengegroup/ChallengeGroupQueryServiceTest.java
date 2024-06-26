package org.haedal.zzansuni.domain.challengegroup;

import org.haedal.zzansuni.domain.challengegroup.challenge.Challenge;
import org.haedal.zzansuni.domain.challengegroup.image.ChallengeGroupImage;
import org.haedal.zzansuni.infrastructure.challengegroup.ChallengeGroupImageRepository;
import org.haedal.zzansuni.infrastructure.challengegroup.ChallengeGroupRepository;
import org.haedal.zzansuni.infrastructure.challengegroup.challenge.ChallengeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ChallengeGroupQueryServiceTest {
    @Autowired ChallengeGroupQueryService challengeGroupQueryService;
    @Autowired ChallengeGroupRepository challengeGroupRepository;
    @Autowired ChallengeRepository challengeRepository;
    @Autowired ChallengeGroupImageRepository challengeGroupImageRepository;

    @DisplayName("챌린지 그룹 목록 페이징이 정상적으로 동작한다.")
    @Test
    void getChallengeGroupsPaging() {
        // given
        for(int i = 0; i < 20; i++) {
            ChallengeGroup challengeGroup = createChallengeGroup("title" + i, ChallengeCategory.ECHO);
            challengeGroupRepository.save(challengeGroup);
        }
        for(int i = 0; i < 10; i++) {
            ChallengeGroup challengeGroup = createChallengeGroup("title" + i, ChallengeCategory.VOLUNTEER);
            challengeGroupRepository.save(challengeGroup);
        }

        // when
        Pageable pageable = PageRequest.of(0, 10);
        ChallengeCategory category = ChallengeCategory.ECHO;


        // then
        Page<ChallengeGroupModel.Info> challengeGroupsPaging = challengeGroupQueryService.getChallengeGroupsPaging(pageable, category);

        assertEquals(10, challengeGroupsPaging.getContent().size());
        assertEquals(2, challengeGroupsPaging.getTotalPages());

    }

    @DisplayName("챌린지 그룹 상세 조회가 정상적으로 동작한다.")
    @Test
    void getChallengeGroupDetail() {
        // given
        ChallengeGroup challengeGroup = createChallengeGroup("title", ChallengeCategory.ECHO);
        challengeGroupRepository.save(challengeGroup);

        Challenge challenge = Challenge.builder()
                .challengeGroup(challengeGroup)
                .requiredCount(12)
                .dayType(DayType.WEEK)
                .successExp(100)
                .onceExp(10)
                .difficulty(3)
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusDays(7))
                .build();
        challengeRepository.save(challenge);

        ChallengeGroupImage challengeGroupImage = ChallengeGroupImage.builder()
                .challengeGroup(challengeGroup)
                .imageUrl("image-url")
                .build();
        challengeGroupImageRepository.save(challengeGroupImage);


        // when
        ChallengeGroupModel.Detail model = challengeGroupQueryService.getChallengeGroupDetail(challengeGroup.getId());

        // then
        assertEquals(challengeGroup.getId(), model.getId());
        assertEquals(model.getChallenges().size(), 1);
        assertEquals(challenge.getId(), model.getChallenges().get(0).getId());
        assertEquals(model.getImageUrls().size(), 1);
        assertEquals(challengeGroupImage.getImageUrl(), model.getImageUrls().get(0));

    }

    @Test
    void getChallengeGroupsShortsPaging() {
    }

    @Test
    void getChallengeGroupRankingsPaging() {
    }

    @Test
    void getChallengeGroupRanking() {
    }



    private ChallengeGroup createChallengeGroup(String title, ChallengeCategory category) {
        return ChallengeGroup.builder()
                .title(title)
                .category(category)
                .content("content")
                .guide("guide")
                .cumulativeCount(0)
                .build();
    }
}