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
         //              INSERTAR
        int filasAfectadas =0;
        IRoles rolDao = new ImplRoles();
        Roles rol = new Roles(1,"Administrador2",new Date(),new Date());
        try{
            filasAfectadas = rolDao.insertar(rol);
            System.out.println("Rol ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE ROLES
        List<Roles> lista = new ArrayList<>();
        try {
            lista = rolDao.obtener();
            for (Roles c:lista){
                System.out.println("Id_rol :"+c.getRoles_Id());
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