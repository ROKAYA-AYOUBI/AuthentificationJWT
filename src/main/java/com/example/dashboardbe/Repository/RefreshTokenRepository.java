package com.example.dashboardbe.Repository;

import com.example.dashboardbe.Domaine.RefreshToken;
import com.example.dashboardbe.Domaine.USER_DETAILS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteByUser(USER_DETAILS user);
}
