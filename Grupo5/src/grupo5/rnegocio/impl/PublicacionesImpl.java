
package grupo5.rnegocio.impl;

import grupo5.rnegocio.entidades.Usuarios;
import grupo5.rnegocio.entidades.Niveles;
import grupo5.rnegocio.entidades.Publicaciones;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import gupo5.accesodatos.*;
import java.util.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PublicacionesImpl implements IPublicaciones {

    @Override

    public int insertar(Publicaciones publicaciones) throws Exception {
        int filas = 0;
        String csql = "insert into publicaciones (id_p, id_u, id_n, titulo, contenido, publicado, vistas, votos, creado, actualizado) values (?,?,?,?,?,?,?,?,?,?)";
        ArrayList<Parametro> pb = new ArrayList<>();
        pb.add(new Parametro(1, publicaciones.getId_p()));
        pb.add(new Parametro(2, publicaciones.getUsuarios().getId_u()));
        pb.add(new Parametro(3, publicaciones.getNiveles().getId_n()));
        pb.add(new Parametro(4, publicaciones.getTitulo()));
        pb.add(new Parametro(5, publicaciones.getContenido()));
        pb.add(new Parametro(6, publicaciones.getPublicado()));
        pb.add(new Parametro(7, publicaciones.getVistas()));
        pb.add(new Parametro(8, publicaciones.getVotos()));
        if (publicaciones.getCreado() instanceof java.util.Date) {
            pb.add(new Parametro(9, new java.sql.Date(((java.util.Date) publicaciones.getCreado()).getTime())));
        } else {
            pb.add(new Parametro(9, publicaciones.getActualizado()));
        }
        if (publicaciones.getCreado() instanceof java.util.Date) {
            pb.add(new Parametro(10, new java.sql.Date(((java.util.Date) publicaciones.getActualizado()).getTime())));
        } else {
            pb.add(new Parametro(10, publicaciones.getActualizado()));
        }

        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            filas = con.ejecutarComando(csql, pb);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return filas;
    }

    @Override
    public int modificar(Publicaciones publicaciones) throws Exception {
        int filas = 0;
        String csql = "UPDATE publicaciones set id_p=?, id_u=?, id_n=?, titulo=?, contenido=?, publicado=?, vistas=?, votos=?, creado=?, actualizado=? where ip_p=?";
        ArrayList<Parametro> pubs = new ArrayList<>();
        pubs.add(new Parametro(1, publicaciones.getId_p()));
        pubs.add(new Parametro(2, publicaciones.getUsuarios().getId_u()));
        pubs.add(new Parametro(3, publicaciones.getNiveles().getId_n()));
        pubs.add(new Parametro(4, publicaciones.getTitulo()));
        pubs.add(new Parametro(5, publicaciones.getContenido()));
        pubs.add(new Parametro(6, publicaciones.getPublicado()));
        pubs.add(new Parametro(7, publicaciones.getVistas()));
        pubs.add(new Parametro(8, publicaciones.getVotos()));
        pubs.add(new Parametro(9, publicaciones.getCreado()));
        pubs.add(new Parametro(10, publicaciones.getActualizado()));

        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            filas = con.ejecutarComando(csql, pubs);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return filas;
    }

    @Override

    public int eliminar(Publicaciones publicaciones) throws Exception {

        int filas = 0;
        String csql = "DELETE FROM publicaciones WHERE id_p=?";
        ArrayList<Parametro> pubs = new ArrayList<>();
        pubs.add(new Parametro(1, publicaciones.getId_p()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            filas = con.ejecutarComando(csql, pubs);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return filas;

    }

    @Override
    public Publicaciones obtener(int codigo) throws Exception {
        Publicaciones npb = null;

        String csql = "select id_p, id_u, id_n, titulo, contenido, publicado, vistas, votos, creado, actualizado from publicaciones where id_p=?";
        ArrayList<Parametro> pubs = new ArrayList<>();
        pubs.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            Usuarios us = null;
            IUsuarios usuariodao = new UsuariosImpl();
            Niveles nv = null;
            INiveles niveldao = new NivelesImpl();
            ResultSet rst = con.ejecutarQuery(csql, pubs);
            while (rst.next()) {
                us = new Usuarios();
                nv = new Niveles();
                npb = new Publicaciones();
                npb.setId_p(rst.getInt(1));
                us = usuariodao.obtener(rst.getInt(2));
                npb.setUsuarios(us);
                nv = niveldao.obtener(rst.getInt(3));
                npb.setNiveles(nv);
                npb.setTitulo(rst.getString(4));
                npb.setContenido(rst.getString(5));
                npb.setPublicado(rst.getInt(6));
                npb.setVistas(rst.getInt(7));
                npb.setVotos(rst.getDouble(8));
                npb.setCreado(rst.getDate(9));
                npb.setActualizado(rst.getDate(10));

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return npb;

    }

    @Override
    public ArrayList<Publicaciones> obtener() throws Exception {
        Publicaciones pub = null;
        String csql = "select id_p, id_u, id_n, titulo, contenido, publicado, vistas, votos, creado, actualizado from publicaciones";
        ArrayList<Publicaciones> pulb = new ArrayList<>();
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(csql, null);
            while (rst.next()) {
                Usuarios us = null;
                IUsuarios usuariodao = new UsuariosImpl();
                Niveles nv = null;
                INiveles niveldao = new NivelesImpl();
                us = new Usuarios();               
                nv = new Niveles();               
                pub = new Publicaciones();
                pub.setId_p(rst.getInt(1));
                us = usuariodao.obtener(rst.getInt(2));
                pub.setUsuarios(us);
                nv = niveldao.obtener(rst.getInt(3));
                pub.setNiveles(nv);
                pub.setTitulo(rst.getString(4));
                pub.setContenido(rst.getString(5));
                pub.setPublicado(rst.getInt(6));
                pub.setVistas(rst.getInt(7));
                pub.setVotos(rst.getDouble(8));
                pub.setCreado(rst.getDate(9));
                pub.setActualizado(rst.getDate(10));

                pulb.add(pub);

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return pulb;

    }

}
