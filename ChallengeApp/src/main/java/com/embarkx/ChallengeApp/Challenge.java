package com.embarkx.ChallengeApp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Represents a monthly challenge with an ID, month, and description.
 */
@Entity
public class Challenge {

    @Id
    private Integer id;

    @Column(name = "challengemonth")
    private String month;

    private String description;

    // Default constructor for JPA
    public Challenge() {
    }

    // Parameterized constructor for easier object creation
    public Challenge(Integer id, String month, String description) {
        this.id = id;
        this.month = month;
        this.description = description;
    }

    // Getters and setters for all fields
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
