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
import java.util.ArrayList;
import java.util.List;
import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class BodegaDAO {
    public static void registarBodega(DSLContext query, Bodega bodega){
        Table tablaBodega= table(name("Bodega"));
        Field[] columnas = tablaBodega.fields("codigo_bodega","direccion","horario","rut_trabajador");
        query.insertInto(tablaBodega, columnas[0], columnas[1],columnas[2], columnas[3])
                .values(bodega.getCodigoBodega(),bodega.getDireccion(),bodega.getHorario()
                ,bodega.getRutJefeDeBodega()).execute();
    }

    public static Bodega obtenerBodega(String columnaTabla, Object dato){
        Connection connection= DBConnector.connection("tienda_db","root","");
        DSLContext query= DSL.using(connection);
        return (Bodega) query.select().from(DSL.table("Bodega")).where(DSL.field(columnaTabla).eq(dato)).fetch();
    }
    private static List obtenerListaBodegas(Result resultados){
        List<Bodega> bodegas= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            String codigoBodega = (String) resultados.getValue(fila,"codigo_bodega");
            String direccion = (String) resultados.getValue(fila,"direccion");
            String horario = (String) resultados.getValue(fila,"horario");
            String rutJefeBodega = (String) resultados.getValue(fila,"rut_trabajador");
            bodegas.add(new Bodega(codigoBodega,direccion,horario,rutJefeBodega));
        }
        return bodegas;
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
}
