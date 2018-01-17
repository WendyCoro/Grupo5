package grupo5.rnegocio.impl;

import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import gupo5.accesodatos.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImplRoles implements IRoles{
    @Override
    public int insertar(Roles rol) throws Exception{
        int numFilasAfectadas=0;
        String sql="insert into Roles values(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, rol.getRoles_Id()));
        lstPar.add(new Parametro(2, rol.getNombre()));
        lstPar.add(new Parametro(3, rol.getCreado()));
        lstPar.add(new Parametro(4, rol.getActualizado()));
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
    public List<Roles> obtener() throws Exception{
        List<Roles> lista = new ArrayList<>();
        
        String sql="SELECT * FROM Roles;";
        Conexion con = null;
        try{
            Roles rol = null;
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            while (rst.next()){
                rol = new Roles();
                rol.setRoles_Id(rst.getLong(1));
                rol.setNombre(rst.getString(2));
                rol.setCreado(rst.getDate(3));
                rol.setActualizado(rst.getDate(4));
                lista.add(rol);
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
    public Roles obtener(long codigo) throws Exception{
        Roles rol = null;
        String sql="SELECT * FROM Roles where Roles_Id=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()){
                rol = new Roles();
                rol.setRoles_Id(rst.getLong(1));
                rol.setNombre(rst.getString(2));
                rol.setCreado(rst.getDate(3));
                rol.setActualizado(rst.getDate(4));
            }
        }catch (Exception e) {
            throw e;
        }finally {
            if(con!=null)
            con.desconectar();
        }
        return rol;
    }  
}