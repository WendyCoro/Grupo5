
package grupo5.rnegocio.entidades;
import java. util.*;
public class Publicaciones {
    private int id;
    private Usuario usuario ; 
    private Niveles niveles;
    private String titulo;
    private String contenido;
    private int publicacion ;
    private int vistas;
    private double votos;
    private Date creado;
    private Date actualizado;

    public Publicaciones(int id, Usuario usuario, Niveles niveles, String titulo, String contenido, int publicacion, int vistas, double votos, Date creado, Date actualizado) {
        this.id = id;
        this.usuario = usuario;
        this.niveles = niveles;
        this.titulo = titulo;
        this.contenido = contenido;
        this.publicacion = publicacion;
        this.vistas = vistas;
        this.votos = votos;
        this.creado = creado;
        this.actualizado = actualizado;
    }

    public Publicaciones() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public int getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }

    public int getVistas() {
        return vistas;
    }

    public void setVistas(int vistas) {
        this.vistas = vistas;
    }

    public double getVotos() {
        return votos;
    }

    public void setVotos(double votos) {
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
