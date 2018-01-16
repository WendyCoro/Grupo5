package grupo5.rnegocio.impl;

import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import gupo5.accesodatos.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ImplEtiquetas_publicaciones implements IEtiquetas_publicaciones{
 
     @Override
    public int insertar(Etiquetas_publicaciones etiquetas_publicaciones) throws Exception{
        int numFilasAfectadas=0;
        String sql="INSERT INTO Etiquetas_Publicaciones (Etiqueta_Publicaciones_Id,Publicacion_Id,Creado,Actualizado)VALUES(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, etiquetas_publicaciones.getEtiquetas().getEtiqueta_Id()));
        lstPar.add(new Parametro(2, etiquetas_publicaciones.getPublicaciones().getPublicaciones_Id()));
        if (etiquetas_publicaciones.getCreado() instanceof java.sql.Date){
            lstPar.add (new Parametro(3,new java.sql.Date(((java.util.Date) etiquetas_publicaciones.getCreado()).getTime())));
        }else {
            lstPar.add (new Parametro(3, etiquetas_publicaciones.getCreado()));
        }
        if (etiquetas_publicaciones.getCreado() instanceof java.sql.Date){
            lstPar.add (new Parametro(4,new java.sql.Date(((java.util.Date) etiquetas_publicaciones.getActualizado()).getTime())));
        }else {
            lstPar.add (new Parametro(4, etiquetas_publicaciones.getActualizado()));
        }
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
    public int modificar (Etiquetas_publicaciones etiquetas_publicaciones) throws Exception{
         int numFilasAfectadas=0;
        String sql="UPDATE Etiquetas_publicaciones SET  Etiqueta_Id=? ,Nombre=? ,Creado=? ,Actualizado=? WHERE Etiqueta_Id=?"  ;
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, etiquetas_publicaciones.getEtiquetas().getEtiqueta_Id()));
        lstPar.add(new Parametro(2, etiquetas_publicaciones.getPublicaciones().getPublicaciones_Id()));
        if (etiquetas_publicaciones.getCreado() instanceof java.sql.Date){
            lstPar.add (new Parametro(3,new java.sql.Date(((java.util.Date) etiquetas_publicaciones.getCreado()).getTime())));
        }else {
            lstPar.add (new Parametro(3, etiquetas_publicaciones.getCreado()));
        }
        if (etiquetas_publicaciones.getCreado() instanceof java.sql.Date){
            lstPar.add (new Parametro(4,new java.sql.Date(((java.util.Date) etiquetas_publicaciones.getActualizado()).getTime())));
        }else {
            lstPar.add (new Parametro(4, etiquetas_publicaciones.getActualizado()));
        }
       lstPar.add(new Parametro(5, etiquetas_publicaciones.getEtiquetas().getEtiqueta_Id()));
       lstPar.add(new Parametro(6, etiquetas_publicaciones.getPublicaciones().getPublicaciones_Id()));
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
    public int eliminar (Etiquetas_publicaciones etiquetas_publicaciones) throws Exception{
         int numFilasAfectadas=0;
        String sql="DELETE FROM  Etiquetas_Publicaciones WHERE Etiqueta_Id=? and Publicacion_Id"  ;
        ArrayList<Parametro> lstPar =new ArrayList<>();
        lstPar.add(new Parametro(1, etiquetas_publicaciones.getEtiquetas().getEtiqueta_Id()));
        lstPar.add(new Parametro(2, etiquetas_publicaciones.getPublicaciones().getPublicaciones_Id()));
    
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
    public Etiquetas_publicaciones obtener(long Etiqueta_Id , long Publicaciones_Id) throws Exception{
        Etiquetas_publicaciones lstetiquetap =null;
        String sql="SELECT Etiqueta_Id,Publicaciones_Id,  Creado, Actualizado FROM Etiquetas_publicaciones WHERE Etiqueta_Id=? and Publicaciones_Id "  ;
        ArrayList<Parametro> lstPar =new ArrayList<>();
        lstPar.add(new Parametro(1, Etiqueta_Id));
        lstPar.add(new Parametro(2, Publicaciones_Id));
    
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            IEtiquetas etiDao = new ImplEtiquetas();
            Etiquetas eti = null;
            IPublicaciones pubDao = new ImplPublicaciones();
            Publicaciones pub = null;
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()){
            lstetiquetap = new Etiquetas_publicaciones();
            eti = new Etiquetas();
            eti=etiDao.obtener(rst.getLong(1));
            lstetiquetap.setEtiquetas(eti);
            pub = new Publicaciones();
            pub = pubDao.obtener(rst.getLong(2));
            lstetiquetap.setPublicaciones(pub);
            lstetiquetap.setCreado(rst.getDate(3));
            lstetiquetap.setActualizado(rst.getDate(4));    
        }
        }catch (Exception e) {
            System.out.print("Error" + e.getMessage());
        }finally {
            if(con!=null){
            con.desconectar();
            }
        }
        return lstetiquetap;
       
        
    }

     @Override
    public ArrayList<Etiquetas_publicaciones> obtener() throws Exception{
        ArrayList<Etiquetas_publicaciones>lsEtiquetap = new ArrayList<>();
        Etiquetas_publicaciones stetiquetap =null;
        String sql="SELECT Etiqueta_Id, Publicaciones_Id, Creado, Actualizado FROM Etiquetas_publicaciones "  ;
       
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            IEtiquetas etiDao = new ImplEtiquetas();
            Etiquetas eti = null;
            IPublicaciones pubDao = new ImplPublicaciones();
            Publicaciones pub = null;
            ResultSet rst = con.ejecutarQuery(sql, null);
            while (rst.next()){
            stetiquetap = new Etiquetas_publicaciones();
            eti = new Etiquetas();
            eti=etiDao.obtener(rst.getLong(1));
            stetiquetap.setEtiquetas(eti);
            pub = new Publicaciones();
            pub = pubDao.obtener(rst.getLong(2));
            stetiquetap.setPublicaciones(pub);
            stetiquetap.setCreado(rst.getDate(3));
            stetiquetap.setActualizado(rst.getDate(4)); 
            lsEtiquetap.add(stetiquetap);
        }
        }catch (Exception e) {
            System.out.print("Error" + e.getMessage());
        }finally {
            if(con!=null){
                con.desconectar();
        }
    }
        return lsEtiquetap;
       
        
    }


}


