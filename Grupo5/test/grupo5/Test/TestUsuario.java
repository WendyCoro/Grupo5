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
    public void testGeneral() {
        IUsuario usuarioDao = new ImplUsuario();
        //TEST INSERTAR
        int filas = 0;
        Roles nRol = new Roles(123, "Jhon", new Date(), new Date());
        Usuario user = new Usuario(973, "Mishell", "Viteri", "ulha", nRol, new Date(), new Date());
        try {
            filas = usuarioDao.insertar(user);
            System.out.println("filas Insertadas:" + filas);
        } catch (Exception e) {
        }
        assertEquals(filas > 0, true);
        //TEST OBTENER POR CODIGO
        Usuario usuario = new Usuario();
        try {
            usuario = usuarioDao.obtener(874);
            System.out.println(usuario.getUsuario_Id() + "    " + usuario.getNombre() + "    " + usuario.getEmail() + "    " + usuario.getPassoword() + "    " + usuario.getRoles().getRoles_Id() + "    " + usuario.getCreado() + "    " + usuario.getActualizado() + "\n\n");
        } catch (Exception e) {
        }
        assertEquals(usuario != null, true);
        //TEST LISTADO
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            usuarios = usuarioDao.obtener();
            for (Usuario nUsuario : usuarios) {
                System.out.println(nUsuario.getUsuario_Id() + "    " + nUsuario.getNombre() + "    " + nUsuario.getEmail() + "    " + nUsuario.getPassoword() + "    " + nUsuario.getRoles().getRoles_Id() + "    " + nUsuario.getCreado() + "    " + nUsuario.getActualizado());
            }
        } catch (Exception e) {
        }
        assertTrue(usuarios.size() > 0);
    }

}
