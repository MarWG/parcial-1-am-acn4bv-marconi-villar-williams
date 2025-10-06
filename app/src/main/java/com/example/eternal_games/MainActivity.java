package com.example.eternal_games;

import android.os.Bundle;
import android.widget.Button; // 👈 Importar Button
import android.widget.Toast; // 👈 Importar Toast (opcional, para feedback)
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList; // 👈 Importar ArrayList
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Vista de productos
    private RecyclerView recyclerProductos;
    // Botón Demo
    private Button btnDemo;
    //Lista de productos
    private List<Producto> productos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerProductos = findViewById(R.id.recyclerProductos);
        btnDemo = findViewById(R.id.btnDemo);

        // Configuramos el RecyclerView para mostrar lista
        ProductoAdapter adapter = new ProductoAdapter(this, productos);
        recyclerProductos.setLayoutManager(new LinearLayoutManager(this)); // O GridLayoutManager
        recyclerProductos.setAdapter(adapter);

        // Creamos los productos harcoded
        Producto p1 = new Producto();
        p1.id = 1;
        p1.title = "Zelda";
        p1.description = "Mundo Abierto";
        p1.price = 4999;
        p1.code = "ES001";
        p1.status = true;
        p1.platform = "Nintendo";
        p1.topSell = true;
        p1.genre = "RPG";
        p1.category = "Aventura";
        p1.img = R.drawable.zelda;

        Producto p2 = new Producto();
        p2.id = 2;
        p2.title = "Zelda 2";
        p2.description = "Mundo Abierto";
        p2.price = 3999;
        p2.code = "GF002";
        p2.status = true;
        p2.platform = "Nintendo";
        p2.topSell = false;
        p2.genre = "RPG";
        p2.category = "Accion";
        p2.img = R.drawable.zelda_2;

        // Metemos los productos
        List<Producto> productosDemo = Arrays.asList(p1, p2);

        // Lógica del botón "Agregar Demo"
        btnDemo.setOnClickListener(v -> {
            // Limpiar la lista actual (opcional, si quieres que cada vez sea un set nuevo)
            productos.clear();

            // Añadir los productos demo a la lista de datos del RecyclerView
            productos.addAll(productosDemo);

            // Notificar al adaptador que los datos han cambiado
            adapter.notifyDataSetChanged();

            Toast.makeText(this, "Productos demo cargados.", Toast.LENGTH_SHORT).show();
        });
    }
}