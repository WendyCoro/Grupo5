package grupo5.Test;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import grupo5.rnegocio.impl.*;

public class EtiquetasTest {
    public EtiquetasTest() {
    }
    @Test
    public void pruebageneral(){
        //              INSERTAR
        int filasAfectadas =0;
        IEtiquetas etiquetasDao = new EtiquetasImpl();
        Etiquetas etiqueta = new Etiquetas(1234,"Etiqueta3",new Date(),new Date());
        try{
            filasAfectadas = etiquetasDao.insertar(etiqueta);
            System.out.println("Etiqueta ingresada!!!");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE etiqueta
        List<Etiquetas> lista = new ArrayList<>();
        try {
            lista = etiquetasDao.obtener();
            for (Etiquetas e:lista){
                System.out.println("Id_etiqueta :"+e.getId_e());
                System.out.println("Nombre :"+e.getNombre());
                System.out.println("Fecha de creacion :"+e.getCreado());
            System.out.println("Fecha de actualizacion :"+e.getActualizado());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }

}
