package ru.example.sportevents.data.model;

import com.google.firebase.auth.FirebaseUser;

import lombok.Data;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
@Data
public class LoggedInUser {

    private String userId;
    private String displayName;

    public LoggedInUser(String userId, String displayName) {
        this.userId = userId;
        this.displayName = displayName;
    }

    public LoggedInUser(FirebaseUser loggedUser) {
        this.userId = loggedUser.getUid();
        this.displayName = loggedUser.getEmail();
    }

}