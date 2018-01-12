/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5.rnegocio.dao;

import grupo5.rnegocio.entidades.Etiquetas;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public interface IEtiquetas {
    public int insertar(Etiquetas etiquetas) throws Exception;
    public List<Etiquetas> obtener() throws Exception;
    public Etiquetas obtener(int codigo) throws Exception;
}
