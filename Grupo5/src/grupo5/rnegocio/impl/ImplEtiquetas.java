package grupo5.rnegocio.impl;

import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import gupo5.accesodatos.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.sql.*;

public class ImplEtiquetas implements IEtiquetas{

    @Override
    public int insertar(Etiquetas etiquetas) throws Exception{
        int numFilasAfectadas=0;
        String sql="INSERT INTO Etiquetas (Etiqueta_Id,Nombre,Creado,Actualizado)VALUES(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, etiquetas.getEtiqueta_Id()));
        lstPar.add(new Parametro(2, etiquetas.getNombre()));
        if (etiquetas.getCreado() instanceof java.sql.Date){
            lstPar.add (new Parametro(3,new java.sql.Date(((java.util.Date) etiquetas.getCreado()).getTime())));
        }else {
            lstPar.add (new Parametro(3, etiquetas.getCreado()));
        }
        if (etiquetas.getCreado() instanceof java.sql.Date){
            lstPar.add (new Parametro(4,new java.sql.Date(((java.util.Date) etiquetas.getActualizado()).getTime())));
        }else {
            lstPar.add (new Parametro(4, etiquetas.getActualizado()));
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
    public int modificar (Etiquetas etiquetas) throws Exception{
         int numFilasAfectadas=0;
        String sql="UPDATE  Etiquetas SET  Etiqueta_Id=? ,Nombre=? ,Creado=? ,Actualizado=? WHERE Etiqueta_Id=?"  ;
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, etiquetas.getEtiqueta_Id()));
        lstPar.add(new Parametro(2, etiquetas.getNombre()));
        if (etiquetas.getCreado() instanceof java.sql.Date){
            lstPar.add (new Parametro(3,new java.sql.Date(((java.util.Date) etiquetas.getCreado()).getTime())));
        }else {
            lstPar.add (new Parametro(3, etiquetas.getCreado()));
        }
        if (etiquetas.getCreado() instanceof java.sql.Date){
            lstPar.add (new Parametro(4,new java.sql.Date(((java.util.Date) etiquetas.getActualizado()).getTime())));
        }else {
            lstPar.add (new Parametro(4, etiquetas.getActualizado()));
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
    public int eliminar (Etiquetas etiquetas) throws Exception{
         int numFilasAfectadas=0;
        String sql="DELETE FROM  Etiquetas WHERE Etiqueta_Id=?"  ;
        ArrayList<Parametro> lstPar =new ArrayList<>();
        lstPar.add(new Parametro(1, etiquetas.getEtiqueta_Id()));
    
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
    public Etiquetas obtener(long Etiqueta_Id) throws Exception{
        Etiquetas lstetiqueta =null;
        String sqlC="SELECT Etiqueta_Id, Nombre, Creado, Actualizado FROM Etiquetas WHERE Etiqueta_Id=? "  ;
        ArrayList<Parametro> lstPar =new ArrayList<>();
        lstPar.add(new Parametro(1, Etiqueta_Id));
    
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, lstPar);
            while (rst.next()){
            lstetiqueta = new Etiquetas();
            lstetiqueta.setEtiqueta_Id(rst.getInt(1));
            lstetiqueta.setNombre(rst.getString(2));
            lstetiqueta.setCreado(rst.getDate(3));
            lstetiqueta.setActualizado(rst.getDate(4));    
        }
        }catch (Exception e) {
            System.out.print("Error" + e.getMessage());
        }finally {
            if(con!=null){
            con.desconectar();
            }
        }
        return lstetiqueta;
       
        
    }

    
    @Override
    public ArrayList<Etiquetas> obtener() throws Exception{
        ArrayList<Etiquetas>lsEtiqueta = new ArrayList<>();
        Etiquetas stetiqueta =null;
        String sqlC="SELECT Etiqueta_Id, Nombre, Creado, Actualizado FROM Etiquetas "  ;
       
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, null);
            while (rst.next()){
            stetiqueta = new Etiquetas();
            stetiqueta.setEtiqueta_Id(rst.getInt(1));
            stetiqueta.setNombre(rst.getString(2));
            stetiqueta.setCreado(rst.getDate(3));
            stetiqueta.setActualizado(rst.getDate(4));    
           lsEtiqueta.add(stetiqueta);
        }
        }catch (Exception e) {
            System.out.print("Error" + e.getMessage());
        }finally {
            if(con!=null){
                con.desconectar();
        }
    }
        return lsEtiqueta;
       
        
    }


    
}
