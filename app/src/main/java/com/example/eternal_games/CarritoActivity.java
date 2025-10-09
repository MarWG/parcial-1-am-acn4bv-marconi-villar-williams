package com.example.eternal_games;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarritoActivity extends AppCompatActivity {

    private RecyclerView recyclerCarrito;
    private ArrayList<CarritoItem> carrito;

    private TextView txtTotalGeneral;
    private TextView txtCantidadTotal;
    private Button btnFinalizarCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        // Recibir el carrito desde MainActivity
        carrito = (ArrayList<CarritoItem>) getIntent().getSerializableExtra("carrito");
        if (carrito == null) {
            carrito = new ArrayList<>();
        }

        // Configurar RecyclerView
        recyclerCarrito = findViewById(R.id.recyclerCarrito);
        CarritoAdapter adapter = new CarritoAdapter(this, carrito);
        recyclerCarrito.setLayoutManager(new LinearLayoutManager(this));
        recyclerCarrito.setAdapter(adapter);

        // Referencias visuales
        txtTotalGeneral = findViewById(R.id.txtTotalGeneral);
        txtCantidadTotal = findViewById(R.id.txtCantidadTotal);
        btnFinalizarCompra = findViewById(R.id.btnFinalizarCompra);

        // Mostrar resumen
        actualizarResumen();

        // Botón para volver a MainActivity
        ImageButton btnInicio = findViewById(R.id.btnInicio);
        btnInicio.setOnClickListener(v -> finish());

        // Simulacion de boton finalizar compra
        btnFinalizarCompra.setOnClickListener(v -> {
            Toast.makeText(this, "Compra finalizada. ¡Gracias!", Toast.LENGTH_LONG).show();
        });
    }

    private void actualizarResumen() {
        double total = 0;
        int cantidad = 0;
        for (CarritoItem item : carrito) {
            total += item.getTotal(); // precio * cantidad
            cantidad += item.cantidad;
        }
        txtTotalGeneral.setText("Total: $" + (int)total);
        txtCantidadTotal.setText("Cantidad: " + cantidad);
    }
}