package grupo5.rnegocio.entidades;
import java.util.Date;

public class Roles {
   private long id_r;
    private String nombre;
    private Date creado;
    private Date actualizado; 

    public Roles() {
    }

    public Roles(int id_r, String nombre, Date creado, Date actualizado) {
        this.id_r = id_r;
        this.nombre = nombre;
        this.creado = creado;
        this.actualizado = actualizado;
    }

    public long getId_r() {
        return id_r;
    }

    public void setId_r(long id_r) {
        this.id_r = id_r;
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


