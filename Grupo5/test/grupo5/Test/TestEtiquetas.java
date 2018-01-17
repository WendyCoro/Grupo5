package grupo5.Test;
import gupo5.accesodatos.*;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import grupo5.rnegocio.impl.*;
import org.junit.Test;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestEtiquetas {
    public TestEtiquetas() {
    }
       @Test
    public void testGeneral() {
         //              INSERTAR
        int filasAfectadas =0;
        IEtiquetas etiquetasDao = new ImplEtiquetas();
        Etiquetas etiquetas = new Etiquetas(1,"Etiqueta3",new Date(),new Date());
        try{
            filasAfectadas = etiquetasDao.insertar(etiquetas);
            System.out.println("Etiqueta ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE etiqueta
        List<Etiquetas> lista = new ArrayList<>();
        try {
            lista = etiquetasDao.obtener();
            for (Etiquetas c:lista){
                System.out.println("Id_etiqueta :"+c.getEtiqueta_Id());
                System.out.println("Nombre :"+c.getNombre());
                System.out.println("Fecha de creacion :"+c.getCreado());
            System.out.println("Fecha de actualizacion :"+c.getActualizado());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }

}