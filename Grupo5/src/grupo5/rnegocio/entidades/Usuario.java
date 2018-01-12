
package grupo5.rnegocio.entidades;

import java.util.Date;


public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String password;
    private Roles roles;
    private Date creado;
    private Date actualizado;
    
    public Usuario() {
    }
   
    public Usuario(int id, String nombre, String email, String password, Roles roles, Date creado, Date actualizado) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.roles = roles;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
           
