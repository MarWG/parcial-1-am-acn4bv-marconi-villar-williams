package com.example.eternal_games;

import java.util.Arrays;
import java.util.List;

public class ProductoRepository {
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
