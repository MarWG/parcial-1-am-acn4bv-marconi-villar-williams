package com.example.eternal_games;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Arrays;
import java.util.List;

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

        // Crear productos
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

        List<Producto> productos = Arrays.asList(p1, p2);

        // Inflar productos en pantalla
        LinearLayout contenedor = findViewById(R.id.contenedorProductos);

        for (Producto p : productos) {
            View vistaProducto = LayoutInflater.from(this).inflate(R.layout.item_producto, contenedor, false);

            TextView titulo = vistaProducto.findViewById(R.id.txtTitulo);
            TextView descripcion = vistaProducto.findViewById(R.id.txtDescripcion);
            ImageView imagen = vistaProducto.findViewById(R.id.imgProducto);

            titulo.setText(p.title);
            descripcion.setText(p.description);
            imagen.setImageResource(p.img);;

            contenedor.addView(vistaProducto);
        }
    }
}