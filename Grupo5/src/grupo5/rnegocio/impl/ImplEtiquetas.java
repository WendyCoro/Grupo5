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
    public int insertar(Etiquetas etiqueta) throws Exception{
        int numFilasAfectadas=0;
        String sql="insert into Etiquetas values(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, etiqueta.getEtiqueta_Id()));
        lstPar.add(new Parametro(2, etiqueta.getNombre()));
        lstPar.add(new Parametro(3, etiqueta.getCreado()));
        lstPar.add(new Parametro(4, etiqueta.getActualizado()));
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
    public List<Etiquetas> obtener() throws Exception{
        List<Etiquetas> lista = new ArrayList<>();
        
        String sql="SELECT * FROM Etiquetas;";
        Conexion con = null;
        try{
            Etiquetas etiqueta = null;
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            while (rst.next()){
                etiqueta = new Etiquetas();
                etiqueta.setEtiqueta_Id(rst.getLong(1));
                etiqueta.setNombre(rst.getString(2));
                etiqueta.setCreado(rst.getDate(3));
                etiqueta.setActualizado(rst.getDate(4));
                lista.add(etiqueta);
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
    public Etiquetas obtener(long codigo) throws Exception{
        Etiquetas etiqueta = null;
        String sql="SELECT * FROM Etiquetas where Etiqueta_Id=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()){
                etiqueta = new Etiquetas();
                etiqueta.setEtiqueta_Id(rst.getLong(1));
                etiqueta.setNombre(rst.getString(2));
                etiqueta.setCreado(rst.getDate(3));
                etiqueta.setActualizado(rst.getDate(4));
            }
            
        }catch (Exception e) {
            throw e;
        }finally {
            if(con!=null)
            con.desconectar();
        }
        return etiqueta;
    }
    
}