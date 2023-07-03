package com.proyecto.administraciontiendawebapp.model.data.dao;

import com.proyecto.administraciontiendawebapp.model.Bodega;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;
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

    public static List obtenerBodega(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Bodega")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaBodegas(resultados);
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
}
