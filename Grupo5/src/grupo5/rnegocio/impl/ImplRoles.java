package grupo5.rnegocio.impl;

import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import gupo5.accesodatos.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImplRoles implements IRoles{
     
   @Override
    public int insertar(Roles roles) throws Exception {
        int numFilas = 0;
        String sqlC = "INSERT INTO Rol (id, nombre, creado, actualizado) VALUES (?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, roles.getRoles_Id()));
        lisParametros.add(new Parametro(2, roles.getNombre()));
        if(roles.getCreado() instanceof java.util.Date){
            lisParametros.add(new Parametro(3, new java.sql.Date(((java.util.Date) roles.getCreado()).getTime())));
        }
        else{
            lisParametros.add(new Parametro(3, roles.getCreado()));
        }
        if(roles.getCreado() instanceof java.util.Date){
            lisParametros.add(new Parametro(4, new java.sql.Date(((java.util.Date) roles.getActualizado()).getTime())));
        }
        else{
            lisParametros.add(new Parametro(4, roles.getActualizado()));
        }
        Conexion con = null;
        try {
            con=new Conexion();
            con.conectar();
            numFilas=con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("error: "+e.getMessage());
        } finally {
            if(con!=null){
                con.desconectar();
            }
        }
        return numFilas;
    }

    @Override
    public int modificar(Roles roles) throws Exception {
        int numFilas = 0;
        String sqlC="UPDATE Rol SET id=?, nombre=?, creado=?  actualizado=?  WHERE id=?";
        ArrayList<Parametro> lisParametros=new ArrayList<>();
        lisParametros.add(new Parametro(1, roles.getRoles_Id()));
        lisParametros.add(new Parametro(2, roles.getNombre()));
        if(roles.getCreado() instanceof java.util.Date){
            lisParametros.add(new Parametro(3, new java.sql.Date(((java.util.Date) roles.getCreado()).getTime())));
        }
        else{
            lisParametros.add(new Parametro(3, roles.getCreado()));
        }
        if(roles.getCreado() instanceof java.util.Date){
            lisParametros.add(new Parametro(4, new java.sql.Date(((java.util.Date) roles.getActualizado()).getTime())));
        }
        else{
            lisParametros.add(new Parametro(4, roles.getActualizado()));
        }
        lisParametros.add(new Parametro(5, roles.getRoles_Id()));
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            numFilas=con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilas;
    }

    @Override
    public int eliminar(Roles roles) throws Exception {
        int numFilas = 0;
        String sqlC="DELETE FROM Rol WHERE id=?";
        ArrayList<Parametro> lisParametros=new ArrayList<>();
        lisParametros.add(new Parametro(1, roles.getRoles_Id()));
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            numFilas=con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilas;
    }

    @Override
    public Roles obtener(long Roles_Id) throws Exception {
        Roles nRol = null;
        String sqlC="SELECT id, nombre, creado, actualizado FROM Rol Where id=? ";
        ArrayList<Parametro> lisParametros=new ArrayList<>();
        lisParametros.add(new Parametro(1, Roles_Id));
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(sqlC, lisParametros);
            while (rst.next()){
                nRol=new Roles();
                nRol.setRoles_Id(rst.getInt(1));
                nRol.setNombre(rst.getString(2));
                nRol.setCreado(rst.getDate(3));
                nRol.setActualizado(rst.getDate(4));
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nRol;
    }

    @Override
    public ArrayList<Roles> obtener() throws Exception {
        ArrayList<Roles> listRol = new ArrayList<>();
        String sqlC="SELECT id, nombre, creado, actualizado FROM Rol";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(sqlC, null);
            while (rst.next()){
                Roles nRol=new Roles();
                nRol.setRoles_Id(rst.getInt(1));
                nRol.setNombre(rst.getString(2));
                nRol.setCreado(rst.getDate(3));
                nRol.setActualizado(rst.getDate(4));
                listRol.add(nRol);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return listRol;
 
}
}
