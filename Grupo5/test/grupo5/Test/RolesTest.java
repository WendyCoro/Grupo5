package grupo5.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import grupo5.rnegocio.dao.IPublicaciones;
import grupo5.rnegocio.dao.IRoles;
import grupo5.rnegocio.entidades.Niveles;
import grupo5.rnegocio.entidades.Publicaciones;
import grupo5.rnegocio.entidades.Roles;
import grupo5.rnegocio.entidades.Usuarios;
import grupo5.rnegocio.impl.PublicacionesImpl;
import grupo5.rnegocio.impl.RolesImpl;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RolesTest {
    
    public RolesTest() {}
    

@Test
    public void testGeneral() {
        IRoles rolesDao = new RolesImpl();
        // TEST INSERTAR
////
////            int filas = 0;
////            Roles rol=new Roles(1, "Michu", new java.util.Date(), new java.util.Date());
////            try {
////                filas = rolesDao.insertar(rol);
////                System.out.println("Ingreso de " + filas + " Filas Correctas");
////            } catch (Exception e) {
////                System.out.println("Error: " + e.getMessage());
////            }
////            assertEquals(filas > 0, true);
////
////          ///  TEST OBTENER POR CODIGO
////        
//            
        Roles roless=new Roles();
        
        try {
            roless=rolesDao.obtener(1);
            System.out.println("            "+roless.getId_r()+"    "+roless.getNombre()+"    "+roless.getCreado()+"    "+roless.getActualizado());
        } catch (Exception e) {
        }
        
          
//        //*------------------------------------------------------------------------------------------------------------------------------------*
////////        
//            //TEST LISTADO
//        ArrayList<Roles> roless = new ArrayList<>();
//        try {
//            roless = rolesDao.obtener();
//            for (Roles rolt : roless) {
//                System.out.println(rolt.getId_r() + " " + rolt.getNombre() + " " + rolt.getCreado() + " " + rolt.getActualizado());
//            }
//        } catch (Exception e) {
//        }
//        assertEquals(roless != null, true);
    }
    
}
