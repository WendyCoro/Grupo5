/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5.rnegocio.dao;

import grupo5.rnegocio.entidades.Roles;
import grupo5.rnegocio.entidades.Roles;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public interface IRoles {
     public int insertar(Roles roles) throws Exception;
     
     public List<Roles> obtener() throws Exception;
     
     public Roles obtener(long codigo) throws Exception; 

}
