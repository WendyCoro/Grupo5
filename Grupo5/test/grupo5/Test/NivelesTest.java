package grupo5.Test;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import grupo5.rnegocio.impl.*;

public class NivelesTest {
   public NivelesTest() {
    }
    @Test
    public void pruebageneral(){
        //              INSERTAR
        int filasAfectadas =0;
        INiveles nivelesDao = new NivelesImpl();
        Niveles niveles = new Niveles(174,"jnijk",new Date(),new Date());
        try{
            filasAfectadas = nivelesDao.insertar(niveles);
            System.out.println("Nivel ingresado!!!");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE NIVELES
        List<Niveles> lista = new ArrayList<>();
        try {
            lista = nivelesDao.obtener();
            for (Niveles n:lista){
                System.out.println("Id:nivel :"+n.getId_n());
                System.out.println("Nombre :"+n.getNombre());
                System.out.println("Fecha de creacion :"+n.getCreado());
            System.out.println("Fecha de actualizacion :"+n.getActualizado());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }

}