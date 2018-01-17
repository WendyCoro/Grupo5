package grupo5.Test;
import gupo5.accesodatos.*;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import grupo5.rnegocio.impl.*;
import org.junit.Test;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestPublicaciones {
    public TestPublicaciones() {
    }
    @Test
    public void testGeneral() throws Exception{
        //              INSERTAR
        int filasAfectadas =0;
        IPublicaciones publicacionDao = new ImplPublicaciones();
        IUsuario usuarioDao = new ImplUsuario();
        Usuario usuario = usuarioDao.obtener(1);
        INiveles nivelDao = new ImplNiveles();
        Niveles nivel = nivelDao.obtener(1);
        Publicaciones publicacion = new Publicaciones(2,usuario,nivel,"titulo2","contenido2",1,1,12.34,new Date(),new Date());
        
        try{
            filasAfectadas = publicacionDao.insertar(publicacion);
            System.out.println("Ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);

        List<Publicaciones> lista = new ArrayList<>();
        try {
            lista = publicacionDao.obtener();
            for (Publicaciones c:lista){
                System.out.println("Id_publicacion :"+c.getPublicaciones_Id());
                System.out.println("Usuario :"+c.getUsuario().getUsuario_Id());
                System.out.println("Nivel :"+c.getNiveles().getNiveles_Id());
                System.out.println("Titulo :"+c.getTitulo());
                System.out.println("Contenido :"+c.getContenido());
                System.out.println("Publicado :"+c.getPublicacion());
                System.out.println("Vistas :"+c.getVistas());
                System.out.println("Votos :"+c.getVotos());
                System.out.println("Fecha de creado :"+c.getCreado());
                System.out.println("Fecha de actualizado :"+c.getActualizado());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }

}




