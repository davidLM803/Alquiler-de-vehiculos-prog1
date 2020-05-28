/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.Interface;

/**
 * 
 * @author pavilion
 */
public interface VehiculoAble  {
    
    public void alquilar ();
    public void devolver (int Kmfinal);
    double calcularAlquiler (int km) ;
    public Object mostrarDatos ();
        
    }
    

