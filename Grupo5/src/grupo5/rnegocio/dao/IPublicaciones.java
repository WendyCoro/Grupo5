
package grupo5.rnegocio.dao;
import grupo5.rnegocio.entidades.*;
import java.util.List;

public interface IPublicaciones {
     public int insertar(Publicaciones publicaciones) throws Exception;     
     public List<Publicaciones> obtener() throws Exception;     
     public Publicaciones obtener(long codigo) throws Exception;   
}
