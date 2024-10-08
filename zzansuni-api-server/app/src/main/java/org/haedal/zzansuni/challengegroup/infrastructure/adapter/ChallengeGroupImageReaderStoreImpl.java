package org.haedal.zzansuni.challengegroup.infrastructure.adapter;

import lombok.RequiredArgsConstructor;
import org.haedal.zzansuni.challengegroup.domain.ChallengeGroupImage;
import org.haedal.zzansuni.challengegroup.domain.port.ChallengeGroupImageReader;
import org.haedal.zzansuni.challengegroup.domain.port.ChallengeGroupImageStore;
import org.haedal.zzansuni.challengegroup.infrastructure.ChallengeGroupImageRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ChallengeGroupImageReaderStoreImpl implements ChallengeGroupImageReader, ChallengeGroupImageStore {
    private final ChallengeGroupImageRepository challengeGroupImageRepository;
    @Override
    public List<ChallengeGroupImage> getByChallengeGroupId(Long challengeGroupId) {
        return challengeGroupImageRepository.findByChallengeGroupId(challengeGroupId);
    }

    @Override
    public void saveAll(List<ChallengeGroupImage> challengeGroupImages) {
        challengeGroupImageRepository.saveAll(challengeGroupImages);
    }

    @Override
    public void deleteAllByChallengeGroupId(Long challengeGroupId) {
        challengeGroupImageRepository.deleteAllByChallengeGroupId(challengeGroupId);
    }
}
