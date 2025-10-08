package com.example.eternal_games;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarritoAdapter extends RecyclerView.Adapter<CarritoAdapter.CarritoViewHolder> {

    private Context context;
    private List<CarritoItem> carrito;

    public CarritoAdapter(Context context, List<CarritoItem> carrito) {
        this.context = context;
        this.carrito = carrito;
    }

    @NonNull
    @Override
    public CarritoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(context).inflate(R.layout.item_carrito, parent, false);
        return new CarritoViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull CarritoViewHolder holder, int position) {
        CarritoItem item = carrito.get(position);

        holder.imgProducto.setImageResource(item.producto.img);
        holder.txtTitulo.setText(item.producto.title);
        holder.txtPrecioUnitario.setText("Precio unitario: " + item.producto.price);
        holder.txtCantidad.setText("Cantidad: " + item.cantidad);
        holder.txtTotal.setText("Total: " +item.getTotal());
    }

    @Override
    public int getItemCount() {
        return carrito.size();
    }

    public static class CarritoViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProducto;
        TextView txtTitulo, txtPrecioUnitario, txtCantidad, txtTotal;

        public CarritoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProducto = itemView.findViewById(R.id.imgProducto);
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
            txtPrecioUnitario = itemView.findViewById(R.id.txtPrecioUnitario);
            txtCantidad = itemView.findViewById(R.id.txtCantidad);
            txtTotal = itemView.findViewById(R.id.txtTotal);
        }
    }
}