package grupo5.rnegocio.entidades;
import java.util.Date;

public class Roles {
    private long Roles_Id;
    private String Nombre;
    private Date Creado;
    private Date Actualizado;

    public Roles() {
    }

    public Roles(long Roles_Id, String Nombre, Date Creado, Date Actualizado) {
        this.Roles_Id = Roles_Id;
        this.Nombre = Nombre;
        this.Creado = Creado;
        this.Actualizado = Actualizado;
    }

    public long getRoles_Id() {
        return Roles_Id;
    }

    public void setRoles_Id(long Roles_Id) {
        this.Roles_Id = Roles_Id;
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

