package grupo5.rnegocio.impl;

import grupo5.rnegocio.entidades.Roles;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import gupo5.accesodatos.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class RolesImpl implements IRoles {
     @Override
    public int insertar(Roles roles) throws Exception {
        int numFilas = 0;
        String sqlC = "INSERT INTO roles (id_r, nombre, creado, actualizado ) VALUES (?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, roles.getId_r()));
        lisParametros.add(new Parametro(2, roles.getNombre()));
        if(roles.getCreado()instanceof java.util.Date)
        {
            lisParametros.add(new Parametro(3, new java.sql.Date(((java.util.Date) roles.getCreado()).getTime())));
        }
        else
        
        {
            lisParametros.add(new Parametro(3, roles.getCreado()));
        }
        
         if(roles.getActualizado()instanceof java.util.Date)
        {
            lisParametros.add(new Parametro(4, new java.sql.Date(((java.util.Date) roles.getActualizado()).getTime())));
        }
        else
        
        {
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
        String sqlC="UPDATE roles SET id_r=?, nombre=?, creado=? actualizado=?  WHERE id_r=?";
        ArrayList<Parametro> lisParametros=new ArrayList<>();
        lisParametros.add(new Parametro(1, roles.getId_r()));
        lisParametros.add(new Parametro(2, roles.getNombre()));
        lisParametros.add(new Parametro(3, roles.getCreado()));
        lisParametros.add(new Parametro(4, roles.getActualizado()));
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
        String sqlC="DELETE FROM roles WHERE id_r=?";
        ArrayList<Parametro> lisParametros=new ArrayList<>();
        lisParametros.add(new Parametro(1, roles.getId_r()));
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
    public Roles obtener(int codigo) throws Exception {
        Roles nRol = null;
        String sqlC="SELECT id_r, nombre, creado, actualizado FROM roles where id_r=?";
        ArrayList<Parametro> lisParametros=new ArrayList<>();
        lisParametros.add(new Parametro(1, codigo));
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(sqlC, lisParametros);
            while (rst.next()){
                nRol = new Roles();
                nRol.setId_r(rst.getInt(1));
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
        String sqlC="SELECT id_r, nombre, creado, actualizado FROM Roles";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(sqlC, null);
            Roles roles=null;
            while (rst.next()){
                roles = new Roles();
                roles.setId_r(rst.getInt(1));
                roles.setNombre(rst.getString(2));
                roles.setCreado(rst.getDate(3));
                roles.setActualizado(rst.getDate(4));
              
                listRol.add(roles);
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
