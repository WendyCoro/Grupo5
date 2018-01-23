package grupo5.rnegocio.dao;
import grupo5.rnegocio.entidades.*;
import java.util.List;

public interface IRoles {
     public int insertar(Roles roles) throws Exception;     
     public List<Roles> obtener() throws Exception;     
     public Roles obtener(long codigo) throws Exception; 
}
