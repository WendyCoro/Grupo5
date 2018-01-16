
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
    public int insertar(Publicaciones publicaciones) throws Exception{
        int numFilasAfectadas=0;
        String sql="INSER INTO Publicaciones (Publicaciones_Id,Usuario_Id,Nivel_Id,Titulo,Contenido,Publicacion,Vistas,Creado,Actualizado,Votos) VALUES (?,?,?,?,?,?,?,?,?)";
        ArrayList<Parametro> lstPar = new ArrayList<>();
       lstPar.add(new Parametro(1, publicaciones.getPublicaciones_Id()));
        lstPar.add(new Parametro(2, publicaciones.getUsuario().getUsuario_Id()));
        lstPar.add(new Parametro(3, publicaciones.getNiveles().getNiveles_Id()));
        lstPar.add(new Parametro(4, publicaciones.getTitulo()));
        lstPar.add(new Parametro(5, publicaciones.getContenido()));
        lstPar.add(new Parametro(6, publicaciones.getPublicacion()));
        lstPar.add(new Parametro(7, publicaciones.getVistas()));
         if (publicaciones.getCreado() instanceof java.sql.Date){
            lstPar.add (new Parametro(8,new java.sql.Date(((java.util.Date) publicaciones.getCreado()).getTime())));
        }else {
            lstPar.add (new Parametro(8, publicaciones.getCreado()));
        }
        if (publicaciones.getCreado() instanceof java.sql.Date){
            lstPar.add (new Parametro(9,new java.sql.Date(((java.util.Date) publicaciones.getActualizado()).getTime())));
        }else {
            lstPar.add (new Parametro(9, publicaciones.getActualizado()));
        }
         lstPar.add(new Parametro(10, publicaciones.getUsuario().getUsuario_Id()));
          
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
    public int modificar (Publicaciones publicaciones) throws Exception{
         int numFilasAfectadas=0;
        String sql="UPDATE  Publicaciones SET  Publicaciones_Id=? ,Usuario_Id=? ,Nivel_Id =? ,Titulo=?, Contenido=?, Publicacion=?,Vistas=?,Creado=?,Actualizado=?,Votos=? WHERE Publicaciones_Id=?"  ;
        List<Parametro> lstPar = new ArrayList<>();
         lstPar.add(new Parametro(1, publicaciones.getPublicaciones_Id()));
        lstPar.add(new Parametro(2, publicaciones.getUsuario().getUsuario_Id()));
        lstPar.add(new Parametro(3, publicaciones.getNiveles().getNiveles_Id()));
        lstPar.add(new Parametro(4, publicaciones.getTitulo()));
        lstPar.add(new Parametro(5, publicaciones.getContenido()));
        lstPar.add(new Parametro(6, publicaciones.getPublicacion()));
        lstPar.add(new Parametro(7, publicaciones.getVistas()));
         if (publicaciones.getCreado() instanceof java.sql.Date){
            lstPar.add (new Parametro(8,new java.sql.Date(((java.util.Date) publicaciones.getCreado()).getTime())));
        }else {
            lstPar.add (new Parametro(8, publicaciones.getCreado()));
        }
        if (publicaciones.getCreado() instanceof java.sql.Date){
            lstPar.add (new Parametro(9,new java.sql.Date(((java.util.Date) publicaciones.getActualizado()).getTime())));
        }else {
            lstPar.add (new Parametro(9, publicaciones.getActualizado()));
        }
         lstPar.add(new Parametro(10, publicaciones.getUsuario().getUsuario_Id()));
         lstPar.add(new Parametro(11, publicaciones.getPublicaciones_Id()));
          
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
    public int eliminar (Publicaciones publicaciones) throws Exception{
         int numFilasAfectadas=0;
        String sql="DELETE FROM  Publicaciones WHERE publicaciones_Id=?"  ;
        ArrayList<Parametro> lstPar =new ArrayList<>();
        lstPar.add(new Parametro(1, publicaciones.getPublicaciones_Id()));
    
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            numFilasAfectadas=con.ejecutarComando(sql, lstPar);
        }catch (Exception e) {
            System.out.print("Error" + e.getMessage());
        }finally {
            if(con!=null){
            con.desconectar();
        }
        }
        return numFilasAfectadas;
    }  
    
      
    
    @Override
    public Publicaciones obtener(long Publicaciones_Id) throws Exception{
        
       Publicaciones pub =null;
        String sql="SELECT  Publicaciones_Id,Usuario_Id,Nivel_Id,Titulo,Contenido,Publicacion,Vistas,Creado,Actualizado,Votos FROM Publicaciones WHERE Publicaciones_Id=? "  ;
        ArrayList<Parametro> lstPar =new ArrayList<>();
        lstPar.add(new Parametro(1, Publicaciones_Id));
    
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            IUsuario usDao= new ImplUsuario();
            Usuario us= null;
            INiveles nivDao= new ImplNiveles();
            Niveles niv = new Niveles();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()){
            pub = new Publicaciones();
            us= new Usuario();
            niv = new Niveles();
            pub.setPublicaciones_Id(1);
            us =usDao.obtener(rst.getLong(2));
            pub.setUsuario(us);
            niv=nivDao.obtener(rst.getLong(3));
            pub.setNiveles(niv);
            pub.setTitulo(rst.getString(4));
            pub.setContenido(rst.getString(5));
            pub.setPublicacion(rst.getInt(6));
            pub.setVistas(rst.getInt(7));
            pub.setCreado(rst.getDate(8));
            pub.setActualizado(rst.getDate(9));
            pub.setVotos(rst.getDouble(10));
             
        }
        }catch (Exception e) {
            System.out.print("Error" + e.getMessage());
        }finally {
            if(con!=null){
            con.desconectar();
            }
        }
        return pub;
       
        
    }

    
    @Override
    public ArrayList<Publicaciones> obtener() throws Exception{
          
       Publicaciones pub =null;
        String sqlC="SELECT  Publicaciones_Id,Usuario_Id,Nivel_Id,Titulo,Contenido,Publicacion,Vistas,Creado,Actualizado,Votos FROM Publicaciones "  ;
        ArrayList<Publicaciones> lstPu =new ArrayList<>();
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, null);
            while (rst.next()){
            IUsuario usDao= new ImplUsuario();
            Usuario us= null;
            INiveles nivDao= new ImplNiveles();
            Niveles niv = new Niveles();
            pub = new Publicaciones();
            us= new Usuario();
            niv = new Niveles();
            pub.setPublicaciones_Id(1);
            us =usDao.obtener(rst.getLong(2));
            pub.setUsuario(us);
            niv=nivDao.obtener(rst.getLong(3));
            pub.setNiveles(niv);
            pub.setTitulo(rst.getString(4));
            pub.setContenido(rst.getString(5));
            pub.setPublicacion(rst.getInt(6));
            pub.setVistas(rst.getInt(7));
            pub.setCreado(rst.getDate(8));
            pub.setActualizado(rst.getDate(9));
            pub.setVotos(rst.getDouble(10));
            
             lstPu.add(pub);
        }
        }catch (Exception e) {
            System.out.print("Error" + e.getMessage());
        }finally {
            if(con!=null){
            con.desconectar();
            }
        }
        return lstPu;
    }

  
}
       


    