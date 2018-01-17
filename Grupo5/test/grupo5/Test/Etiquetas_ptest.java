package grupo5.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import grupo5.rnegocio.dao.IEtiquetas_publicaciones;
import grupo5.rnegocio.entidades.Etiquetas;
import grupo5.rnegocio.entidades.Etiquetas_publicaciones;
import grupo5.rnegocio.entidades.Niveles;
import grupo5.rnegocio.entidades.Publicaciones;
import grupo5.rnegocio.entidades.Roles;
import grupo5.rnegocio.entidades.Usuarios;
import grupo5.rnegocio.impl.EtiquetaspImpl;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author Wen
 */
public class Etiquetas_ptest {

    public Etiquetas_ptest() {
    }

    @Test
    public void testGeneral() {
        IEtiquetas_publicaciones epDao = new EtiquetaspImpl();
        ///////////INSERTAR TEST
//        int filas = 0;
//
        Roles ro = new Roles(1, "Michu", new java.util.Date(), new java.util.Date());
        Niveles nive = new Niveles(1, "Michu", new java.util.Date(), new java.util.Date());
        Usuarios usua = new Usuarios(1, "Michu", "ao@gmail.com", "12", ro, new java.util.Date(), new java.util.Date());
        Publicaciones publi = new Publicaciones(1, usua, nive, "casa", "ropa", 1, 1, 1.5, new java.util.Date(), new java.util.Date());
        Etiquetas eti = new Etiquetas(1, "Michu", new java.util.Date(), new java.util.Date());
        Etiquetas_publicaciones etipubli = new Etiquetas_publicaciones(1, eti, publi, new java.util.Date(), new java.util.Date());

//        try {
//            filas = epDao.insertar(etipubli);
//            System.out.println("Filas insertadas: " + filas);
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//        assertEquals(filas > 0, true);
        ////LISTAR POR CODIGO TEST
//      Etiquetas_publicaciones epu = new Etiquetas_publicaciones();
//     try {
//          epu = epDao.obtener(1);
//          System.out.println("CODIGO_EP " + " CODIGO_E" + " CODIGO_P" + " CREADO " + "      ACTUALIZADO ");
//          System.out.println(epu.getId_ep() + "             " + epu.getEtiquetas().getId_e() + "        " + epu.getPublicaciones().getId_p() + "    " + epu.getCreado() + "   " + epu.getActualizado());
//      } catch (Exception e) {
//          System.out.println("error: " + e.getMessage());
//      }
//      assertEquals(epu != null, true);
////////////        //// test listado
//       
//        ArrayList<Etiquetas_publicaciones> etipu = new ArrayList<>();
//        try {
//            etipu = epDao.obtener();
//            for (Etiquetas_publicaciones nup : etipu) {
//                System.out.println("CODIGO_EP " + " CODIGO_E" + " CODIGO_P" + " CREADO " + "      ACTUALIZADO ");
//                System.out.println(nup.getId_ep() + "             " + nup.getEtiquetas().getId_e() + "        " + nup.getPublicaciones().getId_p() + "    " + nup.getCreado() + "   " + nup.getActualizado());
//            }
//        } catch (Exception e) {
//            System.out.println("error: " + e.getMessage());
//        }
//        assertEquals(etipu != null, true);
    }
}
