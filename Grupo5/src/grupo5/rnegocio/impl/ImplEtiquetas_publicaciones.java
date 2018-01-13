package grupo5.rnegocio.impl;

import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import gupo5.accesodatos.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ImplEtiquetas_publicaciones implements IEtiquetas_publicaciones{
     private Object Etiqueta_id;
    @Override
    public int insertar(Etiquetas_publicaciones etiquetas_publicaciones) throws Exception{
        int numFilasAfectadas=0;
        String sql="insert into Etiquetas_publicaciones values(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, etiquetas_publicaciones.getEtiqueta_id()));
        lstPar.add(new Parametro(2, etiquetas_publicaciones.getPublicacion_id()));
        lstPar.add(new Parametro(3, etiquetas_publicaciones.getCreado()));
        lstPar.add(new Parametro(4, etiquetas_publicaciones.getActualizado()));
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
    public List<Etiquetas_publicaciones> obtener() throws Exception{
    List<Etiquetas_publicaciones> lista = new ArrayList<>();
        String sql="SELECT * FROM etiquetas_publicaciones;";
        Conexion con = null;
        try{
            Etiquetas_publicaciones etiquetas_publicaciones = null;
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            while (rst.next()){
                etiquetas_publicaciones = new Etiquetas_publicaciones();
                etiquetas_publicaciones.setEtiqueta_id(rst.getInt(1));
                etiquetas_publicaciones.setPublicacion_id(rst.getInt(2));
                etiquetas_publicaciones.setCreado(rst.getDate(3));
                etiquetas_publicaciones.setActualizado(rst.getDate(4));
                lista.add(etiquetas_publicaciones);
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
    public Etiquetas_publicaciones obtener(int codigo) throws Exception{
        return null;
        
    }  
}


