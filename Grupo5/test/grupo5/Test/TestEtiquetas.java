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
          IEtiquetas etiquetaDao=new ImplEtiquetas();
//        //TEST INSERTAR
        int filas=0;
        Etiquetas nuevoEtiqueta=new Etiquetas(1719, "sebas", new Date(), new Date());
        try {
            filas=etiquetaDao.insertar(nuevoEtiqueta);
            System.out.println("filas Insertadas:"+filas+"\n");
        } catch (Exception e) {
        }
        assertEquals(filas>0, true);
//        //TEST OBTENER POR CODIGO
        Etiquetas etiquee=new Etiquetas();
        try {
            etiquee=etiquetaDao.obtener(1719);
            System.out.println(etiquee.getEtiqueta_Id()+"    "+etiquee.getNombre()+"    "+etiquee.getCreado()+"    "+etiquee.getActualizado()+"\n");
        } catch (Exception e) {
        }
//        //TEST LISTADO
        ArrayList<Etiquetas> etiquetas=new ArrayList<>();
        try {
            etiquetas=etiquetaDao.obtener();
            for(Etiquetas etiqueta:etiquetas){
                System.out.println(etiqueta.getEtiqueta_Id()+" "+etiqueta.getNombre()+" "+etiqueta.getCreado()+" "+etiqueta.getActualizado());
            }
        } catch (Exception e) {
        }
        assertTrue(etiquetas.size()>0);
    }
    }


