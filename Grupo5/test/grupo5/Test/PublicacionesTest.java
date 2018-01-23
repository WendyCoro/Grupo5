package grupo5.Test;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;
import grupo5.rnegocio.dao.*;
import grupo5.rnegocio.entidades.*;
import grupo5.rnegocio.impl.*;

 public class PublicacionesTest {
   public PublicacionesTest() {
    }
    @Test
    public void pruebageneral() throws Exception{
        //              INSERTAR
        int filasAfectadas =0;
        IPublicaciones publicacionesDao = new PublicacionesImpl();
        IUsuarios usuarioDao = new UsuariosImpl();
        Usuarios usuarios = usuarioDao.obtener(132);
        INiveles nivelesDao = new NivelesImpl();
        Niveles nivel = nivelesDao.obtener(174);
        Publicaciones publicacion = new Publicaciones(182,usuarios,nivel,"titulo2","contenido2",1,1,12.34,new Date(),new Date());    
        try{
            filasAfectadas = publicacionesDao.insertar(publicacion);
            System.out.println("Publicacion ingresada!!!");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);

        List<Publicaciones> lista = new ArrayList<>();
        try {
            lista = publicacionesDao.obtener();
            for (Publicaciones p:lista){
                System.out.println("Id_publicacion :"+p.getId_p());
                System.out.println("Usuario :"+p.getUsuarios().getId_u());
                System.out.println("Nivel :"+p.getNiveles().getId_n());
                System.out.println("Titulo :"+p.getTitulo());
                System.out.println("Contenido :"+p.getContenido());
                System.out.println("Publicado :"+p.getPublicado());
                System.out.println("Vistas :"+p.getVistas());
                System.out.println("Votos :"+p.getVotos());
                System.out.println("Fecha de creado :"+p.getCreado());
                System.out.println("Fecha de actualizado :"+p.getActualizado());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }
}



