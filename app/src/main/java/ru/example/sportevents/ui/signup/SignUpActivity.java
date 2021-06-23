package ru.example.sportevents.ui.signup;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.example.sportevents.R;
import ru.example.sportevents.data.Result;

public class SignUpActivity extends AppCompatActivity {
    private Button signUpButton;
    private EditText name;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUpButton = findViewById(R.id.sign_up);
        name = findViewById(R.id.SdisplayName);
        email = findViewById(R.id.Susername);
        password = findViewById(R.id.Spassword);

        name.addTextChangedListener(textChangeListener);
        email.addTextChangedListener(textChangeListener);
        password.addTextChangedListener(textChangeListener);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseAccessor db = new DatabaseAccessor();
                Result<RegisteredUser> signUpResult = db.signUp(
                        email.getText().toString(),
                        password.getText().toString(),
                        name.getText().toString()
                );
                if (signUpResult instanceof Result.Success) {
                    String success = getString(R.string.successful_sign_up) + ((Result.Success<RegisteredUser>) signUpResult).getData().getDisplayName();
                    Toast.makeText(getApplicationContext(), success, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), getString(R.string.unsuccessful_sign_up), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private final TextWatcher textChangeListener = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            signUpButton.setEnabled(SignUpCorrectionVerifier
                    .isDataCorrect(
                            email.getText().toString(),
                            name.getText().toString(),
                            password.getText().toString()
                    ));
        }
    };
}
