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
        INiveles nivelDao=new ImplNiveles();
//        //TEST INSERTAR
        int filas=0;
        Niveles nuevoNivel=new Niveles(123, "diego", new Date(), new Date());
        try {
            filas=nivelDao.insertar(nuevoNivel);
            System.out.println("filas Insertadas:"+filas+"\n");
        } catch (Exception e) {
        }
        assertEquals(filas>0, true);
//        //TEST OBTENER POR CODIGO
        Niveles nivel=new Niveles();
        try {
            nivel=nivelDao.obtener(222);
            System.out.println(nivel.getNiveles_Id()+"    "+nivel.getNombre()+"    "+nivel.getCreado()+"    "+nivel.getActualizado()+"\n");
        } catch (Exception e) {
        }
        assertEquals(nivel!=null, true);
//        //TEST LISTADO
        ArrayList<Niveles> niveles=new ArrayList<>();
        try {
            niveles=nivelDao.obtener();
            for(Niveles lvl:niveles){
                System.out.println(lvl.getNiveles_Id()+" "+lvl.getNombre()+" "+lvl.getCreado()+" "+lvl.getActualizado());
            }
        } catch (Exception e) {
        }
        assertTrue(niveles.size()>0);
    }
}


