/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.Utilidades;

import alquilervehiculos.modelo.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pavilion
 */
public class LeerArchivoPlano {
    public static List<Usuario> cargarUsuarios(TipoUsuario[] tipos) {
        List<Usuario> listado= new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("src/usuVehiculos.csv");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;            
            br.readLine();
            while ((linea = br.readLine()) != null) {
               
               String[] datos= linea.split(";");
               
               Usuario usuario = new Usuario(
                      datos[0],
                      datos[1],
                      tipos[Integer.parseInt(datos[2])],
                      datos[3],
                      datos[4]);
                       
               listado.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("El archivo no existe = " + e.getMessage());
        } finally {            
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return listado;
    }
        public static void cargarMotos(List<AbstractVehiculo> vehiculos) {
            
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;
            
            try {
                archivo = new File("src/cargarMoto.csv");
                fr = new FileReader (archivo);
                br = new BufferedReader (fr);
                //lectura del fichero
                String linea;
                br.readLine();
                while ((linea = br.readLine()) != null) {
                    
                    String [] datos = linea.split(";");
                    
                    Moto moto = new Moto (
                            datos[0],      
                            Integer.parseInt(datos[1]),
                            Boolean.parseBoolean(datos[2]),
                            Double.parseDouble(datos[3]));
                            
                            
                    
                    vehiculos.add(moto);
            }
        } catch (Exception e) {
                System.out.println("El archivo no existe = " + e.getMessage());
        } finally {
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2){
                    e2.printStackTrace();
                }
            }
}
        public static void cargarCoche(List<AbstractVehiculo> vehiculos) {
            
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;
            
            try {
                archivo = new File("src/cargarCoche.csv");
                fr = new FileReader (archivo);
                br = new BufferedReader (fr);
                //lectura del fichero
                String linea;
                br.readLine();
                while ((linea = br.readLine()) != null) {
                    
                    String [] datos = linea.split(";");
                    
                    Coche coche = new Coche (
                            datos[0],
                            Integer.parseInt(datos[1]),
                            Boolean.parseBoolean(datos[2]),
                            Double.parseDouble(datos[3]));
                    
                    vehiculos.add(coche);
            }
        } catch (Exception e) {
                System.out.println("El archivo no existe = " + e.getMessage());
        } finally {
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2){
                    e2.printStackTrace();
                }
            }
}
        public static void cargarFurgoneta(List<AbstractVehiculo> vehiculos) {
            
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;
            
            try {
                archivo = new File("src/cargarFurgoneta.csv");
                fr = new FileReader (archivo);
                br = new BufferedReader (fr);
                //lectura del fichero
                String linea;
                br.readLine();
                while ((linea = br.readLine()) != null) {
                    
                    String [] datos = linea.split(";");
                    
                    Furgoneta furgoneta = new Furgoneta (
                            datos[0],
                            Integer.parseInt(datos[1]),
                            Boolean.parseBoolean(datos[2]),
                            Double.parseDouble(datos[3]))
                            ;
                    
                    vehiculos.add(furgoneta);
            }
        } catch (Exception e) {
                System.out.println("El archivo no existe = " + e.getMessage());
        } finally {
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2){
                    e2.printStackTrace();
                }
            }
}
         public static List<Cliente> cargarClientes()
    {
        List<Cliente> listado = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try
        {
            archivo = new File("src/clientes.csv");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null)
            {

                String[] datos = linea.split(";");

                Cliente cliente = new Cliente(
                        datos[0],
                        datos[1]);
                listado.add(cliente);
            }
        }
        catch (Exception e)
        {
            System.out.println("El archivo no existe = " + e.getMessage());
        }
        finally
        {
            try
            {
                if (null != fr)
                {
                    fr.close();
                }
            }
            catch (Exception e2)
            {
                e2.printStackTrace();
            }
        }
        return listado;
    
    }
         public static byte convertirUsuario(String codigo)
    {
        byte numeroTipo = 0;

        switch (codigo)
        {
            case "administrador":
                numeroTipo = 0;
                break;
            case "usuario":
                numeroTipo = 1;
                break;
            case "cliente":
                numeroTipo = 3;
                break;
        }
        return numeroTipo;
    }
}
