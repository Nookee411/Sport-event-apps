package ru.example.sportevents.ui.login;

import androidx.annotation.Nullable;

import lombok.Getter;

/**
 * Authentication result : success (user details) or error message.
 */
class LoginResult {

    @Getter
    @Nullable
    private LoggedInUserView success;

    @Getter
    @Nullable
    private Integer error;

    LoginResult(@Nullable Integer error) {
        this.error = error;
    }

    LoginResult(@Nullable LoggedInUserView success) {
        this.success = success;
    }

}