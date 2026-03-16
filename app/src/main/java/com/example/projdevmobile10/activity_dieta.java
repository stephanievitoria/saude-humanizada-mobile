package com.example.projdevmobile10;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_dieta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dieta);

        Button btnVermais = findViewById(R.id.btnVermais);
        btnVermais.setOnClickListener(v -> {
            Intent intent = new Intent(activity_dieta.this, activity_contdieta.class);
            startActivity(intent);
            finish();
        });

        Button btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(activity_dieta.this, NutricaoActivity.class);
            startActivity(intent);
            finish();
        });
    }
}

