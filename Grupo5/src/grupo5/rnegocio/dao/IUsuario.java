/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5.rnegocio.dao;


import grupo5.rnegocio.entidades.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public interface IUsuario {
        public int insertar(Usuario usuarios) throws Exception;
    public int modificar (Usuario usuarios) throws Exception ;
    public int eliminar (Usuario usuarios) throws Exception ;
    public Usuario obtener(long Usuarios_Id) throws Exception;
    public ArrayList<Usuario> obtener() throws Exception;


    
    
}
