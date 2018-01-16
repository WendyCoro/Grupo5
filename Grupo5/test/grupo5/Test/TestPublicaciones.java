package grupo5.Test;
import gupo5.accesodatos.*;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import grupo5.rnegocio.impl.*;
import org.junit.Test;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestPublicaciones {
    public TestPublicaciones() {
    }
    @Test
    public void testGeneral() {
        IPublicaciones publicDao = new ImplPublicaciones();
        //TEST INSERTAR
        int filas = 0;
        Roles nRol = new Roles(123, "Jhon", new Date(), new Date());
        Usuario user = new Usuario(973, "Mishell", "Viteri", "ulha", nRol, new Date(), new Date());
        Niveles nuevoNivel=new Niveles(222, "jhon", new Date(), new Date());
        Publicaciones pulblicar=new Publicaciones(2345, user, nuevoNivel, "123532", "ljsr", 15, 35, 7.5, new Date(), new Date());
        try {
            filas = publicDao.insertar(pulblicar);
            System.out.println("filas Insertadas:" + filas);
        } catch (Exception e) {
        }
        assertEquals(filas > 0, true);
        //TEST OBTENER POR CODIGO
        Publicaciones publicacion = new Publicaciones();
        try {
            publicacion = publicDao.obtener(2345);
            System.out.println(publicacion.getPublicaciones_Id() + "    " + publicacion.getUsuario().getUsuario_Id()+ "    " + publicacion.getNiveles().getNiveles_Id()+ "    " + publicacion.getTitulo()+ "    " + publicacion.getContenido()+ "    " + publicacion.getPublicado()+ "    " + publicacion.getVistas()+ "    " + publicacion.getCreado()+ "    " + publicacion.getActualizado()+ "    " + publicacion.getVotos()+ "\n\n");
        } catch (Exception e) {
        }
        assertEquals(publicacion != null, true);
        //TEST LISTADO
        ArrayList<Publicaciones> publicaciones = new ArrayList<>();
        try {
            publicaciones = publicDao.obtener();
            for (Publicaciones nPublicacion : publicaciones) {
                System.out.println(nPublicacion.getPublicaciones_Id() + "    " + nPublicacion.getUsuario().getUsuario_Id()+ "    " + nPublicacion.getNiveles().getNiveles_Id()+ "    " + nPublicacion.getTitulo()+ "    " + nPublicacion.getContenido()+ "    " + nPublicacion.getPublicado()+ "    " + nPublicacion.getVistas()+ "    " + nPublicacion.getCreado()+ "    " + nPublicacion.getActualizado()+ "    " + nPublicacion.getVotos());
            }
        } catch (Exception e) {
            System.out.println("error: "+e.getMessage());
        }
        assertTrue(publicaciones.size() > 0);
    }
}
