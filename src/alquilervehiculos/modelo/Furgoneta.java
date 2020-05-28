
package alquilervehiculos.modelo;

import javax.swing.JOptionPane;


/**
 *
 * @author pavilion
 */
public class Furgoneta extends AbstractVehiculo {
    
    public short capacidad;

    public Furgoneta(String matricula, int km, boolean estado, double valorAlquiler, short capacidad)
    {
        super(matricula, km, estado, valorAlquiler);
        this.capacidad = capacidad;
    }

//    public Furgoneta(String matricula, int km, boolean estado, double valorAlquiler)
//    {
//        super(matricula, km, estado, valorAlquiler);
//    }

    public short getCapacidad()
    {
        return capacidad;
    }
    
      @Override
    public Object getDiferente()
    {
        String mensaje = "Tiene "+getCapacidad()+" de capcidad";
        
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
//    public void devolver(int kmFinal)
//    {
//        setEstado(true);
//        int kilometrajeUsado = kmFinal-getKm();       
//      String mensaje= "El usuario ha recorrido "+kilometrajeUsado+" kilometros"+
//              "\nEl vheículo ha sido devuelto, su nuevo kilometraje es "+kmFinal;
//         setKm(kmFinal);
//        JOptionPane.showMessageDialog(null, mensaje);
//    }


    @Override
    public void alquilar()
    {
        setEstado(false);
    }

    
    @Override
    public Object[] obtenerArregloVehiculos() {
    Object[] data={ getMatricula(), getKm(), getValorAlquiler(),getCapacidad()};
        return data;    }

    @Override
    public void devolver(int kmFinal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
