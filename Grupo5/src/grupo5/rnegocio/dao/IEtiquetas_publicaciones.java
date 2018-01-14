/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5.rnegocio.dao;

import grupo5.rnegocio.entidades.Etiquetas_Publicaciones;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public interface IEtiquetas_publicaciones {
    public int insertar(Etiquetas_Publicaciones etiquetas_publicaciones) throws Exception;
    public List<Etiquetas_Publicaciones> obtener() throws Exception;
    public Etiquetas_Publicaciones obtener(int codigo) throws Exception;
}
