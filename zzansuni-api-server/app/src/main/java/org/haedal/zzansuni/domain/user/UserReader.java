package org.haedal.zzansuni.domain.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserReader {
    User getById(Long id);

    Optional<User> findByAuthToken(String authToken);

    Page<User> getUserPagingByRanking(Pageable pageable);
}
