package grupo5.rnegocio.dao;
import grupo5.rnegocio.entidades.*;
import java.util.List;

public interface INiveles {
     public int insertar(Niveles nivel) throws Exception;
     
     public List<Niveles> obtener() throws Exception;
     
     public Niveles obtener(long codigo) throws Exception;   
}


