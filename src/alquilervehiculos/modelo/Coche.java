
package alquilervehiculos.modelo;

/**
 *
 * @author pavilion
 */
public class Coche extends AbstractVehiculo {
     boolean extras;

    public Coche(String matricula, int km, boolean estado, double valorAlquiler) {
        super(matricula, km, estado, valorAlquiler);
        this.extras = extras;
    }

    public boolean isExtras() {
        return extras;
    }

    public void setExtras(boolean extras) {
        this.extras = extras;
    }
    
     public Object getOtro()
    {
               String mensaje;
        
        if (isExtras()== true){
        mensaje = "El coche tiene extras";
                }
        else {
        mensaje = "El coche no tiene extras";
        }
        return mensaje;
    }

    @Override
    public Object mostrarDatos()
    {
    return obtenerArregloVehiculos();    
    }

    @Override
    public double calcularAlquiler(int dias)
    {
        double precio = dias*valorAlquiler;
        return precio;
    }

//    @Override
//     public void devolver(int kmFinal)
//    {
//        setEstado(true);
//        int kilometrajeUsado = kmFinal-getKm();       
//      String mensaje= "El usuario recorrio "+kilometrajeUsado+" kilometros"+
//              "\n El vehiculo fue devuelto, su nuevo kilometraje es de "+kmFinal;
//         setKm(kmFinal);
//        JOptionPane.showMessageDialog(null, mensaje);
//    }
     
    @Override
    public void alquilar()
    {
        setEstado(false);
    }
    
    @Override
    public void devolver(int kmFinal) {
    }

     
    public Object[] obtenerArregloVehiculos() {
    Object[] data={ getMatricula(), getKm(),isEstado(),getValorAlquiler(),isExtras()};
        return data;}
 
}
