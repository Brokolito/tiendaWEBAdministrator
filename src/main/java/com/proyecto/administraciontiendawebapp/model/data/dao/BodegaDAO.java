package com.proyecto.administraciontiendawebapp.model.data.dao;

import com.proyecto.administraciontiendawebapp.model.Bodega;
import com.proyecto.administraciontiendawebapp.model.Producto;
import com.proyecto.administraciontiendawebapp.model.data.DBConnector;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class BodegaDAO {
    public static boolean registarBodega(DSLContext query, Bodega bodega){
        Table tablaBodega= table(name("bodega"));
        Field[] columnas = tablaBodega.fields("cod_bodega","direccion_bodega","rut_trabajador_encargado");
        int result=query.insertInto(tablaBodega, columnas[0], columnas[1],columnas[2])
                .values(null,bodega.getDireccion()
                        ,bodega.getRutJefeDeBodega()).execute();
        return result==1;
    }
    public static Result obtenerBodegas(){
        Connection connection= DBConnector.connection("tienda_db","root","");
        DSLContext query= DSL.using(connection);
        return query.select().from(DSL.table("bodega")).fetch();
    }
    public static boolean registrarProductoBodega(String codigoBodega,String rutTrabajadorRegistra,String codigoProducto, int cantidad, String fechaVencimiento){
        Connection connection= DBConnector.connection("tienda_db","root","");
        DSLContext query= DSL.using(connection);

        Table tablaProductoAlmacenado= table(name("producto_almacenado"));
        Field[] columnas = tablaProductoAlmacenado.fields("cod_producto_almacenado","fecha_vencimiento","cantidad",
                "cod_producto","cod_bodega","rut_trabajador");
        query.insertInto(tablaProductoAlmacenado, columnas[0], columnas[1],columnas[2], columnas[3],columnas[4],columnas[5])
                .values(null,fechaVencimiento,cantidad,codigoProducto,codigoBodega,rutTrabajadorRegistra).execute();
        return true;
    }
    public static Result obtenerBodega(DSLContext query){
        return query.select().from(DSL.table("bodega")).fetch();
    }public static List obtenerProductosAlmacenados(String columnaTabla, Object dato) {
        Connection connection = DBConnector.connection("tienda_db", "root", "");
        DSLContext query = DSL.using(connection);
        Result resultado = query.select().from(table("producto_almacenado")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return productosAlmacenados(resultado);
    }
    public static List productosAlmacenados(Result resultado){
        List<Producto> productos = new ArrayList<>();
        for(int fila=0; fila<resultado.size();fila++){
            Date fechaVencimiento = (Date) resultado.getValue(fila,"fecha_vencimiento");
            int stock = (Integer) resultado.getValue(fila, "cantidad");
            int codigoProducto = (Integer) resultado.getValue(fila,"cod_producto");
            Producto producto = ProductoDAO.obtenerProducto(String.valueOf(codigoProducto));
            productos.add(new Producto(null,producto.getNombre(),stock,producto.getCategoria(), fechaVencimiento,producto.getPrecio()));
        }

        return productos;
    }
    public static boolean registrarHorario(DSLContext query, Bodega bodega) {
        String [] horario=bodega.getHorario().split("-");
        int result=0;
        int diaInicio=Integer.parseInt(horario[0]);
        int diaFinal=Integer.parseInt(horario[1]);
        int cantidadDia=diaFinal-diaInicio;

        try {
            if(cantidadDia!= 0){
                for (int i=diaInicio;i <=diaFinal; i++) {
                    result=query.insertInto(DSL.table("horario"),
                            DSL.field("horario_inicio"),DSL.field("horario_termino"),
                            DSL.field("cod_dia"),DSL.field("cod_bodega")).values(
                            horario[2],horario[3],i,bodega.getCodigoBodega()
                    ).execute();
                }
            }else{
                result=query.insertInto(DSL.table("horario"),
                        DSL.field("horario_inicio"),DSL.field("horario_termino"),
                        DSL.field("cod_dia"),DSL.field("cod_bodega")).values(
                        horario[2],horario[3],diaInicio,bodega.getCodigoBodega()
                ).execute();
            }
        }catch (Exception e){
            e.printStackTrace();;
        }
        return result==1;
    }
}
