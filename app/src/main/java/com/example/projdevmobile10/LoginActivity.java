package com.example.projdevmobile10;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText Usuario, Senha;
    Button btnEntrar;
    TextView btnCadastrar;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Usuario = findViewById(R.id.Usuario);
        Senha = findViewById(R.id.Senha);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
            startActivity(intent);
        });
        db = new Database(this);

        btnEntrar.setOnClickListener(v -> {
            String email = Usuario.getText().toString().trim();
            String senha = Senha.getText().toString().trim();

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean loginValido = db.autenticarUsuario(email, senha);
            if (loginValido) {
                Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "E-mail ou senha incorretos", Toast.LENGTH_SHORT).show();
            }
        });

        btnCadastrar.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, CadastroActivity.class));
        });
    }
}

