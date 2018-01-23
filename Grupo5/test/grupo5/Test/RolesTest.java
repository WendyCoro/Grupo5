package grupo5.Test;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import grupo5.rnegocio.impl.*;

public class RolesTest {
   public RolesTest() {
    }
    @Test
    public void pruebageneral(){
        //              INSERTAR
        int filasAfectadas =0;
        IRoles rolesDao = new RolesImpl();
        Roles roles = new Roles(144,"Administrador2",new Date(),new Date());
        try{
            filasAfectadas = rolesDao.insertar(roles);
            System.out.println("Rol ingresado!!!");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE ROLES
        List<Roles> lista = new ArrayList<>();
        try {
            lista = rolesDao.obtener();
            for (Roles r:lista){
                System.out.println("Id_rol :"+r.getId_r());
                System.out.println("Nombre :"+r.getNombre());
                System.out.println("Fecha de creacion :"+r.getCreado());
            System.out.println("Fecha de actualizacion :"+r.getActualizado());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }
}