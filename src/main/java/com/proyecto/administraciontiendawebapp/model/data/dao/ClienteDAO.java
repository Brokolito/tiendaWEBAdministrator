package com.proyecto.administraciontiendawebapp.model.data.dao;

import com.proyecto.administraciontiendawebapp.model.Cliente;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class ClienteDAO {
    public static boolean registarCliente(DSLContext query, Cliente cliente) {
        Table tablaCliente = table(name("cliente"));
        Field[] columnas = tablaCliente.fields("rut_cliente", "nombre_cliente", "direccion", "telefono", "correo_electronico");
        int result = 0;
        try {
            result=query.insertInto(tablaCliente, columnas[0], columnas[1], columnas[2], columnas[3], columnas[4])
                    .values(cliente.getRut(), cliente.getNombre(), cliente.getDireccion(), cliente.getTelefono(), cliente.getCorreo())
                    .execute();
        } catch (Exception e) {
            System.out.println("Rut Ya registrado!!");
        }

        return result==1;
    }
    public static List obtenerCliente(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("cliente")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaClientes(resultados);
    }
    private static List obtenerListaClientes(Result resultados){
        List<Cliente> clientes= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            String rut = (String) resultados.getValue(fila,"rut_cliente");
            String nombre = (String) resultados.getValue(fila,"nombre_cliente");
            String direccion = (String) resultados.getValue(fila,"direccion");
            String telefono = (String) resultados.getValue(fila,"telefono");
            String correo= (String) resultados.getValue(fila,"correo_electronico");
            clientes.add(new Cliente(rut,nombre,direccion,telefono,correo));
        }
        return clientes;
    }
}
