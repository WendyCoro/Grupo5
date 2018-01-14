
package grupo5.rnegocio.entidades;

import java.util.Date;

public class Niveles {
    private int Niveles_Id;
    private String Nombre;
    private Date Creado;
    private Date Actualizado;

    public Niveles() {
    }

    public Niveles(int Niveles_Id, String Nombre, Date Creado, Date Actualizado) {
        this.Niveles_Id = Niveles_Id;
        this.Nombre = Nombre;
        this.Creado = Creado;
        this.Actualizado = Actualizado;
    }

    public int getNiveles_Id() {
        return Niveles_Id;
    }

    public void setNiveles_Id(int Niveles_Id) {
        this.Niveles_Id = Niveles_Id;
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
