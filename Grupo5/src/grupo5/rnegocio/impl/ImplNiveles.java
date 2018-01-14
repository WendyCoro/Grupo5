
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
        String sql="insert into Niveles values(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, niveles.getNiveles_Id()));
        lstPar.add(new Parametro(2, niveles.getNombre()));
        lstPar.add(new Parametro(3, niveles.getCreado()));
        lstPar.add(new Parametro(4, niveles.getActualizado()));
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
    public List<Niveles> obtener() throws Exception{
    List<Niveles> lista = new ArrayList<>();
        String sql="SELECT * FROM niveles;";
        Conexion con = null;
        try{
            Niveles niveles = null;
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            while (rst.next()){
                niveles = new Niveles();
               // niveles.getId_Niveles(rst.getInt(1));
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
 
   @Override
    public Niveles obtener(int codigo) throws Exception{
        return null;
        
    }  
  
    
}
