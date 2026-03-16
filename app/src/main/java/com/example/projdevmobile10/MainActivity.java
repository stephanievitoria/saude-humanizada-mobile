package com.example.projdevmobile10;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, btnCadastro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnCadastro = findViewById(R.id.btnCadastro);
        TextView textToolbarLogin = findViewById(R.id.textToolbarLogin);


        textToolbarLogin.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });


        btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        btnCadastro.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Botões e navegação
        Button btnMedicamentos = findViewById(R.id.btnMedicamentos);
        Button btnNaturais = findViewById(R.id.btnNaturais);
        Button btnNutricao = findViewById(R.id.btnNutricao);

        btnMedicamentos.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MedicamentosActivity.class);
            startActivity(intent);
        });

        btnNaturais.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NaturaisActivity.class);
            startActivity(intent);
        });

        btnNutricao.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NutricaoActivity.class);
            startActivity(intent);
        });
    }
}
