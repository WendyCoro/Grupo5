package grupo5.rnegocio.impl;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import gupo5.accesodatos.*;

public class UsuariosImpl implements IUsuarios{

    @Override
    public int insertar(Usuarios usuario) throws Exception{
        int numFilasAfectadas=0;
        String sql="insert into usuario values(?,?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, usuario.getId_u()));
        lstPar.add(new Parametro(2, usuario.getNombre()));
        lstPar.add(new Parametro(3, usuario.getEmail()));
        lstPar.add(new Parametro(4, usuario.getPassword()));
        lstPar.add(new Parametro(5, usuario.getRoles().getId_r()));
        lstPar.add(new Parametro(6, usuario.getCreado()));
        lstPar.add(new Parametro(7, usuario.getActualizado()));        
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
    public List<Usuarios> obtener() throws Exception{
        List<Usuarios> lista = new ArrayList<>();
        
        String sql="SELECT * FROM usuario;";
        Conexion con = null;
        try{
            Usuarios usuario = null;
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            while (rst.next()){
                usuario = new Usuarios();
                usuario.setId_u(rst.getLong(1));
                usuario.setNombre(rst.getString(2));
                usuario.setEmail(rst.getString(3));
                usuario.setPassword(rst.getString(4));
                usuario.setCreado(rst.getDate(6));
                usuario.setActualizado(rst.getDate(7));
                IRoles rolesdao = new RolesImpl();
                Roles roles = rolesdao.obtener(rst.getInt(5));
                usuario.setRoles(roles);
                lista.add(usuario);                       
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
    public Usuarios obtener(long codigo) throws Exception{
        Usuarios usuario = null;
        String sql="SELECT * FROM usuario where id_u=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()){
                usuario = new Usuarios();
                usuario.setId_u(rst.getLong(1));
                usuario.setNombre(rst.getString(2));
                usuario.setEmail(rst.getString(3));
                usuario.setPassword(rst.getString(4));
                usuario.setCreado(rst.getDate(6));
                usuario.setActualizado(rst.getDate(7));
                IRoles rolesdao = new RolesImpl();
                Roles roles = rolesdao.obtener(rst.getInt(5));
                usuario.setRoles(roles);
            }
        }catch (Exception e) {
            throw e;
        }finally {
            if(con!=null)
            con.desconectar();
        }
        return usuario;
    }  
}