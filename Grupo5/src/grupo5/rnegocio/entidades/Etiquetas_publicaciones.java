
package grupo5.rnegocio.entidades;
import java.util.*;
public class Etiquetas_publicaciones {
    private int etiqueta_id;
    private int publicacion_id;
    private Date creado;
    private Date actualizado;

    public Etiquetas_publicaciones(int etiqueta_id, int publicacion_id, Date creado, Date actualizado) {
        this.etiqueta_id = etiqueta_id;
        this.publicacion_id = publicacion_id;
        this.creado = creado;
        this.actualizado = actualizado;
    }

    public Etiquetas_publicaciones() {
    }

    public int getEtiqueta_id() {
        return etiqueta_id;
    }

    public void setEtiqueta_id(int etiqueta_id) {
        this.etiqueta_id = etiqueta_id;
    }

    public int getPublicacion_id() {
        return publicacion_id;
    }

    public void setPublicacion_id(int publicacion_id) {
        this.publicacion_id = publicacion_id;
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
