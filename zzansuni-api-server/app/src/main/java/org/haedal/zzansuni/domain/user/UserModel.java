package org.haedal.zzansuni.domain.user;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class UserModel{
    @Builder
    public record Main(
            Long id,
            String email,
            String nickname,
            String profileImageUrl,
            Integer exp
    ) {
        public static Main from(User user) {
            return Main.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .nickname(user.getNickname())
                    .profileImageUrl(user.getProfileImageUrl())
                    .exp(user.getExp())
                    .build();
        }
    }

    @Builder
    public record Strick(
            List<DayCount> dayCounts
    ) {
        /** 여기서 count 0인걸 포함하는 기능을 쓰는게 맞는지 */
        public static Strick from(Map<LocalDate, Integer> strickCounts, LocalDate startDate, LocalDate endDate) {
            List<DayCount> resultList = startDate.datesUntil(endDate.plusDays(1))
                    // 날짜가 존재하면 map(date)로 count를 가져오고, 없으면 0을 저장한다.
                    .map(date -> new DayCount(date, strickCounts.getOrDefault(date, 0)))
                    .collect(Collectors.toList());
            return new Strick(resultList);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (dayCounts == null) {
                sb.append("null");
            } else {
                for (int i = 0; i < dayCounts.size(); i++) {
                    sb.append(dayCounts.get(i).toString());
                    if (i < dayCounts.size() - 1)
                        sb.append("\n");
                }
            }
            return sb.toString();
        }

    }
    @Builder
    public record DayCount(
            LocalDate date,
            Integer count
    ) {

        @Override
        public String toString() {
            return "DayCount{" +
                    "date=" + date +
                    ", count=" + count + '}';
        }
    }


}