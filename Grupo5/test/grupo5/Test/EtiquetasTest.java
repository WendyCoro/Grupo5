package grupo5.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import grupo5.rnegocio.dao.IEtiquetas;
import grupo5.rnegocio.entidades.Etiquetas;
import grupo5.rnegocio.impl.EtiquetasImpl;
import java.util.ArrayList;
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
public class EtiquetasTest {
    
    public EtiquetasTest() {
    }
    
    @Test
    public void testGeneral() {
        IEtiquetas etiquetasDao = new EtiquetasImpl();
//            // TEST INSERTAR
//
            int filas = 0;
            Etiquetas etiqueta=new Etiquetas(1, "Michu", new java.util.Date(), new java.util.Date());
            try {
                filas = etiquetasDao.insertar(etiqueta);
                System.out.println("Ingreso de " + filas + " Filas Correctas");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            assertEquals(filas > 0, true);

            //TEST OBTENER POR CODIGO
//        
//        Etiquetas etiqueta =new Etiquetas();
//        try {
//            etiqueta=etiquetasDao.obtener(1);
//            System.out.println("            "+etiqueta.getId_e()+"    "+etiqueta.getNombre()+"    "+etiqueta.getCreado()+"    "+etiqueta.getActualizado());
//        } catch (Exception e) {
//        }
//        //*------------------------------------------------------------------------------------------------------------------------------------*
////        
//            //TEST LISTADO
//            ArrayList<Etiquetas> etiquetass = new ArrayList<>();
//            try {
//                etiquetass = etiquetasDao.obtener();
//                for (Etiquetas etiquetat : etiquetass) {
//                    System.out.println(etiquetat.getId_e() + " " + etiquetat.getNombre() + " " + etiquetat.getCreado() + " " + etiquetat.getActualizado());
//                }
//            } catch (Exception e) {
//            }
//            assertEquals(etiquetass!= null, true);
    }
}
