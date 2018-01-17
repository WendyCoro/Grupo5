package grupo5.Test;
import gupo5.accesodatos.*;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import grupo5.rnegocio.impl.*;
import org.junit.Test;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestUsuario {
    public class TestRol {
    }
    @Test
    public void testGeneral() throws Exception {
        //              INSERTAR
        int filasAfectadas =0;
        IUsuario usuarioDao = new ImplUsuario();
        IRoles rolDao = new ImplRoles();
        Roles rol = rolDao.obtener(1);
        Usuario usuario = new Usuario(2,"nombre3","email3","password3",rol,new Date(),new Date());
        
        try{
            filasAfectadas = usuarioDao.insertar(usuario);
            System.out.println("Ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE PEdido
        List<Usuario> lista = new ArrayList<>();
        try {
            lista = usuarioDao.obtener();
            for (Usuario c:lista){
                System.out.println("Id_usuario :"+c.getUsuario_Id());
                System.out.println("Nombre :"+c.getNombre());
                System.out.println("Email :"+c.getEmail());
                System.out.println("Contraseña :"+c.getPassword());
                System.out.println("Fecha de creacion :"+c.getCreado());
                System.out.println("Fecha de actualizacion :"+c.getActualizado());
                System.out.println("Rol :"+c.getRoles().getRoles_Id());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }

}



