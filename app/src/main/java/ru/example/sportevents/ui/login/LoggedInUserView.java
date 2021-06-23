package ru.example.sportevents.ui.login;

import lombok.Getter;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {

    @Getter
    private String displayName;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(String displayName) {
        this.displayName = displayName;
    }

}