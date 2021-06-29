package ru.example.sportevents.ui.signup;

import com.google.firebase.auth.FirebaseUser;

import lombok.Data;

@Data
public class RegisteredUser {

    private String displayName;
    private String email;

    public RegisteredUser(String displayName, String email) {
        this.displayName = displayName;
        this.email = email;
    }

    public RegisteredUser(FirebaseUser registeredUser) {
        this.displayName = registeredUser.getDisplayName();
        this.email = registeredUser.getEmail();
    }

}
