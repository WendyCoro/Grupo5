package grupo5.rnegocio.impl;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import gupo5.accesodatos.*;

public class PublicacionesImpl implements IPublicaciones {

    @Override
    public int insertar(Publicaciones publicacion) throws Exception{
        int numFilasAfectadas=0;
          String sql = "insert into publicacion values(?,?,?,?,?,?,?,?,?,?)";
          List<Parametro> lstPar = new ArrayList<>();
          lstPar.add(new Parametro(1, publicacion.getId_p()));
          lstPar.add(new Parametro(2, publicacion.getUsuarios().getId_u()));
          lstPar.add(new Parametro(3, publicacion.getNiveles().getId_n()));
          lstPar.add(new Parametro(4, publicacion.getTitulo()));
          lstPar.add(new Parametro(5, publicacion.getContenido()));
          lstPar.add(new Parametro(6, publicacion.getPublicado()));
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
        
        String sql="SELECT * FROM publicacion;";
        Conexion con = null;
        try{
            Publicaciones publicacion = null;
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            while (rst.next()){
                publicacion = new Publicaciones();
                publicacion.setId_p(rst.getLong(1));
                IUsuarios usuariosdao = new UsuariosImpl();
                Usuarios usuarios = usuariosdao.obtener(rst.getInt(2));
                publicacion.setUsuarios(usuarios);
                INiveles nivelesdao = new NivelesImpl();
                Niveles niveles = nivelesdao.obtener(rst.getInt(3));
                publicacion.setNiveles(niveles);
                publicacion.setTitulo(rst.getString(4));
                publicacion.setContenido(rst.getString(5));
                publicacion.setPublicado(rst.getInt(6));
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
        String sql="SELECT * FROM publicacion where id_p=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()){
                publicacion = new Publicaciones();
                publicacion.setId_p(rst.getLong(1));
                IUsuarios usuariosdao = new UsuariosImpl();
                Usuarios usuarios = usuariosdao.obtener(rst.getInt(2));
                publicacion.setUsuarios(usuarios);
                INiveles nivelesdao = new NivelesImpl();
                Niveles niveles = nivelesdao.obtener(rst.getInt(3));
                publicacion.setNiveles(niveles);
                publicacion.setTitulo(rst.getString(4));
                publicacion.setContenido(rst.getString(5));
                publicacion.setPublicado(rst.getInt(6));
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
