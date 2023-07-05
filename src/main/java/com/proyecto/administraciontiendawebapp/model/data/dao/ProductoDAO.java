package com.proyecto.administraciontiendawebapp.model.data.dao;

import com.proyecto.administraciontiendawebapp.model.Producto;
import com.proyecto.administraciontiendawebapp.model.data.DBConnector;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class ProductoDAO {
    public static boolean registarArticulo(DSLContext query, Producto producto,String rutTrabajadorRegistra){
        Table tablaProducto= table(name("producto"));
        Field[] columnas = tablaProducto.fields(
                "cod_producto","nombre_producto","cod_categoria","precio","rut_trabajador_registra"
        );
        int result=query.insertInto(tablaProducto, columnas[0], columnas[1],columnas[2], columnas[3],columnas[4])
                .values(null,producto.getNombre(),producto.getCategoria()
                        ,producto.getPrecio(),rutTrabajadorRegistra).execute();
        return result==1;
    }
    public static Result obtenerProductosParametro(String columnaTabla, Object dato) {
        Connection connection = DBConnector.connection("tienda_db", "root", "");
        DSLContext query = DSL.using(connection);
        Result resultado = query.select().from(table("producto")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return resultado;
    }
    public static Result obtenerProductosDosParametro(String columnaTabla, Object dato, String columnaTabla1, Object dato1) {
        Connection connection = DBConnector.connection("tienda_db", "root", "");
        DSLContext query = DSL.using(connection);
        Result resultado = query.select().from(table("producto")).where(DSL.field(columnaTabla).eq(dato).and(DSL.field(columnaTabla1).eq(dato1))).fetch();
        return resultado;
    }
    public static boolean registrarCategoria(String nombreCategoria){
        Connection connection= DBConnector.connection("tienda_db","root","");
        DSLContext query= DSL.using(connection);

        int result=query.insertInto(DSL.table("categoria"),
                DSL.field("cod_categoria"),DSL.field("des_categoria")).values(null,nombreCategoria).execute();
        return result==1;
    }
    public static Result obtenerCategorias(){
        Connection connection= DBConnector.connection("tienda_db","root","");
        DSLContext query= DSL.using(connection);
        return query.select().from(DSL.table("categoria")).fetch();
    }
    public static Result obtenerProductos(){
        Connection connection= DBConnector.connection("tienda_db","root","");
        DSLContext query= DSL.using(connection);
        return query.select().from(DSL.table("producto")).fetch();
    }
}
