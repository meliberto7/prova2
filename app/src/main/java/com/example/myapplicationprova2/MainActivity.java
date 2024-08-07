package com.example.myapplicationprova2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {

    private Button buttonAcessar;
    private BiometricPrompt biometricPrompt;
    private int very = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonAcessar = findViewById(R.id.buttonAcessar);


        buttonAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                irTelaHomePrincipal();

            }
        });

        BiometricPrompt.PromptInfo prompt = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Validação Biométrica")
                .setDescription("Confirma autenticação biométrica")
                .setNegativeButtonText("CANCELAR")
                .build();

        Executor executorCompat = ContextCompat.getMainExecutor(this);

        biometricPrompt = new BiometricPrompt(this, executorCompat, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                irTelaHomePrincipal();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                very++;

                if (very >= 3) {

                    very = 0;
                    biometricPrompt.cancelAuthentication();

                }

            }
        });

        biometricPrompt.authenticate(prompt);


    }

    private void irTelaHomePrincipal() {

        Intent intent = new Intent(MainActivity.this, TelaHomePrincipal.class);
        startActivity(intent);
        finish();

    }

}