/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.modelo;
import alquilervehiculos.Interface.VehiculoAble;

/**
 *
 * @author pavilion
 */
abstract public class AbstractVehiculo implements VehiculoAble {
    
    String matricula;
    int km;
    boolean estado;
    double valorAlquiler;
    Object diferente;

    

    public AbstractVehiculo(String matricula, int km, boolean estado, double valorAlquiler) {
        this.matricula = matricula;
        this.km = km;
        this.estado = estado;
        this.valorAlquiler = valorAlquiler;
    }

   public String getMatricula()
    {
        return matricula;
    }

    public void setMatricula(String matricula)
    {
        this.matricula = matricula;
    }

    public int getKm()
    {
        return km;
    }

    public void setKm(int km)
    {
        this.km = km;
    }

    public boolean isEstado()
    {
        return estado;
    }

    public Object getDiferente()
    {
        return diferente;
    }

    public void setDiferente(Object diferente)
    {
        this.diferente = diferente;
    }

    

    public void setEstado(boolean estado)
    {
        this.estado = estado;
    }

    public double getValorAlquiler()
    {
        return valorAlquiler;
    }

    public void setValorAlquiler(double valorAlquiler)
    {
        this.valorAlquiler = valorAlquiler;
    }
    
    

    @Override
    public abstract Object mostrarDatos();

    @Override
    public abstract double calcularAlquiler(int dias);

    @Override
    public abstract void devolver(int kmFinal);

    @Override
    public abstract void alquilar();
    
    
      public  Object[] obtenerArregloVehiculos(){
        Object[] datoV={getMatricula(), getKm(), isEstado(), getValorAlquiler(),getClass().getSimpleName()};
        return datoV;
      }
}
