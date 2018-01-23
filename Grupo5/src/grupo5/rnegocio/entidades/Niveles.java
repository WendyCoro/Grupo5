
package grupo5.rnegocio.entidades;

import java.util.Date;

public class Niveles {
    private long id_n;
    private String nombre;
    private Date creado;
    private Date actualizado; 

    public Niveles() {
    }

    public Niveles(long id_n, String nombre, Date creado, Date actualizado) {
        this.id_n = id_n;
        this.nombre = nombre;
        this.creado = creado;
        this.actualizado = actualizado;
    }

    public long getId_n() {
        return id_n;
    }

    public void setId_n(long id_n) {
        this.id_n = id_n;
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
