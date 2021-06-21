package ru.example.sportevents.ui.signup;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.example.sportevents.R;

public class SignUpActivity extends AppCompatActivity {
//    private final Button signUpButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
}
