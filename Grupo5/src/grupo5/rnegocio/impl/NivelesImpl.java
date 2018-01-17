
package grupo5.rnegocio.impl;
import grupo5.rnegocio.entidades.Niveles;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import gupo5.accesodatos.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class NivelesImpl implements INiveles {
    
    
    @Override
    public int insertar(Niveles niveles) throws Exception {
        int numFilas = 0;
        String sqlC = "INSERT INTO Niveles (id_n, nombre, creado, actualizado ) VALUES (?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, niveles.getId_n()));
        lisParametros.add(new Parametro(2, niveles.getNombre()));
        if(niveles.getCreado()instanceof java.util.Date)
        {
            lisParametros.add(new Parametro(3, new java.sql.Date(((java.util.Date) niveles.getCreado()).getTime())));
        }
        else
        
        {
            lisParametros.add(new Parametro(3, niveles.getCreado()));
        }
        
         if(niveles.getActualizado()instanceof java.util.Date)
        {
            lisParametros.add(new Parametro(4, new java.sql.Date(((java.util.Date) niveles.getActualizado()).getTime())));
        }
        else
        
        {
            lisParametros.add(new Parametro(4, niveles.getActualizado()));
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
    public int modificar(Niveles niveles) throws Exception {
        int numFilas = 0;
        String sqlC="UPDATE niveles SET id_n=?, nombre=?, creado=? actualizado=?  WHERE id_n=?";
        ArrayList<Parametro> lisParametros=new ArrayList<>();
        lisParametros.add(new Parametro(1, niveles.getId_n()));
        lisParametros.add(new Parametro(2, niveles.getNombre()));
        lisParametros.add(new Parametro(3, niveles.getCreado()));
        lisParametros.add(new Parametro(4, niveles.getActualizado()));
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
    public int eliminar(Niveles niveles) throws Exception {
        int numFilas = 0;
        String sqlC="DELETE FROM niveles WHERE id_n=?";
        ArrayList<Parametro> lisParametros=new ArrayList<>();
        lisParametros.add(new Parametro(1, niveles.getId_n()));
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
    public Niveles obtener(int codigo) throws Exception {
        Niveles nNivel = null;
        String sqlC="SELECT id_n, nombre, creado, actualizado  FROM Niveles where id_n=?";
        ArrayList<Parametro> lisParametros=new ArrayList<>();
        lisParametros.add(new Parametro(1, codigo));
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(sqlC, lisParametros);
            while (rst.next()){
                nNivel = new Niveles();
                nNivel.setId_n(rst.getInt(1));
                nNivel.setNombre(rst.getString(2));
                nNivel.setCreado(rst.getDate(3));
                nNivel.setActualizado(rst.getDate(4));
              
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nNivel;
    }

    @Override
    public ArrayList<Niveles> obtener() throws Exception {
        ArrayList<Niveles> listNivel = new ArrayList<>();
        String sqlC="SELECT id_n, nombre, creado, actualizado FROM Niveles";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(sqlC, null);
            Niveles niveles=null;
            while (rst.next()){
                niveles = new Niveles();
                niveles.setId_n(rst.getInt(1));
                niveles.setNombre(rst.getString(2));
                niveles.setCreado(rst.getDate(3));
                niveles.setActualizado(rst.getDate(4));
              
                listNivel.add(niveles);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return listNivel;
    }
}