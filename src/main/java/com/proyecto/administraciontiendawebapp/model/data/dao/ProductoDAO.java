package com.proyecto.administraciontiendawebapp.model.data.dao;

import com.proyecto.administraciontiendawebapp.model.Producto;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class ProductoDAO {
    public static void registarArticulo(DSLContext query, Producto producto){
        Table tablaProducto= table(name("Producto"));
        Field[] columnas = tablaProducto.fields("codigo","nombre","stock","categoria","fecha_vencimiento","precio");
        query.insertInto(tablaProducto, columnas[0], columnas[1],columnas[2], columnas[3], columnas[4], columnas[5])
                .values(producto.getCodigo(),producto.getNombre(),producto.getStock(),producto.getCategoria(),
                        producto.getFechaVencimiento(),producto.getPrecio()).execute();
    }

    public static List obtenerArticulo(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Articulo")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaArticulos(resultados);
    }
    private static List obtenerListaArticulos(Result resultados){
        List<Producto> productos= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            String codigo = (String) resultados.getValue(fila,"codigo");
            String nombre = (String) resultados.getValue(fila,"nombre");
            int stock = (Integer) resultados.getValue(fila, "stock");
            String categoria = (String) resultados.getValue(fila,"categoria");
            Date fechaVencimiento = (Date) resultados.getValue(fila,"fecha_vencimiento");
            int precio = (Integer) resultados.getValue(fila, "precio");

            productos.add(new Producto(codigo,nombre,stock,categoria,fechaVencimiento,precio) {
            });
        }
        return productos;
    }
}
