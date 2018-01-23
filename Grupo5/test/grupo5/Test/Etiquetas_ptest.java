package grupo5.Test;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import grupo5.rnegocio.impl.*;

public class Etiquetas_ptest {
public Etiquetas_ptest() {
    }
    @Test
    public void pruebageneral() throws Exception{
        //              INSERTAR
        int filasAfectadas =0;
        IEtiquetas_publicaciones etiquetaspDao = new EtiquetaspImpl();
        IEtiquetas etiquetasDao = new EtiquetasImpl();
        Etiquetas etiqueta = etiquetasDao.obtener(1234);
        IPublicaciones publicacionesDao = new PublicacionesImpl();
        Publicaciones publicacion = publicacionesDao.obtener(182);
        Etiquetas_publicaciones etiqueta_publicacion = new Etiquetas_publicaciones(etiqueta,publicacion,new Date(),new Date());
        try{
            filasAfectadas = etiquetaspDao.insertar(etiqueta_publicacion);
            System.out.println("Ingresado!!!");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE PEdido
        List<Etiquetas_publicaciones> lista = new ArrayList<>();
        try {
            lista = etiquetaspDao.obtener();
            for (Etiquetas_publicaciones ep:lista){               
                System.out.println("Etiqueta :"+ep.getEtiquetas().getId_e());
                System.out.println("Publicacion :"+ep.getPublicaciones().getId_p());
                System.out.println("Fecha creado :"+ep.getCreado());
                System.out.println("Fecha actualizado :"+ep.getActualizado());
                
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }

}
