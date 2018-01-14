package grupo5.rnegocio.entidades;
import java.util.Date;

public class Usuario {
    private int Usuario_Id;
    private String Nombre;
    private String Email;
    private String Password;
    private Roles Roles;
    private Date Creado;
    private Date Actualizado;

    public Usuario() {
    }

    public Usuario(int Usuario_Id, String Nombre, String Email, String Password, Roles Roles, Date Creado, Date Actualizado) {
        this.Usuario_Id = Usuario_Id;
        this.Nombre = Nombre;
        this.Email = Email;
        this.Password = Password;
        this.Roles = Roles;
        this.Creado = Creado;
        this.Actualizado = Actualizado;
    }

    public int getUsuario_Id() {
        return Usuario_Id;
    }

    public void setUsuario_Id(int Usuario_Id) {
        this.Usuario_Id = Usuario_Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Roles getRoles() {
        return Roles;
    }

    public void setRoles(Roles Roles) {
        this.Roles = Roles;
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
           
