package com.example.eternal_games;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerProductos;
    private Button btnDemo;
    private List<Producto> productos = new ArrayList<>();
    private ProductoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerProductos = findViewById(R.id.recyclerProductos);
        btnDemo = findViewById(R.id.btnDemo);

        adapter = new ProductoAdapter(this, productos);
        recyclerProductos.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerProductos.setAdapter(adapter);

        btnDemo.setOnClickListener(v -> {
            productos.clear();
            productos.addAll(ProductoRepository.obtenerProductosDemo());
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Productos demo cargados.", Toast.LENGTH_SHORT).show();
        });
    }
}