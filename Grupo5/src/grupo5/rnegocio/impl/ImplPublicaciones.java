
package grupo5.rnegocio.impl;

import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import gupo5.accesodatos.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ImplPublicaciones implements IPublicaciones{
    private Object Publicacion_id;
    @Override
    public int insertar(Publicaciones publicaciones) throws Exception{
        int numFilasAfectadas=0;
        String sql="insert into Publicaciones values(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, publicaciones.getId()));
        lstPar.add(new Parametro(2, publicaciones.getUsuario().getId()));
        lstPar.add(new Parametro(3, publicaciones.getNiveles().getId_Niveles()));
        lstPar.add(new Parametro(4, publicaciones.getTitulo()));
        lstPar.add(new Parametro(5, publicaciones.getContenido()));
        lstPar.add(new Parametro(6, publicaciones.getPublicacion()));
        lstPar.add(new Parametro(7, publicaciones.getVistas()));
         lstPar.add(new Parametro(8, publicaciones.getVotos()));
          lstPar.add(new Parametro(9, publicaciones.getCreado()));
        lstPar.add(new Parametro(10, publicaciones.getActualizado()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutarComando(sql,lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    
    @Override
    public List<Publicaciones> obtener() throws Exception{
    List<Publicaciones> lista = new ArrayList<>();
        String sql="SELECT * FROM publicaciones;";
        Conexion con = null;
        try{
            Publicaciones publicaciones = null;
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            while (rst.next()){
                publicaciones = new Publicaciones();
                publicaciones.setId(rst.getInt(1));
                //publicaciones.setUsuario(rst.getInt(2));
                //pulicaciones.setNiveles(rst.getInt(3));
                //publicaciones.setTitulo(rst.getInt(4));
                //publicaciones.setContenido(rst.getInt(5));
                publicaciones.setVotos(rst.getDouble(6));                
                publicaciones.setPublicacion(rst.getInt(7));
                publicaciones.setVistas(rst.getInt(8));
                publicaciones.setCreado(rst.getDate(9));
                publicaciones.setActualizado(rst.getDate(10));
                lista.add(publicaciones);
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
    public Publicaciones obtener(int codigo) throws Exception{
        return null;
        
    }  
    
}
