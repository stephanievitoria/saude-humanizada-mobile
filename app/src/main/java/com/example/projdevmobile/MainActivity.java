package com.example.projdevmobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.projdevmobile10.R;

public class MainActivity extends AppCompatActivity {

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
