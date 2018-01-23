
package grupo5.rnegocio.entidades;
import java. util.*;
public class Publicaciones {
   private long id_p;
    private Usuarios usuarios;
    private Niveles niveles;
    private String titulo;
    private String contenido;
    private int publicado;
    private int vistas;
    private Double votos;
    private Date creado;
    private Date actualizado; 

    public Publicaciones() {
    }

    public Publicaciones(long id_p, Usuarios usuarios, Niveles niveles, String titulo, String contenido, int publicado, int vistas, Double votos, Date creado, Date actualizado) {
        this.id_p = id_p;
        this.usuarios = usuarios;
        this.niveles = niveles;
        this.titulo = titulo;
        this.contenido = contenido;
        this.publicado = publicado;
        this.vistas = vistas;
        this.votos = votos;
        this.creado = creado;
        this.actualizado = actualizado;
    }

    public long getId_p() {
        return id_p;
    }

    public void setId_p(long id_p) {
        this.id_p = id_p;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Niveles getNiveles() {
        return niveles;
    }

    public void setNiveles(Niveles niveles) {
        this.niveles = niveles;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getPublicado() {
        return publicado;
    }

    public void setPublicado(int publicado) {
        this.publicado = publicado;
    }

    public int getVistas() {
        return vistas;
    }

    public void setVistas(int vistas) {
        this.vistas = vistas;
    }

    public Double getVotos() {
        return votos;
    }

    public void setVotos(Double votos) {
        this.votos = votos;
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
