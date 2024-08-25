package com.embarkx.ChallengeApp;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Repository interface for Challenge entity to handle CRUD operations.
 */
public interface ChallengeRepo extends JpaRepository<Challenge, Integer> {

    // Custom query to find a challenge by month, ignoring case
    Optional<Challenge> findByMonthIgnoreCase(String month);
}
