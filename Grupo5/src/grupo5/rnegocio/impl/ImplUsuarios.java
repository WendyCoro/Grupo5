package grupo5.rnegocio.impl;

import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import gupo5.accesodatos.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImplUsuarios implements IUsuario{
    
    @Override
    public int insertar(Usuario usuario) throws Exception{
        int numFilasAfectadas=0;
        String sql="insert into Usuario values(?,?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, usuario.getId()));
        lstPar.add(new Parametro(2, usuario.getNombre()));
        lstPar.add(new Parametro(3, usuario.getEmail()));
        lstPar.add(new Parametro(4, usuario.getPassword()));
        lstPar.add(new Parametro(5, usuario.getRoles().getId()));
        lstPar.add(new Parametro(6, usuario.getCreado()));
        lstPar.add(new Parametro(7, usuario.getActualizado()));
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
    public List<Usuario> obtener() throws Exception{
    List<Usuario> lista = new ArrayList<>();
        String sql="SELECT * FROM Usuario;";
        Conexion con = null;
        try{
            Usuario usuario = null;
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            while (rst.next()){
                usuario = new Usuario();
                usuario.setId(rst.getInt(1));
                usuario.setNombre(rst.getString(2));
                usuario.setEmail(rst.getString(3));
                usuario.setPassword(rst.getString(4));
                usuario.setCreado(rst.getDate(6));
                usuario.setActualizado(rst.getDate(6));
                IRoles rolesdao = new ImplRoles();
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
    public Usuario obtener(int codigo) throws Exception{
        return null;
        
    }  
    
}

