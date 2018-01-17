
package grupo5.rnegocio.impl;

import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import gupo5.accesodatos.*;
import java.util.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ImplPublicaciones implements IPublicaciones{
    @Override
    public int insertar(Publicaciones publicacion) throws Exception{
        int numFilasAfectadas=0;
          String sql = "insert into Publicaciones values(?,?,?,?,?,?,?,?,?,?)";
          List<Parametro> lstPar = new ArrayList<>();
          lstPar.add(new Parametro(1, publicacion.getPublicaciones_Id()));
          lstPar.add(new Parametro(2, publicacion.getUsuario().getUsuario_Id()));
          lstPar.add(new Parametro(3, publicacion.getNiveles().getNiveles_Id()));
          lstPar.add(new Parametro(4, publicacion.getTitulo()));
          lstPar.add(new Parametro(5, publicacion.getContenido()));
          lstPar.add(new Parametro(6, publicacion.getPublicacion()));
          lstPar.add(new Parametro(7, publicacion.getVistas()));
          lstPar.add(new Parametro(8, publicacion.getVotos()));
          lstPar.add(new Parametro(9, publicacion.getCreado()));
          lstPar.add(new Parametro(10, publicacion.getActualizado()));
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
    public List<Publicaciones> obtener() throws Exception{
        List<Publicaciones> lista = new ArrayList<>();
        
        String sql="SELECT * FROM Publicaciones;";
        Conexion con = null;
        try{
            Publicaciones publicacion = null;
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            while (rst.next()){
                publicacion = new Publicaciones();
                publicacion.setPublicaciones_Id(rst.getLong(1));
                IUsuario usuariodao = new ImplUsuario();
                Usuario usuario = usuariodao.obtener(rst.getLong(2));
                publicacion.setUsuario(usuario);
                INiveles niveldao = new ImplNiveles();
                Niveles nivel = niveldao.obtener(rst.getLong(3));
                publicacion.setNiveles(nivel);
                publicacion.setTitulo(rst.getString(4));
                publicacion.setContenido(rst.getString(5));
                publicacion.setPublicacion(rst.getInt(6));
                publicacion.setVistas(rst.getInt(7));
                publicacion.setVotos(rst.getDouble(8));
                publicacion.setCreado(rst.getDate(9));
                publicacion.setActualizado(rst.getDate(10));
                lista.add(publicacion);
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
    public Publicaciones obtener(long codigo) throws Exception{
        Publicaciones publicacion = null;
        String sql="SELECT * FROM Publicaciones where Publicaciones_Id=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()){
                publicacion = new Publicaciones();
                publicacion.setPublicaciones_Id(rst.getLong(1));
                IUsuario usuariodao = new ImplUsuario();
                Usuario usuario = usuariodao.obtener(rst.getLong(2));
                publicacion.setUsuario(usuario);
                INiveles niveldao = new ImplNiveles();
                Niveles nivel = niveldao.obtener(rst.getLong(3));
                publicacion.setNiveles(nivel);
                publicacion.setTitulo(rst.getString(4));
                publicacion.setContenido(rst.getString(5));
                publicacion.setPublicacion(rst.getInt(6));
                publicacion.setVistas(rst.getInt(7));
                publicacion.setVotos(rst.getDouble(8));
                publicacion.setCreado(rst.getDate(9));
                publicacion.setActualizado(rst.getDate(10));
            }
        }catch (Exception e) {
            throw e;
        }finally {
            if(con!=null)
            con.desconectar();
        }
        return publicacion;
}
    }
