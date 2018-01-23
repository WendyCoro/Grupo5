package grupo5.rnegocio.dao;
import grupo5.rnegocio.entidades.*;
import java.util.List;

public interface IEtiquetas {
    
     public int insertar(Etiquetas etiquetas) throws Exception;     
     public List<Etiquetas> obtener() throws Exception;    
     public Etiquetas obtener(long codigo) throws Exception;   
     
}
