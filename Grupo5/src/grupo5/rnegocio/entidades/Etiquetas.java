
package grupo5.rnegocio.entidades;
import java.util.*;

public class Etiquetas {
 private long Etiqueta_Id;
 private String Nombre;
 private Date Creado;
 private Date Actualizado;

    public Etiquetas() {
    }

    public Etiquetas(long Etiqueta_Id, String Nombre, Date Creado, Date Actualizado) {
        this.Etiqueta_Id = Etiqueta_Id;
        this.Nombre = Nombre;
        this.Creado = Creado;
        this.Actualizado = Actualizado;
    }

    public long getEtiqueta_Id() {
        return Etiqueta_Id;
    }

    public void setEtiqueta_Id(long Etiqueta_Id) {
        this.Etiqueta_Id = Etiqueta_Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Date getCreado() {
        return Creado;
    }

    public void setCreado(Date Creado) {
        this.Creado = Creado;
    }

    public Date getActualizado() {
        return Actualizado;
    }

    public void setActualizado(Date Actualizado) {
        this.Actualizado = Actualizado;
    }

        
}
