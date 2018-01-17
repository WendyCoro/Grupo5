/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5.rnegocio.dao;

import grupo5.rnegocio.entidades.Niveles;
import grupo5.rnegocio.entidades.Niveles;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public interface INiveles {
      public int insertar(Niveles niveles) throws Exception;
     
     public List<Niveles> obtener() throws Exception;
     
     public Niveles obtener(long codigo) throws Exception; 
    
}
