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
public interface IUsuarios {
        public int insertar (Usuarios usuarios) throws Exception;
    public int modificar (Usuarios usuarios) throws Exception;
    public int eliminar (Usuarios usuarios) throws Exception;
    public Usuarios obtener(int id_u) throws Exception;
    public ArrayList<Usuarios> obtener () throws Exception;

    
    
}
