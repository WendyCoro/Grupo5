package grupo5.rnegocio.impl;

import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import gupo5.accesodatos.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImplEtiquetas implements IEtiquetas{

    @Override
    public int insertar(Etiquetas etiquetas) throws Exception{
        int numFilasAfectadas=0;
        String sql="insert into Etiquetas values(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, etiquetas.getEtiqueta_Id()));
        lstPar.add(new Parametro(2, etiquetas.getNombre()));
        lstPar.add(new Parametro(3, etiquetas.getCreado()));
        lstPar.add(new Parametro(4, etiquetas.getActualizado()));
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
        String sql="SELECT * FROM etiquetas;";
        Conexion con = null;
        try{
            Etiquetas etiquetas = null;
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            while (rst.next()){
                etiquetas = new Etiquetas();
                etiquetas.setEtiqueta_Id(rst.getInt(1));
                etiquetas.setNombre(rst.getString(2));
                etiquetas.setCreado(rst.getDate(3));
                etiquetas.setActualizado(rst.getDate(4));
                lista.add(etiquetas);
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
    public Etiquetas obtener(int codigo) throws Exception{
        return null;
        
    }  
}
