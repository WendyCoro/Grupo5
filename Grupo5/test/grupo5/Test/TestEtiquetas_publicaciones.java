package grupo5.Test;
import gupo5.accesodatos.*;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import grupo5.rnegocio.impl.*;
import org.junit.Test;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestEtiquetas_publicaciones {
    public TestEtiquetas_publicaciones() {
    }
    @Test
    public void testGeneral() throws Exception {
          //              INSERTAR
        int filasAfectadas =0;
        IEtiquetas_publicaciones etiqueta_publicacionDao = new ImplEtiquetas_publicaciones();
        IEtiquetas etiquetasDao = new ImplEtiquetas();
        Etiquetas etiquetas = etiquetasDao.obtener(1);
        IPublicaciones publicacionDao = new ImplPublicaciones();
        Publicaciones publicacion = publicacionDao.obtener(2);
        Etiquetas_publicaciones etiqueta_publicacion = new Etiquetas_publicaciones(etiquetas,publicacion,new Date(),new Date());
        
        try{
            filasAfectadas = etiqueta_publicacionDao.insertar(etiqueta_publicacion);
            System.out.println("Ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE PEdido
        List<Etiquetas_publicaciones> lista = new ArrayList<>();
        try {
            lista = etiqueta_publicacionDao.obtener();
            for (Etiquetas_publicaciones c:lista){
                
                System.out.println("Etiqueta :"+c.getEtiquetas().getEtiqueta_Id());
                System.out.println("Publicacion :"+c.getPublicaciones().getPublicaciones_Id());
                System.out.println("Fecha creado :"+c.getCreado());
                System.out.println("Fecha actualizado :"+c.getActualizado());
                
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }

}
