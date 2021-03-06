
package grupo5.rnegocio.entidades;
import java.util.*;

public class Etiquetas {
    private long id_e;
    private String nombre;
    private Date creado;
    private Date actualizado; 

    public Etiquetas() {
    }

    public Etiquetas(long id_e, String nombre, Date creado, Date actualizado) {
        this.id_e = id_e;
        this.nombre = nombre;
        this.creado = creado;
        this.actualizado = actualizado;
    }

    public long getId_e() {
        return id_e;
    }

    public void setId_e(long id_e) {
        this.id_e = id_e;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Date getActualizado() {
        return actualizado;
    }

    public void setActualizado(Date actualizado) {
        this.actualizado = actualizado;
    } 
}
