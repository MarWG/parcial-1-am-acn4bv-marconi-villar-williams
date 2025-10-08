package com.example.eternal_games;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarritoActivity extends AppCompatActivity {

    private RecyclerView recyclerCarrito;
    private ArrayList<CarritoItem> carrito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        // Recibir el carrito desde MainActivity
        carrito = (ArrayList<CarritoItem>) getIntent().getSerializableExtra("carrito");

        // Configurar RecyclerView
        recyclerCarrito = findViewById(R.id.recyclerCarrito);
        CarritoAdapter adapter = new CarritoAdapter(this, carrito);
        recyclerCarrito.setLayoutManager(new LinearLayoutManager(this));
        recyclerCarrito.setAdapter(adapter);

        // Botón para volver a MainActivity
        ImageButton btnInicio = findViewById(R.id.btnInicio);
        btnInicio.setOnClickListener(v -> finish());
    }
}