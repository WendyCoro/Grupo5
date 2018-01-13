package grupo5.rnegocio.impl;

import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import gupo5.accesodatos.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImplRoles implements IRoles{
     
    @Override
    public int insertar(Roles roles) throws Exception{
        int numFilasAfectadas=0;
        String sql="insert into Roles values(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, roles.getId()));
        lstPar.add(new Parametro(2, roles.getNombre()));
        lstPar.add(new Parametro(3, roles.getCreado()));
        lstPar.add(new Parametro(4, roles.getActualizado()));
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
    public List<Roles> obtener() throws Exception{
    List<Roles> lista = new ArrayList<>();
        String sql="SELECT * FROM Roles;";
        Conexion con = null;
        try{
            Roles roles = null;
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            while (rst.next()){
                roles = new Roles();
                roles.setId(rst.getInt(1));
                roles.setNombre(rst.getString(2));
                roles.setCreado(rst.getDate(3));
                roles.setActualizado(rst.getDate(4));
                lista.add(roles);
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
    public Roles obtener(int codigo) throws Exception{
        return null;     
    }  
}
