package com.example.eternal_games;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class CarritoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        // Encontrar el Contenedor del Navbar Inferior
        ImageButton btnInicio = findViewById(R.id.btnInicio);

        // Implementar boton home
        btnInicio.setOnClickListener(v -> {
            // utilizamos finish ya que mainActivity es quien lanzo la actividad
            finish();
        });
    }
}