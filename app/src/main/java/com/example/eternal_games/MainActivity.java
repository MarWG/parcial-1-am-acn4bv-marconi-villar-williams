package com.example.eternal_games;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerProductos;
    private Button btnDemo;
    private TextView badgeCantidad;
    private List<Producto> productos = new ArrayList<>();
    private ProductoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerProductos = findViewById(R.id.recyclerProductos);
        btnDemo = findViewById(R.id.btnDemo);
        badgeCantidad = findViewById(R.id.badgeCantidad);

        // Cargar productos desde JSON
        productos.addAll(ProductoRepository.cargarProductos(this));

        // Configurar RecyclerView con adapter que actualiza el badge
        adapter = new ProductoAdapter(this, productos, badgeCantidad);
        recyclerProductos.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerProductos.setAdapter(adapter);

        // Botón para agregar productos demo
        btnDemo.setOnClickListener(v -> {
            productos.addAll(ProductoRepository.obtenerProductosDemo());
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Productos demo cargados.", Toast.LENGTH_SHORT).show();
        });

        // Inicializar badge en 0 (oculto)
        actualizarBadge(0);
    }

    public void actualizarBadge(int cantidad) {
        if (badgeCantidad != null) {
            if (cantidad > 0) {
                badgeCantidad.setText(String.valueOf(cantidad));
                badgeCantidad.setVisibility(TextView.VISIBLE);
            } else {
                badgeCantidad.setVisibility(TextView.GONE);
            }
        }
    }
}