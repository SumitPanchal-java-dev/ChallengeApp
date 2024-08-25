package com.embarkx.ChallengeApp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing challenges.
 */
@Service
public class ChallengeService {

    @Autowired
    private ChallengeRepo repo;

    private Integer nextId = 1; // Simulated auto-increment ID

    // Retrieve all challenges
    public List<Challenge> getAllChallenges() {
        return repo.findAll();
    }

    // Add a new challenge
    public boolean addChallenge(Challenge challenge) {
        if (challenge != null) {
            challenge.setId(nextId++); // Set a new ID for the challenge
            repo.save(challenge);
            return true;
        }
        return false;
    }

    // Retrieve a challenge by month
    public Challenge getChallenge(String month) {
        Optional<Challenge> challenge = repo.findByMonthIgnoreCase(month);
        return challenge.orElse(null);
    }

    // Update an existing challenge
    public boolean updateChallenge(Integer id, Challenge updatedChallenge) {
        Optional<Challenge> existingChallenge = repo.findById(id);
        if (existingChallenge.isPresent()) {
            Challenge challenge = existingChallenge.get();
            challenge.setMonth(updatedChallenge.getMonth());
            challenge.setDescription(updatedChallenge.getDescription());
            repo.save(challenge);
            return true;
        }
        return false;
    }

    // Delete a challenge
    public boolean deleteChallenge(Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
