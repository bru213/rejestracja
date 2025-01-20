package com.example.rejestracja;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextView bottomTV;
    private EditText emailInput, passInput, rePassInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomTV = findViewById(R.id.bottomTV);
        emailInput = findViewById(R.id.emailInput);
        rePassInput = findViewById(R.id.rePassInput);
        passInput = findViewById(R.id.passInput);
        Button submit = findViewById(R.id.submit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String email = emailInput.getText().toString().trim();
                String password = passInput.getText().toString().trim();
                String passSubmit = rePassInput.getText().toString().trim();
                Pattern emailP = Pattern.compile(".+@.+");

                if(!emailP.matcher(email).matches()){ // lub !Patterns.EMAIL_ADDRESS.matcher(email).matches() //
                    bottomTV.setText("Nieprawidłowy adres e-mail");
                } else if(!password.equals(passSubmit)){
                    bottomTV.setText("Hasła się rożnią");
                } else {
                    bottomTV.setText("Witaj " + email);
                }

            }
        });

    }
}