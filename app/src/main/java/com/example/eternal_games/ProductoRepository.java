package com.example.eternal_games;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductoRepository {

    public static List<Producto> cargarProductos(Context context) {
        List<Producto> lista = new ArrayList<>();

        try {
            InputStream is = context.getAssets().open("productos.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            String json = new String(buffer, "UTF-8");
            JSONArray array = new JSONArray(json);

            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                Producto producto = new Producto();

                producto.id = obj.getInt("id");
                producto.title = obj.getString("title");
                producto.description = obj.getString("description");
                producto.price = obj.getInt("price");
                producto.code = obj.getString("code");
                producto.status = obj.getBoolean("status");
                producto.platform = obj.optString("platform", "");
                producto.topSell = obj.optBoolean("topSell", false);
                producto.genre = obj.optString("genre", "");
                producto.category = obj.optString("category", "");

                // Obtener el String de la imagen del JSON
                String imgString = obj.getString("img");

                String nombreImagenLimpio = imgString
                        .replace("../images/", "")
                        .replace(".jpg", "")
                        .replace(".png", "")
                        .replace(".jpeg", "")
                        .replace("/", "_")
                        .toLowerCase();

                // Obtener el ID del recurso (R.drawable.nombre)
                int resId = context.getResources().getIdentifier(nombreImagenLimpio, "drawable", context.getPackageName());

                // Asignar el ID de recurso (int) a producto.img
                if (resId != 0) {
                    producto.img = resId;
                } else {
                    // Usar una imagen por defecto si no se encuentra
                    producto.img = R.drawable.imagen_no_disponible;
                }

                lista.add(producto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static List<Producto> obtenerProductosDemo() {
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
        p2.category = "Acción";
        p2.img = R.drawable.zelda_2;

        return Arrays.asList(p1, p2);
    }
}
