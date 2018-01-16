package grupo5.rnegocio.impl;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import gupo5.accesodatos.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImplUsuario implements IUsuario{
    
    @Override
    public int insertar(Usuario usuario) throws Exception{
        int numFilasAfectadas=0;
        String sql="INAER INTO Usuario (Usuario_Id,Nombre,Email,Password,Roles_Id)values(?,?,?,?,?,?,?)";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, usuario.getUsuario_Id()));
        lstPar.add(new Parametro(2, usuario.getNombre()));
        lstPar.add(new Parametro(3, usuario.getEmail()));
        lstPar.add(new Parametro(4, usuario.getPassword()));
        lstPar.add(new Parametro(5, usuario.getRoles().getRoles_Id()));
        if (usuario.getCreado() instanceof java.sql.Date){
            lstPar.add (new Parametro(6,new java.sql.Date(((java.util.Date) usuario.getCreado()).getTime())));
        }else {
            lstPar.add (new Parametro(6, usuario.getCreado()));
        }
        if (usuario.getCreado() instanceof java.sql.Date){
            lstPar.add (new Parametro(7,new java.sql.Date(((java.util.Date) usuario.getActualizado()).getTime())));
        }else {
            lstPar.add (new Parametro(7, usuario.getActualizado()));
        }
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

   public int modificar (Usuario usuario) throws Exception{
         int numFilasAfectadas=0;
        String sql="UPDATE  Niveles SET  Niveles_Id=? ,Nombre=? ,Creado=? ,Actualizado=? WHERE NIveles_Id=?"  ;
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, usuario.getUsuario_Id()));
        lstPar.add(new Parametro(2, usuario.getNombre()));
        lstPar.add(new Parametro(3, usuario.getEmail()));
        lstPar.add(new Parametro(4, usuario.getPassword()));
        lstPar.add(new Parametro(5, usuario.getRoles().getRoles_Id()));
        if (usuario.getCreado() instanceof java.sql.Date){
            lstPar.add (new Parametro(6,new java.sql.Date(((java.util.Date) usuario.getCreado()).getTime())));
        }else {
            lstPar.add (new Parametro(6, usuario.getCreado()));
        }
        if (usuario.getCreado() instanceof java.sql.Date){
            lstPar.add (new Parametro(7,new java.sql.Date(((java.util.Date) usuario.getActualizado()).getTime())));
        }else {
            lstPar.add (new Parametro(7, usuario.getActualizado()));
        }
        lstPar.add(new Parametro(7, usuario.getUsuario_Id()));
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
    
    public int eliminar (Usuario usuario) throws Exception{
         int numFilasAfectadas=0;
        String sql="DELETE FROM  Usuario  WHERE Usuario_Id=?"  ;
        ArrayList<Parametro> lstPar =new ArrayList<>();
        lstPar.add(new Parametro(1, usuario.getUsuario_Id()));
    
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            numFilasAfectadas=con.ejecutarComando(sql, lstPar);
        }catch (Exception e) {
            System.out.print("Error" + e.getMessage());
        }finally {
            if(con!=null){
            con.desconectar();
        }
        }
        return numFilasAfectadas;
    }  
    
    
     @Override
    public Usuario obtener(long Usuario_Id) throws Exception{
        Usuario listusuario =null;
        String sql="SELECT Usuario_Id, Nombre, Email,Password,Roles_Id,Creado, Actualizado FROM Usuario WHERE Usuario_Id=? "  ;
        ArrayList<Parametro> lstPar =new ArrayList<>();
        lstPar.add(new Parametro(1, Usuario_Id));
    
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            Roles nRol= null;
            IRoles rol =new ImplRoles();
            while (rst.next()){
           nRol = new Roles();
            listusuario.setUsuario_Id(rst.getInt(1));
            listusuario.setNombre(rst.getString(2));
            listusuario.setEmail(rst.getString(3));
            listusuario.setPassword(rst.getString(4));
           nRol= rol.obtener(rst.getLong(5));
            listusuario.setRoles(nRol);
            listusuario.setCreado(rst.getDate(6));
            listusuario.setActualizado(rst.getDate(7));    
        }
        }catch (Exception e) {
            System.out.print("Error" + e.getMessage());
        }finally {
            if(con!=null){
            con.desconectar();
            }
        }
        return listusuario ;  
    }
    
    
     @Override
    public ArrayList<Usuario> obtener() throws Exception{
    ArrayList<Usuario> listau = new ArrayList<>();
        String sql="SELECT * FROM Usuario;";
        Conexion con = null;
        try{
            Roles nRol = null;
            IRoles obRol =new ImplRoles();
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql, null);
            while (rst.next()){
                Usuario usuario = new Usuario();
                nRol= new Roles();
                usuario.setUsuario_Id(rst.getInt(1));
                usuario.setNombre(rst.getString(2));
                usuario.setEmail(rst.getString(3));
                usuario.setPassword(rst.getString(4));
                nRol = obRol.obtener(rst.getLong(5));
                usuario.setRoles(nRol);
                usuario.setCreado(rst.getDate(6));
                usuario.setActualizado(rst.getDate(7));
                 
                listau.add(usuario);
           }
        }catch (Exception e) {
            throw e;
        }finally {
            if(con!=null)
            con.desconectar();
        }
        return listau;
   
    
}
}

