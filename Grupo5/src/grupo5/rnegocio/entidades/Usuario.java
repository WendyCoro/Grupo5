
package grupo5.rnegocio.entidades;

import java.util.Date;


public class Usuario {
    private int id_Usuario;
    private String nombre;
    private String password;
    private int id_Rol;
    private Date creado;
    private Date actualizado;

    public Usuario() {
    }

    public Usuario(int id_Usuario, String nombre, String password, int id_Rol, Date creado, Date actualizado) {
        this.id_Usuario = id_Usuario;
        this.nombre = nombre;
        this.password = password;
        this.id_Rol = id_Rol;
        this.creado = creado;
        this.actualizado = actualizado;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_Rol() {
        return id_Rol;
    }

    public void setId_Rol(int id_Rol) {
        this.id_Rol = id_Rol;
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
           
