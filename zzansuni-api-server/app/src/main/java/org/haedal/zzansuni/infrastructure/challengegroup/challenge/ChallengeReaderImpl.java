package org.haedal.zzansuni.infrastructure.challengegroup.challenge;

import java.util.NoSuchElementException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.haedal.zzansuni.domain.challengegroup.challenge.Challenge;
import org.haedal.zzansuni.domain.challengegroup.challenge.port.ChallengeReader;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChallengeReaderImpl implements ChallengeReader {

    private final ChallengeRepository challengeRepository;

    @Override
    public Challenge getById(Long id) {
        return findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Optional<Challenge> findById(Long id) {
        return challengeRepository.findById(id);
    }


}
