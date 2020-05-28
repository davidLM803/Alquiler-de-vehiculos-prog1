/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.controlador;

import java.util.ArrayList;
import java.util.List;
import alquilervehiculos.modelo.*;
import alquilervehiculos.Utilidades.*;
import alquilervehiculos.excepciones.ClientesExcepcion;
import alquilervehiculos.excepciones.VehiculosExcepcion;

/**
 *
 * @author pavilion
 */
public class GestionUsuario {
    private TipoUsuario[] tipoUsuarios;
    List<Usuario> lstUsuarios = new ArrayList<>();
    private List<Cliente> clientes;
    
    public GestionUsuario() {
        llenarTiposUsuario();
        llenarUsuarios();
        llenarClientes();
    }

    public TipoUsuario[] getTipoUsuarios() {
        return tipoUsuarios;
    }

    public void setTipoUsuarios(TipoUsuario[] tipoUsuarios) {
        this.tipoUsuarios = tipoUsuarios;
    }
    
     public List<Usuario> getUsuarios() {
        return lstUsuarios;
    }

    public void setUsuarios(List<Usuario> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }
    public List<Cliente> getClientes()
    {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes)
    {
        this.clientes = clientes;
    }
    
    private void llenarTiposUsuario()
    {
        tipoUsuarios = new TipoUsuario[3]; 
        tipoUsuarios[0] = new TipoUsuario((byte)1, "Administrador");
        tipoUsuarios[1] = new TipoUsuario((byte)2, "Usuario");
        tipoUsuarios[2] = new TipoUsuario((byte)3, "Cliente");
      
    }
    public void llenarClientes()
    {
        clientes = LeerArchivoPlano.cargarClientes();
    }
    public void agregarCliente (Cliente cliente) throws VehiculosExcepcion {
        
        if (validarExistenciaUsuario(cliente))
        {

            throw new VehiculosExcepcion("El usuario con identidicación: " 
                    + cliente.getCedula() + " ya existe");
        }
        else
        {  

        clientes.add(cliente);

        }
    }
    private boolean validarExistenciaUsuario(Usuario usuario) {
       for (Usuario usr : this.lstUsuarios)
        {
            if (usr.getCedula().compareTo(usuario.getCedula()) == 0)
            {
                return true;
            }
        }
        return false;
    }
        private boolean validarExistenciaUsuario(Cliente cliente)
    {
               for (Cliente cli : this.clientes)
        {
            if (cli.getCedula().compareTo(cliente.getCedula()) == 0)
            {
                return true;
            }
        }
        return false;
    }
        
    public void agregarUsuario (Usuario usuario) throws VehiculosExcepcion {
        
        lstUsuarios.add(usuario);
    }
    
    public void llenarUsuarios () {
        
        lstUsuarios=LeerArchivoPlano.cargarUsuarios(tipoUsuarios);
        
    }
     public Usuario validarUsuario (String login,String passwd) {
         
         for(Usuario usuarioValidado: lstUsuarios)
        {
            if(usuarioValidado.getLogin().compareTo(login)==0 &&
                    usuarioValidado.getPasswd().compareTo(passwd)==0)
            {
                return usuarioValidado;
            }
        }
        
        return null;
        
    }
     public void adicionarUsuario(Usuario usuario) throws ClientesExcepcion
    {
        if (validarExistenciaUsuario(usuario)){

            throw new ClientesExcepcion("El usuario con identificación: " 
                    + usuario.getCedula() + " ya existe");
        }
        else
        {      

        
            lstUsuarios.add(usuario);

        }
    }
     public Cliente encontrarCliente(String id) 
    {
              for (Cliente cliente : getClientes())
            {
                Cliente cli;
                if (id.equals(cliente.getNombre()))
                {
                    cli = cliente; 
                    return cli;
                }
           
            }
            return null;
    }

}

