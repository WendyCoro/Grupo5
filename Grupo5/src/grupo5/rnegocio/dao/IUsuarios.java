package grupo5.rnegocio.dao;
import grupo5.rnegocio.entidades.*;
import java.util.List;

public interface IUsuarios {
   public int insertar(Usuarios usuario) throws Exception;     
     public List<Usuarios> obtener() throws Exception;     
     public Usuarios obtener(long codigo) throws Exception;    
}
