package grupo5.rnegocio.impl;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import gupo5.accesodatos.*;

public class EtiquetaspImpl implements IEtiquetas_publicaciones {
 @Override
    public int insertar(Etiquetas_publicaciones etiqueta_publicacion) throws Exception{
        int numFilasAfectadas=0;
        String sql="insert into etiqueta_publicacion values(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();      
        lstPar.add(new Parametro(1, etiqueta_publicacion.getEtiquetas().getId_e()));
        lstPar.add(new Parametro(2, etiqueta_publicacion.getPublicaciones().getId_p()));
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
        
        String sql="SELECT * FROM etiqueta_publicacion;";
        Conexion con = null;
        try{
            Etiquetas_publicaciones etiqueta_publicacion = null;
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            while (rst.next()){
                etiqueta_publicacion = new Etiquetas_publicaciones();                
                IEtiquetas etiquetasdao = new EtiquetasImpl();
                Etiquetas etiquetas = etiquetasdao.obtener(rst.getLong(1));
                etiqueta_publicacion.setEtiquetas(etiquetas);
                IPublicaciones nivelesdao = new PublicacionesImpl();
                Publicaciones niveles = nivelesdao.obtener(rst.getInt(2));
                etiqueta_publicacion.setPublicaciones(niveles);
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
