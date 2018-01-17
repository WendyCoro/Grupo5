/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5.rnegocio.dao;

import grupo5.rnegocio.entidades.Etiquetas.*;
import grupo5.rnegocio.entidades.Etiquetas_publicaciones;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public interface IEtiquetas_publicaciones {
    public int insertar (Etiquetas_publicaciones ep) throws Exception;
    public int modificar (Etiquetas_publicaciones ep) throws Exception;
    public int eliminar (Etiquetas_publicaciones ep) throws Exception;
    public Etiquetas_publicaciones obtener(int codigo) throws Exception;
    public ArrayList<Etiquetas_publicaciones> obtener () throws Exception; 
}
