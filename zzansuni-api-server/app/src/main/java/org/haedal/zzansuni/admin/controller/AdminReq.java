package org.haedal.zzansuni.admin.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.haedal.zzansuni.challengegroup.domain.ChallengeCategory;
import org.haedal.zzansuni.challengegroup.domain.ChallengeGroupCommand;

import java.time.LocalDate;
import java.util.List;

public class AdminReq {
    public record CreateChallengeGroupRequest(
            @NotBlank(message = "title은 필수값입니다.")
            String title,
            @NotBlank(message = "content는 필수값입니다.")
            String content,
            @NotBlank(message = "guide는 필수값입니다.")
            String guide,
            @NotNull(message = "category는 필수값입니다.")
            ChallengeCategory category,
            @NotNull(message = "joinStartDate는 필수값입니다.")
            LocalDate joinStartDate,
            @NotNull(message = "joinEndDate는 필수값입니다.")
            LocalDate joinEndDate,
            @NotNull(message = "challenges는 필수값입니다.")
            List<CreateChallengeRequest> challenges
    ){
       public ChallengeGroupCommand.Create toCommand() {
            return ChallengeGroupCommand.Create.builder()
                    .title(title)
                    .content(content)
                    .guide(guide)
                    .category(category)
                    .joinStartDate(joinStartDate)
                    .joinEndDate(joinEndDate)
                    .createChallenges(challenges.stream().map(CreateChallengeRequest::toCommand).toList())
                    .build();
        }
    }

    public record CreateChallengeRequest(
            @NotNull(message = "requiredCount는 필수값입니다.")
            Integer requiredCount,
            @NotNull(message = "onceExp는 필수값입니다.")
            Integer onceExp,
            @NotNull(message = "successExp는 필수값입니다.")
            Integer successExp,
            @NotNull(message = "difficulty는 필수값입니다.")
            Integer difficulty,
            @NotNull(message = "activePeriod는 필수값입니다.")
            Integer activePeriod
    ){
        public ChallengeGroupCommand.CreateChallenge toCommand() {
            return ChallengeGroupCommand.CreateChallenge.builder()
                    .requiredCount(requiredCount)
                    .onceExp(onceExp)
                    .successExp(successExp)
                    .difficulty(difficulty)
                    .activePeriod(activePeriod)
                    .build();
        }
    }

}
