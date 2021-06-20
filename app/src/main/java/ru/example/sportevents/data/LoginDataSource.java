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
            // TODO: handle loggedInUser authentication
            final LoggedInUser[] loggedUser = new LoggedInUser[1];
            final boolean[] isLoginCompleted = {false};
            Task<AuthResult> result = mAuth.signInWithEmailAndPassword(username,password);
            while(!result.isComplete()){
                wait(1);
            }
            Log.d(TAG, "Login successful");
            loggedUser[0] = new LoggedInUser(mAuth.getCurrentUser());
            isLoginCompleted[0] = true;
            if(loggedUser[0]!=null)
                return new Result.Success<>(loggedUser[0]);
            else
                return new Result.Success<>(new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe"));
        } catch (Exception e) {
            return new Result.Error(new IOException(ERROR_MESSAGE, e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}