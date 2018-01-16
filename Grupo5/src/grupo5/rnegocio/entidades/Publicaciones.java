
package grupo5.rnegocio.entidades;
import java. util.*;
public class Publicaciones {
    private long Publicaciones_Id;
    private Usuario Usuario ; 
    private Niveles Niveles;
    private String Titulo;
    private String Contenido;
    private int Publicacion ;
    private int Vistas;
    private Double Votos;
    private Date Creado;
    private Date Actualizado;

    public Publicaciones() {
    }

    public Publicaciones(long Publicaciones_Id, Usuario Usuario, Niveles Niveles, String Titulo, String Contenido, int Publicacion, int Vistas, Double Votos, Date Creado, Date Actualizado) {
        this.Publicaciones_Id = Publicaciones_Id;
        this.Usuario = Usuario;
        this.Niveles = Niveles;
        this.Titulo = Titulo;
        this.Contenido = Contenido;
        this.Publicacion = Publicacion;
        this.Vistas = Vistas;
        this.Votos = Votos;
        this.Creado = Creado;
        this.Actualizado = Actualizado;
    }

    public long getPublicaciones_Id() {
        return Publicaciones_Id;
    }

    public void setPublicaciones_Id(long Publicaciones_Id) {
        this.Publicaciones_Id = Publicaciones_Id;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public Niveles getNiveles() {
        return Niveles;
    }

    public void setNiveles(Niveles Niveles) {
        this.Niveles = Niveles;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String Contenido) {
        this.Contenido = Contenido;
    }

    public int getPublicacion() {
        return Publicacion;
    }

    public void setPublicacion(int Publicacion) {
        this.Publicacion = Publicacion;
    }

    public int getVistas() {
        return Vistas;
    }

    public void setVistas(int Vistas) {
        this.Vistas = Vistas;
    }

    public Double getVotos() {
        return Votos;
    }

    public void setVotos(Double Votos) {
        this.Votos = Votos;
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
