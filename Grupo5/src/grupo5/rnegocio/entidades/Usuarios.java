package grupo5.rnegocio.entidades;
import java.util.Date;

public class Usuarios {
    private int id_u;
    private String nombre;
    private String email;
    private String pasword;
    private Roles roles;
    private Date creado;
    private Date actualizado;

    public Usuarios() {
    }

    public Usuarios(int id_u, String nombre, String email, String pasword, Roles roles, Date creado, Date actualizado) {
        this.id_u = id_u;
        this.nombre = nombre;
        this.email = email;
        this.pasword = pasword;
        this.roles = roles;
        this.creado = creado;
        this.actualizado = actualizado;
    }

    public int getId_u() {
        return id_u;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
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
