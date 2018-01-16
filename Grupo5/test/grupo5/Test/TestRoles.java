package grupo5.Test;
import gupo5.accesodatos.*;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import grupo5.rnegocio.impl.*;
import org.junit.Test;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestRoles {
    public TestRoles() {
    }
    @Test
    public void testGeneral() {
        IRoles rolDao=new ImplRoles();
//        //TEST INSERTAR
        int filas=0;
        Roles nuevoRol=new Roles(654, "diego", new Date(), new Date());
        try {
            filas=rolDao.insertar(nuevoRol);
            System.out.println("filas Insertadas:"+filas+"\n");
        } catch (Exception e) {
        }
        assertEquals(filas>0, true);
//        //TEST OBTENER POR CODIGO
        Roles role=new Roles();
        try {
            role=rolDao.obtener(2313);
            System.out.println(role.getRoles_Id()+"    "+role.getNombre()+"    "+role.getCreado()+"    "+role.getActualizado()+"\n");
        } catch (Exception e) {
        }
//        //TEST LISTADO
        ArrayList<Roles> roles=new ArrayList<>();
        try {
            roles=rolDao.obtener();
            for(Roles rol:roles){
                System.out.println(rol.getRoles_Id()+" "+rol.getNombre()+" "+rol.getCreado()+" "+rol.getActualizado());
            }
        } catch (Exception e) {
        }
        assertTrue(roles.size()>0);
    }
}
    

