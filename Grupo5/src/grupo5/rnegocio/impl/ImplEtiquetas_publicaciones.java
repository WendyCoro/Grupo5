package grupo5.rnegocio.impl;

import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import gupo5.accesodatos.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ImplEtiquetas_publicaciones implements IEtiquetas_publicaciones{
 
    @Override
    public int insertar(Etiquetas_publicaciones etiqueta_publicacion) throws Exception{
        int numFilasAfectadas=0;
        String sql="insert into Etiquetas_publicaciones values(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1, etiqueta_publicacion.getEtiquetas().getEtiqueta_Id()));
        lstPar.add(new Parametro(2, etiqueta_publicacion.getPublicaciones().getPublicaciones_Id()));
        lstPar.add(new Parametro(3, etiqueta_publicacion.getCreado()));
        lstPar.add(new Parametro(4, etiqueta_publicacion.getActualizado()));
    
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
    public List<Etiquetas_publicaciones> obtener() throws Exception{
        List<Etiquetas_publicaciones> lista = new ArrayList<>();
        
        String sql="SELECT * FROM Etiquetas_publicaciones;";
        Conexion con = null;
        try{
            Etiquetas_publicaciones etiqueta_publicacion = null;
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            while (rst.next()){
                etiqueta_publicacion = new Etiquetas_publicaciones();
                
                IEtiquetas etiquetadao = new ImplEtiquetas();
                Etiquetas etiqueta = etiquetadao.obtener(rst.getLong(1));
                etiqueta_publicacion.setEtiquetas(etiqueta);
                IPublicaciones publicaionesdao = new ImplPublicaciones();
                Publicaciones publicaiones= publicaionesdao.obtener(rst.getLong(2));
                etiqueta_publicacion.setPublicaciones(publicaiones);
                etiqueta_publicacion.setCreado(rst.getDate(3));
                etiqueta_publicacion.setActualizado(rst.getDate(4));
                    lista.add(etiqueta_publicacion);
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

    