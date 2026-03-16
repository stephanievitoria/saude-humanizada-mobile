package com.example.projdevmobile10;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {
    EditText Nome, Email, Senha, ConfirmarSenha;
    Button btnCadastrar;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Nome = findViewById(R.id.Nome);
        Email = findViewById(R.id.Email);
        Senha = findViewById(R.id.Senha);
        ConfirmarSenha = findViewById(R.id.ConfirmarSenha);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        db = new Database(this);

        btnCadastrar.setOnClickListener(v -> {
            Log.d("CAD", "Botão Cadastrar clicado");
            String nome = Nome.getText().toString().trim();
            String email = Email.getText().toString().trim();
            String senha = Senha.getText().toString().trim();
            String confirmarSenha = ConfirmarSenha.getText().toString().trim();

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                Log.d("CAD", "Campos vazios");
                return;
            }

            if (!senha.equals(confirmarSenha)) {
                Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
                Log.d("CAD", "Senha != confirmarSenha");
                return;
            }

            boolean inserido = db.inserirUsuario(nome, email, senha);
            Log.d("CAD", "Resultado inserirUsuario = " + inserido);
            if (inserido) {
                Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
            } else {
                Toast.makeText(this, "Erro: e-mail já cadastrado ou problema no banco.", Toast.LENGTH_LONG).show();
            }
        });
    }
}

