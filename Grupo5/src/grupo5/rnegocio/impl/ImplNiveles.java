
package grupo5.rnegocio.impl;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import gupo5.accesodatos.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImplNiveles implements INiveles{
    @Override
    public int insertar(Niveles niveles) throws Exception{
        int numFilasAfectadas=0;
        String sql="INSERT INTO Niveles(Niveles_Id,Nombre,Creado,Actualizado) VALUES (?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, niveles.getNiveles_Id()));
        lstPar.add(new Parametro(2, niveles.getNombre()));
        if (niveles.getCreado() instanceof java.sql.Date){
            lstPar.add (new Parametro(3,new java.sql.Date(((java.util.Date) niveles.getCreado()).getTime())));
        }else {
            lstPar.add (new Parametro(3, niveles.getCreado()));
        }
        if (niveles.getCreado() instanceof java.sql.Date){
            lstPar.add (new Parametro(4,new java.sql.Date(((java.util.Date) niveles.getActualizado()).getTime())));
        }else {
            lstPar.add (new Parametro(4, niveles.getActualizado()));
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
    
    public int modificar (Niveles niveles ) throws Exception{
         int numFilasAfectadas=0;
        String sql="UPDATE  Niveles SET  Niveles_Id=? ,Nombre=? ,Creado=? ,Actualizado=? WHERE NIveles_Id=?"  ;
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, niveles.getNiveles_Id()));
        lstPar.add(new Parametro(2, niveles.getNombre()));
        if (niveles.getCreado() instanceof java.sql.Date){
            lstPar.add (new Parametro(3,new java.sql.Date(((java.util.Date) niveles.getCreado()).getTime())));
        }else {
            lstPar.add (new Parametro(3, niveles.getCreado()));
        }
        if (niveles.getCreado() instanceof java.sql.Date){
            lstPar.add (new Parametro(4,new java.sql.Date(((java.util.Date) niveles.getActualizado()).getTime())));
        }else {
            lstPar.add (new Parametro(4, niveles.getActualizado()));
        }
        lstPar.add(new Parametro(5,niveles.getNiveles_Id()));
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
    public int eliminar (Niveles niveles) throws Exception{
         int numFilasAfectadas=0;
        String sql="DELETE FROM  NIveles  WHERE Niveles_Id=?"  ;
        ArrayList<Parametro> lstPar =new ArrayList<>();
        lstPar.add(new Parametro(1, niveles.getNiveles_Id()));
    
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
    public Niveles obtener(long Niveles_Id) throws Exception{
        Niveles lisniveles =null;
        String sql="SELECT Niveles_Id, Nombre, Creado, Actualizado FROM Niveles WHERE Niveles_Id=? "  ;
        ArrayList<Parametro> lstPar =new ArrayList<>();
        lstPar.add(new Parametro(1, Niveles_Id));
    
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()){
            lisniveles = new Niveles();
            lisniveles.setNiveles_Id(rst.getInt(1));
            lisniveles.setNombre(rst.getString(2));
            lisniveles.setCreado(rst.getDate(3));
            lisniveles.setActualizado(rst.getDate(4));    
        }
        }catch (Exception e) {
            System.out.print("Error" + e.getMessage());
        }finally {
            if(con!=null){
            con.desconectar();
            }
        }
        return lisniveles;  
    }
    
    
    @Override
    public ArrayList<Niveles> obtener() throws Exception{
    ArrayList<Niveles> lista = new ArrayList<>();
        String sql="SELECT Niveles_Id,Nombre, Creado, Actuaizado FROM Niveles;";
        Conexion con = null;
        try{
            Niveles niveles = null;
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            while (rst.next()){
                niveles = new Niveles();
                niveles.setNiveles_Id(rst.getInt(1));
                niveles.setNombre(rst.getString(2));
                niveles.setCreado(rst.getDate(3));
                niveles.setActualizado(rst.getDate(4));
                lista.add(niveles);
           }
        }catch (Exception e) {
            throw e;
        }finally {
            if(con!=null)
            con.desconectar();
        }
        return lista;
    }  
  
  
    
}
