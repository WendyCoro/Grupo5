package grupo5.rnegocio.impl;
import grupo5.rnegocio.entidades.Usuarios;
import grupo5.rnegocio.entidades.Roles;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import gupo5.accesodatos.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuariosImpl implements IUsuarios {

    @Override
    public int insertar(Usuarios usuarios) throws Exception {
        int numFilas = 0;
        String sqlC = "insert into usuarios (id_u, nombre, email, pasword, id_r, creado, actualizado) VALUES (?,?,?,?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, usuarios.getId_u()));
        lisParametros.add(new Parametro(2, usuarios.getNombre()));
        lisParametros.add(new Parametro(3, usuarios.getEmail()));
        lisParametros.add(new Parametro(4, usuarios.getPasword()));
        lisParametros.add(new Parametro(5, usuarios.getRoles().getId_r()));
        if (usuarios.getCreado() instanceof java.util.Date) {
            lisParametros.add(new Parametro(6, new java.sql.Date(((java.util.Date) usuarios.getCreado()).getTime())));
        } else {
            lisParametros.add(new Parametro(6, usuarios.getCreado()));
        }
        if (usuarios.getCreado() instanceof java.util.Date) {
            lisParametros.add(new Parametro(7, new java.sql.Date(((java.util.Date) usuarios.getActualizado()).getTime())));
        } else {
            lisParametros.add(new Parametro(7, usuarios.getActualizado()));
        }

        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilas = con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilas;
    }

    @Override
    public int modificar(Usuarios usuarios) throws Exception {
        int numFilas = 0;
        String sqlC = "UPDATE usuarios SET id_u=?, nombre=?, email=?, pasword=?, id_r=?, creado=?, actualizado=? WHERE id_u=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, usuarios.getId_u()));
        lisParametros.add(new Parametro(2, usuarios.getNombre()));
        lisParametros.add(new Parametro(3, usuarios.getEmail()));
        lisParametros.add(new Parametro(4, usuarios.getPasword()));
        lisParametros.add(new Parametro(5, usuarios.getRoles().getId_r()));
        if (usuarios.getCreado() instanceof java.util.Date) {
            lisParametros.add(new Parametro(6, new java.sql.Date(((java.util.Date) usuarios.getCreado()).getTime())));
        } else {
            lisParametros.add(new Parametro(6, usuarios.getCreado()));
        }
        if (usuarios.getCreado() instanceof java.util.Date) {
            lisParametros.add(new Parametro(7, new java.sql.Date(((java.util.Date) usuarios.getActualizado()).getTime())));
        } else {
            lisParametros.add(new Parametro(7, usuarios.getActualizado()));
        }

        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilas = con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilas;
    }

    @Override
    public int eliminar(Usuarios usuarios) throws Exception {
        int numFilas = 0;
        String sqlC = "DELETE FROM usuarios WHERE id_u=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, usuarios.getId_u()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilas = con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilas;
    }

    @Override
    public Usuarios obtener(int id_u) throws Exception {
        Usuarios nUsuario = null;
        String sqlC = "SELECT id_u, nombre, email, pasword, id_r, creado, actualizado FROM usuarios where id_u=?;";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, id_u));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            Roles nrol = null;
            IRoles roldao = new RolesImpl();
            while (rst.next()) {
                nrol = new Roles();
                nUsuario = new Usuarios();
                nUsuario.setId_u(rst.getInt(1));
                nUsuario.setNombre(rst.getString(2));
                nUsuario.setEmail(rst.getString(3));
                nUsuario.setPasword(rst.getString(4));
                nrol = roldao.obtener(rst.getInt(5));
                nUsuario.setRoles(nrol);
                nUsuario.setCreado(rst.getDate(6));
                nUsuario.setActualizado(rst.getDate(7));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nUsuario;
    }

    @Override
    public ArrayList<Usuarios> obtener() throws Exception {
        ArrayList<Usuarios> listUsuari = new ArrayList<>();
        String sqlC = "SELECT id_u, nombre, email, pasword, id_r, creado, actualizado FROM usuarios";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, null);
            Roles rol = null;
            IRoles roldao = new RolesImpl();
            while (rst.next()) {
                Usuarios nusers = new Usuarios();
                rol = new Roles();    
                nusers.setId_u(rst.getInt(1));
                nusers.setNombre(rst.getString(2));
                nusers.setEmail(rst.getString(3));
                nusers.setPasword(rst.getString(4));
                rol = roldao.obtener(rst.getInt(5));
                nusers.setRoles(rol);
                nusers.setCreado(rst.getDate(6));
                nusers.setActualizado(rst.getDate(7));

                listUsuari.add(nusers);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage()+ " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return listUsuari;
    }
}
