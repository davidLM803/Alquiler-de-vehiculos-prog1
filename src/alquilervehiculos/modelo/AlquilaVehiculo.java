/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.modelo;

import java.util.Date;


/**
 *
 * @author pavilion
 */
public class AlquilaVehiculo  {
    public AbstractVehiculo vehiculo;
    public Usuario usuario;
    public Date fechaRenta;
    public Date fechaDevolucion;
    public Cliente cliente;
    
    public AlquilaVehiculo(AbstractVehiculo vehiculo, Date fechaRenta, Date fechaDevolucion, Cliente cliente)
    {
        this.vehiculo = vehiculo;
        this.fechaRenta = fechaRenta;
        this.fechaDevolucion = fechaDevolucion;
        this.cliente = cliente;
    }    
    public AbstractVehiculo getVehiculo()
    {
        return vehiculo;
    }

    public void setVehiculo(AbstractVehiculo vehiculo)
    {
        this.vehiculo = vehiculo;
    }

    public Date getFechaRenta()
    {
        return fechaRenta;
    }

    public void setFechaRenta(Date fechaRenta)
    {
        this.fechaRenta = fechaRenta;
    }

    public Date getFechaDevolucion()
    {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion)
    {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Cliente getCliente()
    {
        return cliente;
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }



    public Object[] obtenerArregloVehiculoAlquilar()
    {
        Object[] dato =
        {
            getVehiculo().getMatricula(), getCliente().cedula, getFechaRenta(), getFechaDevolucion()
        };
        return dato;
    }
}

