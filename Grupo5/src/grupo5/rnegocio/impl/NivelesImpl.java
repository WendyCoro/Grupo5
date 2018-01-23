package grupo5.rnegocio.impl;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import gupo5.accesodatos.*;

public class NivelesImpl implements INiveles {    
     @Override
    public int insertar(Niveles nivel) throws Exception{
        int numFilasAfectadas=0;
        String sql="insert into nivel values(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, nivel.getId_n()));
        lstPar.add(new Parametro(2, nivel.getNombre()));
        lstPar.add(new Parametro(3, nivel.getCreado()));
        lstPar.add(new Parametro(4, nivel.getActualizado()));
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            numFilasAfectadas=con.ejecutarComando(sql, lstPar);
        }catch (Exception e) {
            throw e;
        }finally {
            if(con!=null)
            con.desconectar();
        }
        return numFilasAfectadas;
    }
    @Override
    public List<Niveles> obtener() throws Exception{
        List<Niveles> lista = new ArrayList<>();
        
        String sql="SELECT * FROM nivel;";
        Conexion con = null;
        try{
            Niveles nivel = null;
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            while (rst.next()){
                nivel = new Niveles();
                nivel.setId_n(rst.getLong(1));
                nivel.setNombre(rst.getString(2));
                nivel.setCreado(rst.getDate(3));
                nivel.setActualizado(rst.getDate(4));
                lista.add(nivel);
           }
        }catch (Exception e) {
            throw e;
        }finally {
            if(con!=null)
            con.desconectar();
        }
        return lista;
    }  
    @Override
    public Niveles obtener(long codigo) throws Exception{
        Niveles nivel = null;
        String sql="SELECT * FROM nivel where id_n=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()){
                nivel = new Niveles();
                nivel.setId_n(rst.getLong(1));
                nivel.setNombre(rst.getString(2));
                nivel.setCreado(rst.getDate(3));
                nivel.setActualizado(rst.getDate(4));
            }
        }catch (Exception e) {
            throw e;
        }finally {
            if(con!=null)
            con.desconectar();
        }
        return nivel;
    }  
}
