/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5.rnegocio.dao;

import grupo5.rnegocio.entidades.Usuario;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public interface IUsuario {
    public int insertar(Usuario usuario) throws Exception;
    public List<Usuario> obtener() throws Exception;
    public Usuario obtener(int codigo) throws Exception;
}
