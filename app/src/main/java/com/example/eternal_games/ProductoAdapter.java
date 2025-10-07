package com.example.eternal_games;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {

    private Context context;
    private List<Producto> productos;
    private TextView badgeCantidad;
    private int contador = 0; // contador simulado de productos agregados

    public ProductoAdapter(Context context, List<Producto> productos, TextView badgeCantidad) {
        this.context = context;
        this.productos = productos;
        this.badgeCantidad = badgeCantidad;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        return new ProductoViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto p = productos.get(position);
        holder.titulo.setText(p.title);
        holder.descripcion.setText(p.description);
        holder.imagen.setImageResource(p.img); // Usamos imagen local

        holder.btnAgregar.setOnClickListener(v -> {
            contador++;

            if (badgeCantidad != null) {
                badgeCantidad.setText(String.valueOf(contador));
                badgeCantidad.setVisibility(View.VISIBLE);
            }

            Toast.makeText(context, p.title + " agregado al carrito", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public static class ProductoViewHolder extends RecyclerView.ViewHolder {
        TextView titulo, descripcion;
        ImageView imagen;
        Button btnAgregar;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.txtTitulo);
            descripcion = itemView.findViewById(R.id.txtDescripcion);
            imagen = itemView.findViewById(R.id.imgProducto);
            btnAgregar = itemView.findViewById(R.id.btnAgregar);
        }
    }
}