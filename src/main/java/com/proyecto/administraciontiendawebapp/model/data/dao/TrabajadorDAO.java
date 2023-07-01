package com.proyecto.administraciontiendawebapp.model.data.dao;
import com.proyecto.administraciontiendawebapp.model.Trabajador;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;
import java.util.ArrayList;
import java.util.List;
import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class TrabajadorDAO {
    public static boolean registarTrabajador(DSLContext query, Trabajador trabajador){
        Table tablaTrabajador= table(name("Trabajador"));
        Field[] columnas = tablaTrabajador.fields("rut","nombre","horario","titulo","telefono","correo","cargo");
        int result=0;
        try {
            result=query.insertInto(tablaTrabajador, columnas[0], columnas[1],columnas[2],columnas[4],columnas[5],columnas[6])
                    .values(trabajador.getRut(),trabajador.getNombre(),trabajador.getHorario(),
                            trabajador.getTelefono(),trabajador.getCorreo(),trabajador.getCargo()).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result==1;
    }
    public static List obtenerTrabajador(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("cliente")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaTrabajadores(resultados);
    }
    public Trabajador login(DSLContext query, Trabajador trabajador) {
        String rut = trabajador.getRut();
        String password = trabajador.getPassword();
        Result result = query.select().from(DSL.table("trabajador")).where(
                    DSL.field("rut_trabajador").eq(rut)).and(DSL.field("password").eq(password)).fetch();
        if(result.size()==0){
            return null;
        }



        return new Trabajador(
                result.getValue(0, "rut_trabajador").toString(),
                result.getValue(0, "nombre_trabajador").toString(),
                "",
                "",
                result.getValue(0, "telefono").toString(),
                result.getValue(0, "correo_electronico").toString(),
                result.getValue(0, "cod_tipo_contrato").toString());
    }
    private static List obtenerListaTrabajadores(Result resultados){
        List<Trabajador> trabajadores= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            String rut = (String) resultados.getValue(fila,"rut");
            String nombre = (String) resultados.getValue(fila,"nombre");
            String horario = (String) resultados.getValue(fila,"horario");
            String titulo = (String) resultados.getValue(fila,"titulo");
            String telefono = (String) resultados.getValue(fila,"telefono");
            String correo = (String) resultados.getValue(fila,"correo");
            String cargo = (String) resultados.getValue(fila,"cargo");
            trabajadores.add(new Trabajador(rut, nombre, horario, titulo, telefono, correo, cargo));
        }
        return trabajadores;
    }
}
