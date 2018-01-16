package grupo5.Test;
import gupo5.accesodatos.*;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import grupo5.rnegocio.impl.*;
import org.junit.Test;
import java.util.*;
import org.junit.Test;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestEtiquetas_publicaciones {
    public TestEtiquetas_publicaciones() {
    }
    @Test
    public void testGeneral() {
        IEtiquetas_publicaciones etiqPublicDao = new ImplEtiquetas_publicaciones();
        //TEST INSERTAR
        int filas = 0;
        Etiquetas etiq=new Etiquetas(864, "Diego", new Date(), new Date());
        Roles nRol = new Roles(123, "Wendy", new Date(), new Date());
        Usuario user = new Usuario(973, "Angel", "Ramos", "ulha", nRol, new Date(), new Date());
        Niveles nuevoNivel=new Niveles(222, "Daniel", new Date(), new Date());
        Publicaciones pulblicar=new Publicaciones(349, user, nuevoNivel, "123532", "abcd", 15, 35, 7.5, new Date(), new Date());
        Etiquetas_publicaciones nEtiqPublic=new Etiquetas_publicaciones(etiq, pulblicar, new Date(), new Date());
        try {
            filas = etiqPublicDao.insertar(nEtiqPublic);
            System.out.println("filas Insertadas:" + filas);
        } catch (Exception e) {
        }
        assertEquals(filas > 0, true);
//        TEST OBTENER POR CODIGO
        Etiquetas_publicaciones etiqPubli = new Etiquetas_publicaciones();
        try {
            etiqPubli = etiqPublicDao.obtener(1719,2345);
            System.out.println(etiqPubli.getEtiquetas().getEtiqueta_Id()+ "    " + etiqPubli.getPublicaciones().getPublicaciones_Id()+ "    " + etiqPubli.getCreado()+ "    " + etiqPubli.getActualizado()+ "\n\n");
        } catch (Exception e) {
        }
        assertEquals(etiqPubli != null, true);
        //TEST LISTADO
        ArrayList<Etiquetas_publicaciones> etiqPublies = new ArrayList<>();
        try {
            etiqPublies = etiqPublicDao.obtener();
            for (Etiquetas_publicaciones etiPubli : etiqPublies) {
                System.out.println(etiPubli.getEtiquetas().getEtiqueta_Id()+ "    " + etiPubli.getPublicaciones().getPublicaciones_Id()+ "    " + etiqPubli.getCreado()+ "    " + etiqPubli.getActualizado());
            }
        } catch (Exception e) {
            System.out.println("error: "+e.getMessage());
        }
        assertTrue(etiqPublies.size() > 0);
    }
}
