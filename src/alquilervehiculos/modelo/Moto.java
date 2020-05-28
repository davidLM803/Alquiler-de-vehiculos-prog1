/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.modelo;


/**
 *
 * @author pavilion
 */
public class Moto extends AbstractVehiculo {
    boolean casco;

    public Moto(String matricula, int km, boolean estado, double valorAlquiler, boolean casco) {
        super(matricula, km, estado, valorAlquiler);
        this.casco = casco;
    }

      public Moto(String matricula, int km, boolean estado, double valorAlquiler)
    {
        super(matricula, km, estado, valorAlquiler);
    }

    public boolean isCasco() {
        return casco;
    }

    public void setCasco(boolean casco) {
        this.casco = casco;
    }


    @Override
    public Object getDiferente()
    {
        String mensaje;
        
        if (isCasco()== true){
        mensaje = "La moto tiene casco";
                }
        else {
        mensaje = "La moto no tiene casco";
        }
        return mensaje;
    }
    

    @Override
    public Object mostrarDatos()
    {
    return obtenerArregloVehiculos();        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calcularAlquiler(int dias)
    {
               double precio = dias*valorAlquiler;
        return precio;
    }


    @Override
    public void alquilar()
    {
        setEstado(false);
    }

    @Override
    public void devolver(int kmFinal) {
    }

    
    
    public Object[] obtenerArregloVehiculos() {
    Object[] data={ getMatricula(),getKm(),isEstado(),getValorAlquiler(),isCasco()};
        return data;    }
}
