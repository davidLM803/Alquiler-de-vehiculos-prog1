/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.modelo;

import java.io.Serializable;

/**
 *
 * @author pavilion
 */
public class Cliente implements Serializable  {
    
    public String nombre;
    public String cedula;
    private TipoUsuario tipoUsuario;
    

   public Cliente(String cedula, String nombre, TipoUsuario tipoUsuario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
    }

    public Cliente(String text, String text0) {
        
            }


    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return this.nombre.toUpperCase();
    }

    public Object[] obtenerArregloClientes() {
        Object[] data = {getCedula(), getNombre(), getTipoUsuario().getCodigo()};
        return data;

    }
}
