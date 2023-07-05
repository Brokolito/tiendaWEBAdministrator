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
        Table tablaTrabajador= table(name("trabajador"));
        Field[] columnas = tablaTrabajador.fields("rut_trabajador","nombre_trabajador","fecha_ingreso","fecha_nacimiento","cod_cargo","cod_tipo_contrato","correo_electronico","telefono","password");
        int result=0;
        try {
            result=query.insertInto(tablaTrabajador, columnas[0], columnas[1],columnas[2],columnas[3],columnas[4],columnas[5],columnas[6],columnas[7],columnas[8])
                    .values(
                            trabajador.getRut(),trabajador.getNombre(),trabajador.getFechaEntrada(),trabajador.getFechaNacimiento(),
                            trabajador.getCargo(),trabajador.getHorario(),
                            trabajador.getCorreo(),trabajador.getTelefono(),trabajador.getPassword()).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result==1;
    }
    public static Result obtenerTrabajador(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("trabajador")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return resultados;
    }

    public static boolean updateInformacion(DSLContext query, Trabajador trabajador) {
        int result=query.update(DSL.table("trabajador"))
                .set(DSL.field("correo_electronico"), trabajador.getCorreo())
                .set(DSL.field("telefono"), trabajador.getTelefono())
                .set(DSL.field("password"), trabajador.getPassword())
                .where(DSL.field("rut_trabajador").eq(trabajador.getRut()))
                .execute();
        return result==1;
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
                result.getValue(0,"cod_tipo_contrato").toString(),
                result.getValue(0, "telefono").toString(),
                result.getValue(0, "correo_electronico").toString(),
                result.getValue(0, "cod_tipo_contrato").toString(),
                result.getValue(0,"password").toString());
    }

}