/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5.rnegocio.dao;

import grupo5.rnegocio.entidades.Publicaciones;
import grupo5.rnegocio.entidades.Publicaciones;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public interface IPublicaciones {
    public int insertar(Publicaciones publicaciones) throws Exception;
    public int modificar (Publicaciones publicaciones) throws Exception ;
    public int eliminar (Publicaciones publicaciones) throws Exception ;
    public Publicaciones obtener(long Publicaciones_Id) throws Exception;
    public ArrayList<Publicaciones> obtener() throws Exception;
}
