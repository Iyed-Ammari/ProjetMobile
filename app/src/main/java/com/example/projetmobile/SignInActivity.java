package com.example.projetmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {
    String username_input;
    String password_input;
    Button login_button ;
    final int MAX=8;

    final int MIN_Uppercase=2;


    final int MIN_Lowercase=2;


    final int NUM_Digits=2;


    final int Special=2;


    int uppercaseCounter=0;


    int lowercaseCounter=0;


    int digitCounter=0;


    int specialCounter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        login_button = findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username_input = ((EditText) findViewById(R.id.username_input)).getText().toString();
                password_input = ((EditText) findViewById(R.id.password_input)).getText().toString();
                if((verify_username(username_input)) && (verify_pw(password_input))){
                    Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    private boolean verify_pw(String password) {
        for (int i=0; i < password.length(); i++ ) {

            char c = password.charAt(i);

            if(Character.isUpperCase(c))

                uppercaseCounter++;

            else if(Character.isLowerCase(c))

                lowercaseCounter++;

            else if(Character.isDigit(c))

                digitCounter++;

            if(c>=33&&c<=46||c==64){

                specialCounter++;

            }

        }

        if (password.length() >= MAX && uppercaseCounter >= MIN_Uppercase

                && lowercaseCounter >= MIN_Lowercase && digitCounter >= NUM_Digits && specialCounter >= Special) {

            return true;

        }

        else {

            Toast.makeText(this, "Your password does not contain the following:", Toast.LENGTH_SHORT).show();

            if(password.length() < MAX)

                Toast.makeText(this," atleast 8 characters", Toast.LENGTH_SHORT).show();

            if (lowercaseCounter < MIN_Lowercase)

                Toast.makeText(this, "Minimum lowercase letters", Toast.LENGTH_SHORT).show();

            if (uppercaseCounter < MIN_Uppercase)

                Toast.makeText(this, "Minimum uppercase letters", Toast.LENGTH_SHORT).show();

            if(digitCounter < NUM_Digits)

                Toast.makeText(this, "Minimum number of numeric digits", Toast.LENGTH_SHORT).show();

            if(specialCounter < Special)

                Toast.makeText(this,"Password should contain at lest 3 special characters", Toast.LENGTH_SHORT).show();
return false;
        }


    }

    private boolean verify_username(String usernameInput) {
        if (usernameInput.length() == 0){
            Toast.makeText(this, "Enter username", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}