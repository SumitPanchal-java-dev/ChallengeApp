package com.embarkx.ChallengeApp;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing challenges.
 */
@RestController
public class ChallengeController {

    private final ChallengeService challengeService;

    // Constructor-based dependency injection
    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    // Retrieve all challenges
    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges() {
        return challengeService.getAllChallenges();
    }

    // Retrieve a challenge by month
    @GetMapping("/challenges/{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable String month) {
        Challenge challenge = challengeService.getChallenge(month);
        if (challenge != null) {
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add a new challenge
    @PostMapping("/challenges")
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge) {
        boolean isAdded = challengeService.addChallenge(challenge);
        return isAdded ? new ResponseEntity<>("Success", HttpStatus.CREATED)
                       : new ResponseEntity<>("Unsuccess", HttpStatus.BAD_REQUEST);
    }

    // Update an existing challenge
    @PutMapping("/challenges/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Integer id, @RequestBody Challenge updatedChallenge) {
        boolean isUpdated = challengeService.updateChallenge(id, updatedChallenge);
        return isUpdated ? new ResponseEntity<>("Success", HttpStatus.OK)
                         : new ResponseEntity<>("Unsuccess", HttpStatus.NOT_FOUND);
    }

    // Delete a challenge
    @DeleteMapping("/challenges/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Integer id) {
        boolean isDeleted = challengeService.deleteChallenge(id);
        return isDeleted ? new ResponseEntity<>("Success", HttpStatus.OK)
                         : new ResponseEntity<>("Unsuccess", HttpStatus.NOT_FOUND);
    }
}
