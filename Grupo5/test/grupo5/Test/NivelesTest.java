package grupo5.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import grupo5.rnegocio.dao.INiveles;
import grupo5.rnegocio.entidades.Niveles;
import grupo5.rnegocio.impl.NivelesImpl;
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
public class NivelesTest {
    public NivelesTest() {
    }
        @Test
    public void testGeneral() {
        INiveles nivelesDao = new NivelesImpl();
            // TEST INSERTAR

            int filas = 0;
            Niveles nivel=new Niveles(4, "Wen", new java.util.Date(), new java.util.Date());
            try {
                filas = nivelesDao.insertar(nivel);
                System.out.println("Ingreso de " + filas + " Filas Correctas");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            assertEquals(filas > 0, true);
//
//            //TEST OBTENER POR CODIGO
////        
        Niveles niveles=new Niveles();
        try {
            niveles=nivelesDao.obtener(1);
            System.out.println("            "+niveles.getId_n()+"    "+niveles.getNombre()+"    "+niveles.getCreado()+"    "+niveles.getActualizado());
        } catch (Exception e) {
        }
     
//            //TEST LISTADO
            ArrayList<Niveles> niveless = new ArrayList<>();
            try {
                niveless = nivelesDao.obtener();
                for (Niveles nivelt : niveless) {
                    System.out.println(nivelt.getId_n() + " " + nivelt.getNombre() + " " + nivelt.getCreado() + " " + nivelt.getActualizado());
                }
            } catch (Exception e) {
            }
            assertEquals(niveless!= null, true);
    }
}
//}


