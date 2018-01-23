package grupo5.Test;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import grupo5.rnegocio.impl.*;

public class UsuarioTest {
    public UsuarioTest() {
    }
    @Test
    public void pruebageneral() throws Exception{
        //              INSERTAR
        int filasAfectadas =0;
        IUsuarios usuariosDao = new UsuariosImpl();
        IRoles rolesDao = new RolesImpl();
        Roles roles = rolesDao.obtener(144);
        Usuarios usuarios = new Usuarios(132,"nombre3","email3","password3",roles,new Date(),new Date());
        
        try{
            filasAfectadas = usuariosDao.insertar(usuarios);
            System.out.println("Usuario ingresado!!!");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE PEdido
        List<Usuarios> lista = new ArrayList<>();
        try {
            lista = usuariosDao.obtener();
            for (Usuarios u:lista){
                System.out.println("Id_usuario :"+u.getId_u());
                System.out.println("Nombre :"+u.getNombre());
                System.out.println("Email :"+u.getEmail());
                System.out.println("Contraseña :"+u.getPassword());
                System.out.println("Fecha de creacion :"+u.getCreado());
                System.out.println("Fecha de actualizacion :"+u.getActualizado());
                System.out.println("Rol :"+u.getRoles().getId_r());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }

}



