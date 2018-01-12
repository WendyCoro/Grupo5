
package grupo5.rnegocio.entidades;

import java.util.Date;

public class Niveles {
    private int id_Niveles;
    private String nombre;
    private Date creado;
    private Date actualizado;

    public Niveles() {
    }

    public Niveles(int id_Niveles, String nombre, Date creado, Date actualizado) {
        this.id_Niveles = id_Niveles;
        this.nombre = nombre;
        this.creado = creado;
        this.actualizado = actualizado;
    }

    public int getId_Niveles() {
        return id_Niveles;
    }

    public void setId_Niveles(int id_Niveles) {
        this.id_Niveles = id_Niveles;
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
