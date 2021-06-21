package ru.example.sportevents.ui.signup;

import com.google.firebase.auth.FirebaseUser;

public class RegisteredUser {
    private String displayname;
    private String email;

    public RegisteredUser(String displayname, String email) {
        this.displayname = displayname;
        this.email = email;
    }

    public RegisteredUser(FirebaseUser registeredUser){
        this.displayname = registeredUser.getDisplayName();
        this.email = registeredUser.getEmail();
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
