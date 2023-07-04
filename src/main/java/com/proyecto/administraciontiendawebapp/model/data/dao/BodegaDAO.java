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

    public static Result obtenerBodega(DSLContext query){
        Result resultados = query.select().from(DSL.table("Bodega")).fetch();
        return resultados;
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

    public static boolean registrarHorario(DSLContext query, Bodega bodega) {
        String [] horario=bodega.getHorario().split("-");
        int result=0;
        int diaInicio=Integer.parseInt(horario[0]);
        int diaFinal=Integer.parseInt(horario[1]);
        int cantidadDia=diaFinal-diaInicio;
        System.out.println(cantidadDia);
        try {
            if(cantidadDia!= 0){
                for (int i=diaInicio;i <=diaFinal; i++) {
                    System.out.println(i);
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
