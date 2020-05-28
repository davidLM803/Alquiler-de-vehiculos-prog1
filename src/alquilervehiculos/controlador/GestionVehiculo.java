
package alquilervehiculos.controlador;

import alquilervehiculos.Utilidades.LeerArchivoPlano;
import alquilervehiculos.excepciones.VehiculosExcepcion;
import java.util.ArrayList;
import java.util.List;
import alquilervehiculos.modelo.*;
import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author pavilion
 */
public class GestionVehiculo implements Serializable {
    private List<AbstractVehiculo> lstVehiculos;
    private List<AlquilaVehiculo> vehiculosAlquilados  = new ArrayList<>();
    
    public GestionVehiculo(List<AbstractVehiculo> lstVehiculos) {
    llenarVehiculos();    
    }

    public GestionVehiculo() {
        llenarVehiculos();
    }
    
    public List<AbstractVehiculo> getVehiculos() {
        return lstVehiculos;
    }
    
    public void setVehiculos (List<AbstractVehiculo> lstVehiculos){
        this.lstVehiculos = lstVehiculos;
    }
    public void llenarVehiculos() {
       lstVehiculos = new  ArrayList<>();
       
       LeerArchivoPlano.cargarMotos(lstVehiculos);
       LeerArchivoPlano.cargarCoche(lstVehiculos);
       LeerArchivoPlano.cargarFurgoneta(lstVehiculos);
       
    }
    
    public List<AbstractVehiculo> obtenerVehiculo(String tipo) {
        List<AbstractVehiculo> listaTemp = new ArrayList<>();
        for (AbstractVehiculo lstVehiculo : lstVehiculos)
            switch (tipo) {
                case "Moto":
                    if (lstVehiculo instanceof Moto){
                        listaTemp.add(lstVehiculo);
                    }
                    break;
                case "Coche":
                    if(lstVehiculo instanceof Coche){
                        listaTemp.add(lstVehiculo);
                    }
                    break;
                case "Furgoneta":
                    if(lstVehiculo instanceof Furgoneta){
                        listaTemp.add(lstVehiculo);
                    }
                    break;
            }
        return listaTemp;
    }
    public AbstractVehiculo buscarVehiculo(String matricula)
    {
       for (AbstractVehiculo vehiculo : getVehiculos())
        {
            AbstractVehiculo veh;
            if (matricula.equals(vehiculo.getMatricula()))
            {
                veh = vehiculo;
                return veh;
            }

        }
        return null;
    }
     public AlquilaVehiculo buscarVehiculoAlquilado(String matricula)
    {
        for (AlquilaVehiculo vehiculo : getVehiculosAlquilados())
        {
            AlquilaVehiculo veh;
            if (matricula.equals(vehiculo.getVehiculo().getMatricula()))
            {
                veh = vehiculo;
                return veh;
            }

        }
        return null;
    }
     public void adicionarVehiculo(AbstractVehiculo vehiculo) throws VehiculosExcepcion
    {
        if (afirmarVehiculo(vehiculo))
        {

            throw new VehiculosExcepcion("El vehiculo con matricula: " + vehiculo.getMatricula()
                    + " ya existe");
        }
        else
        {
            lstVehiculos.add(vehiculo);

        }
    }
     private boolean afirmarVehiculo(AbstractVehiculo vehiculo)
    {
        for (AbstractVehiculo vehi : this.lstVehiculos)
        {
            if (vehi.getMatricula().compareTo(vehiculo.getMatricula()) == 0)
            {
                return true;
            }
        }
        return false;
    }
     public int calcularDias(Calendar inicio, Calendar fin)
    {
        
        if (inicio != null && fin != null)
        {
            Calendar fechaEntrega = inicio;
            Calendar fechaDevolucion;
            int dias = 0;

            while (inicio.before(fin) || inicio.equals(fin))
            {
                dias++;
                fechaEntrega.add(Calendar.DATE, 1);
            }
            return dias;
        }
        return 0;

    }

    public void adicionarVehiculoAlquilado(AlquilaVehiculo alquilado) throws VehiculosExcepcion
    {
        vehiculosAlquilados.add(alquilado);
    }

       public void devolverVehiculoAlquilado(AlquilaVehiculo alquilado, int km) throws VehiculosExcepcion
    {
        vehiculosAlquilados.remove(alquilado);
        alquilado.getVehiculo().devolver(km);
    }

    public List<AlquilaVehiculo> getVehiculosAlquilados() {
        return vehiculosAlquilados;
    }
}