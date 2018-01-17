package grupo5.Test;



import grupo5.rnegocio.dao.IPublicaciones;
import grupo5.rnegocio.dao.IUsuarios;
import grupo5.rnegocio.entidades.Niveles;
import grupo5.rnegocio.entidades.Publicaciones;
import grupo5.rnegocio.entidades.Roles;
import grupo5.rnegocio.entidades.Usuarios;
import grupo5.rnegocio.impl.PublicacionesImpl;
import grupo5.rnegocio.impl.UsuariosImpl;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class UsuarioTest {
    
    public UsuarioTest() {
    }
     @Test 
    public  void testGeneral(){
        IUsuarios usDao = new UsuariosImpl();
        //// test insertat
////        
        int filas=0;
        
        Roles rol=new Roles(1, "Wendy", new java.util.Date(), new java.util.Date());
        Usuarios user=new Usuarios(1, "Wendy", "dayan_p2010@hotmai.com", "3456", rol, new java.util.Date(), new java.util.Date());
        
           try {
            filas=usDao.insertar(user);
            System.out.println("Filas insertadas: "+filas);
        } catch (Exception e) {
              System.out.println("Error: " + e.getMessage());
        }
        assertEquals(filas>0, true);
////        
        
        ////test codigo
//        
        Usuarios use=new Usuarios();
        try {
            use=usDao.obtener(1);
            System.out.println(use.getId_u()+" "+use.getNombre()+" "+use.getEmail()+" "+use.getPasword()+" "+use.getRoles().getId_r()+" "+use.getCreado()+" "+use.getActualizado());
        } catch (Exception e) {
            System.out.println("error: "+e.getMessage());
        }
       assertEquals(use != null, true);


//
////////        //// test listado
////       
        ArrayList<Usuarios> usuarioss = new ArrayList<>();
        
        try{
            usuarioss = usDao.obtener();
            for (Usuarios nusuarios : usuarioss) {
                 System.out.println(nusuarios.getId_u()+" "+nusuarios.getNombre()+" "+nusuarios.getEmail()+" "+nusuarios.getPasword()+" "+nusuarios.getRoles().getId_r()+" "+nusuarios.getCreado()+" "+nusuarios.getActualizado());
            }
        }catch (Exception e){         
         
       }
      assertEquals(usuarioss!=null, true);
       
//        
//        
    }
    
    }

