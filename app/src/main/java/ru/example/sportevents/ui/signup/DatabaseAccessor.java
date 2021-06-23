package ru.example.sportevents.ui.signup;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.util.Date;

import ru.example.sportevents.data.Result;

public class DatabaseAccessor {

    private FirebaseAuth mAuth;

    public DatabaseAccessor() {
        mAuth = FirebaseAuth.getInstance();
    }

    public synchronized Result<RegisteredUser> signUp(String email, String password, String username) {
        Task<AuthResult> task = mAuth.createUserWithEmailAndPassword(email, password);
        try {
            while (!task.isComplete())
                wait(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return new Result.Error(e);
        }
        if (task.isSuccessful()) {
            return new Result.Success<>(mAuth.getCurrentUser());
        } else
            return new Result.Error(new IOException("Unable to register new user"));

    }

}
