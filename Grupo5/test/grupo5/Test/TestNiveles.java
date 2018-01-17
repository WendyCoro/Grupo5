package grupo5.Test;
import gupo5.accesodatos.*;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import grupo5.rnegocio.impl.*;
import org.junit.Test;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestNiveles {
    public TestNiveles() {
    }
    @Test
    public void testGeneral(){
         //              INSERTAR
        int filasAfectadas =0;
        INiveles nivelDao = new ImplNiveles();
        Niveles nivel = new Niveles(1,"jnijk",new Date(),new Date());
        try{
            filasAfectadas = nivelDao.insertar(nivel);
            System.out.println("Nivel ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE NIVELES
        List<Niveles> lista = new ArrayList<>();
        try {
            lista = nivelDao.obtener();
            for (Niveles c:lista){
                System.out.println("Id:nivel :"+c.getNiveles_Id());
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