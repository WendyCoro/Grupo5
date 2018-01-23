package grupo5.rnegocio.dao;
import grupo5.rnegocio.entidades.*;
import java.util.List;

public interface IEtiquetas_publicaciones{    
   public int insertar(Etiquetas_publicaciones etiquetas_publciaciones) throws Exception;
   public List<Etiquetas_publicaciones> obtener() throws Exception;  
}