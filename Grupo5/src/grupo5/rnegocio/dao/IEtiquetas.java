/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5.rnegocio.dao;

import grupo5.rnegocio.entidades.*;
import grupo5.rnegocio.dao.*;
import java.util.*;
import java.util.List;


/**
 *
 * @author TOSHIBA
 */
public interface IEtiquetas {
    public int insertar(Etiquetas etiquetas) throws Exception;
    public int modificar (Etiquetas etiquetas) throws Exception ;
    public int eliminar (Etiquetas etiquetas) throws Exception ;
    public Etiquetas obtener(long Etiqueta_Id) throws Exception;
    public ArrayList<Etiquetas> obtener() throws Exception;
}
