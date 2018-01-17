package grupo5.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import grupo5.rnegocio.dao.IPublicaciones;
import grupo5.rnegocio.entidades.Niveles;
import grupo5.rnegocio.entidades.Publicaciones;
import grupo5.rnegocio.entidades.Roles;
import grupo5.rnegocio.entidades.Usuarios;
import grupo5.rnegocio.impl.PublicacionesImpl;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

 public class PublicacionesTest {
    
    public PublicacionesTest() {
    }
      @Test
    public void testGeneral() {
        IPublicaciones puDao = new PublicacionesImpl();
///////////INSERTAR TEST
        int filas = 0;

        Niveles nivels = new Niveles(2, "Wendy", new java.util.Date(), new java.util.Date());
        Roles rols = new Roles(3, "Michu", new java.util.Date(), new java.util.Date());
        Usuarios user = new Usuarios(3, "Carlos", "ao@gmail.com", "1295", rols, new java.util.Date(), new java.util.Date());
        Publicaciones per = new Publicaciones(4, user, nivels, "david", "canpos", 7, 2, 1.5, new java.util.Date(), new java.util.Date());
        

        try {
            filas = puDao.insertar(per);
            System.out.println("Filas insertadas: " + filas);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertEquals(filas > 0, true);

//LISTAR POR CODIGO TEST
        Publicaciones up = new Publicaciones();

        try {
            up = puDao.obtener(7);
            System.out.println("CODIGO_P \t" + " CODIGO_U\t" + " CODIGO_N\t" + " TITULO\t " + " CONTENIDO\t" + " VISTAS\t" + " VOTOS " + " CREADO " + "      ACTUALIZADO ");
            System.out.println(up.getId_p() + "             " + up.getUsuarios().getId_u() + "        " + up.getNiveles().getId_n() + "     " + up.getTitulo() + "      " + up.getContenido() + "     " + up.getVistas() + "      " + up.getVotos() + "    " + up.getCreado() + "   " + up.getActualizado());
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
       // assertEquals(up != null, true);
///// test listado
       
              
        ArrayList<Publicaciones> ups = new ArrayList<>();
        
        try {
            ups = puDao.obtener();
            System.out.println("\nCODIGO_P" + "    CODIGO_U" + "        CODIGO_N\t" + "\tTITULO\t\t" + "CONTENIDO  " + "   VISTAS\t" + "\tVOTOS\t\t" + " CREADO\t\t\t" + "ACTUALIZADO\t\t");
  
            for (Publicaciones nup : ups) {
                System.out.println(nup.getId_p() + "\t\t" + nup.getUsuarios().getId_u() + "\t\t" + nup.getNiveles().getId_n() + "\t\t" + nup.getTitulo() + "\t\t" + nup.getContenido() + "\t\t" + nup.getVistas() + "\t\t" + nup.getVotos() + "\t\t" + nup.getCreado() + "\t\t" + nup.getActualizado());
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        assertEquals(ups != null, true);

    }
}
