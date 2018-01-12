package grupo5.rnegocio.entidades;
import java.util.Date;

public class Roles {
    private int id;
    private String nombre;
    private Date creado;
    private Date actualizado;

    public Roles() {
    }

    public Roles(int id, String nombre, Date creado, Date actualizado) {
        this.id = id;
        this.nombre = nombre;
        this.creado = creado;
        this.actualizado = actualizado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
