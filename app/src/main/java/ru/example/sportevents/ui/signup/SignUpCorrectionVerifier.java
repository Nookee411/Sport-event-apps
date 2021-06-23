package ru.example.sportevents.ui.signup;

import android.util.Patterns;
import android.widget.EditText;

import java.util.regex.Pattern;

import ru.example.sportevents.R;

public class SignUpCorrectionVerifier {
    private static boolean isPasswordCorrect(String password) {
        if (password == null)
            return false;
        if (password.contains(" "))
            return false;
        return password.trim().length() > 5;
    }

    private static boolean isDisplayNameCorrect(String displayName) {
        if (displayName == null)
            return false;
        return displayName.trim().length() > 2;
    }

    private static boolean isEmailCorrect(String email) {
        if (email == null)
            return false;
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isDataCorrect(String email, String displayName, String password) {
        return isDisplayNameCorrect(displayName) && isEmailCorrect(email) && isPasswordCorrect(password);
    }
}
