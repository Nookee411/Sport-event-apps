package ru.example.sportevents.ui.login;

import androidx.annotation.Nullable;

import lombok.Getter;

/**
 * Data validation state of the login form.
 */
class LoginFormState {

    @Getter
    @Nullable
    private Integer usernameError;

    @Getter
    @Nullable
    private Integer passwordError;

    private boolean isDataValid;

    LoginFormState(@Nullable Integer usernameError, @Nullable Integer passwordError) {
        this.usernameError = usernameError;
        this.passwordError = passwordError;
        this.isDataValid = false;
    }

    LoginFormState(boolean isDataValid) {
        this.usernameError = null;
        this.passwordError = null;
        this.isDataValid = isDataValid;
    }

    boolean isDataValid() {
        return isDataValid;
    }
}