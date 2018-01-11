/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5.rnegocio.entidades;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Roles {
    private int id_Roles;
    private String nombre;
    private Date creado;
    private Date actualizado;

    public Roles() {
    }

    public Roles(int id_Roles, String nombre, Date creado, Date actualizado) {
        this.id_Roles = id_Roles;
        this.nombre = nombre;
        this.creado = creado;
        this.actualizado = actualizado;
    }

    public int getId_Roles() {
        return id_Roles;
    }

    public void setId_Roles(int id_Roles) {
        this.id_Roles = id_Roles;
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
