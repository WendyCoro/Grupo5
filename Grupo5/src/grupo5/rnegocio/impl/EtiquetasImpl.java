package grupo5.rnegocio.impl;

import grupo5.rnegocio.entidades.Etiquetas;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import gupo5.accesodatos.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.sql.*;

public class EtiquetasImpl implements IEtiquetas {
    
 @Override
    public int insertar(Etiquetas etiquetas) throws Exception {
        int numFilas = 0;
        String sqlC = "INSERT INTO Etiquetas (id_e, nombre, creado, actualizado ) VALUES (?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, etiquetas.getId_e()));
        lisParametros.add(new Parametro(2, etiquetas.getNombre()));
        if(etiquetas.getCreado()instanceof java.util.Date)
        {
            lisParametros.add(new Parametro(3, new java.sql.Date(((java.util.Date) etiquetas.getCreado()).getTime())));
        }
        else
        
        {
            lisParametros.add(new Parametro(3, etiquetas.getCreado()));
        }
        
         if(etiquetas.getActualizado()instanceof java.util.Date)
        {
            lisParametros.add(new Parametro(4, new java.sql.Date(((java.util.Date) etiquetas.getActualizado()).getTime())));
        }
        else
        
        {
            lisParametros.add(new Parametro(4, etiquetas.getActualizado()));
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
    public int modificar(Etiquetas etiquetas) throws Exception {
        int numFilas = 0;
        String sqlC="UPDATE etiquetas SET id_e=?, nombre=?, creado=? actualizado=?  WHERE id_e=?";
        ArrayList<Parametro> lisParametros=new ArrayList<>();
        lisParametros.add(new Parametro(1, etiquetas.getId_e()));
        lisParametros.add(new Parametro(2, etiquetas.getNombre()));
        lisParametros.add(new Parametro(3, etiquetas.getCreado()));
        lisParametros.add(new Parametro(4, etiquetas.getActualizado()));
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
    public int eliminar(Etiquetas etiquetas) throws Exception {
        int numFilas = 0;
        String sqlC="DELETE FROM etiquetas WHERE id_e=?";
        ArrayList<Parametro> lisParametros=new ArrayList<>();
        lisParametros.add(new Parametro(1, etiquetas.getId_e()));
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
    public Etiquetas obtener(int codigo) throws Exception {
        Etiquetas nEtiqueta = null;
        String sqlC="SELECT id_e, nombre, creado, actualizado FROM Etiquetas where id_e=?";
        ArrayList<Parametro> lisParametros=new ArrayList<>();
        lisParametros.add(new Parametro(1, codigo));
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(sqlC, lisParametros);
            while (rst.next()){
                nEtiqueta = new Etiquetas();
                nEtiqueta.setId_e(rst.getInt(1));
                nEtiqueta.setNombre(rst.getString(2));
                nEtiqueta.setCreado(rst.getDate(3));
                nEtiqueta.setActualizado(rst.getDate(4));
              
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nEtiqueta;
    }

    @Override
    public ArrayList<Etiquetas> obtener() throws Exception {
        ArrayList<Etiquetas> listEtiqueta = new ArrayList<>();
        String sqlC="SELECT id_e, nombre, creado, actualizado FROM Etiquetas";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(sqlC, null);
            Etiquetas etiquetas=null;
            while (rst.next()){
                etiquetas = new Etiquetas();
                etiquetas.setId_e(rst.getInt(1));
                etiquetas.setNombre(rst.getString(2));
                etiquetas.setCreado(rst.getDate(3));
                etiquetas.setActualizado(rst.getDate(4));
              
                listEtiqueta.add(etiquetas);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return listEtiqueta;
    }


}