package ru.example.sportevents.data;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import ru.example.sportevents.data.model.LoggedInUser;

import java.io.IOException;
import java.util.Objects;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    private final String TAG = "AUTHORISER";
    private final String ERROR_MESSAGE = "Error logging in";
    private FirebaseAuth mAuth;
    public synchronized Result<LoggedInUser> login(String username, String password) {
        mAuth = FirebaseAuth.getInstance();
        try {
            LoggedInUser loggedUser = null;
            Task<AuthResult> result = mAuth.signInWithEmailAndPassword(username,password);
            while(!result.isComplete()){
                wait(1);
            }
            if(result.isSuccessful()) {
                Log.d(TAG, "Login successful");
                loggedUser = new LoggedInUser(Objects.requireNonNull(mAuth.getCurrentUser()));
            }
            if(loggedUser!=null)
                return new Result.Success<>(loggedUser);
            else
                return new Result.Error(new IOException(ERROR_MESSAGE));
        } catch (Exception e) {
            return new Result.Error(new IOException(ERROR_MESSAGE, e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}