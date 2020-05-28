
package alquilervehiculos.modelo;

/**
 *
 * @author pavilion
 */
public class Usuario {
    String cedula;
    String nombre;
    String login;
    String passwd;
    private TipoUsuario tipoUsuario;

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    
    public  Usuario(String cedula, String nombre,TipoUsuario tipoUsuario, String login, String passwd) {
 
        this.cedula = cedula;
        this.nombre = nombre;
        this.login = login;
        this.passwd = passwd;
        this.tipoUsuario = tipoUsuario;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    
      @Override
    public String toString() {
        return nombre;
    }
     public Object[] obtenerArregloUsuario(){
        Object[] dato={getNombre(),getCedula(),getLogin(),getPasswd(),getTipoUsuario().toString()};
        return dato;
    }
    public Object[] obtenerArregloObjeto(){
        Object[] data={ getCedula(),getNombre(),getLogin()};
        return data;
}
}
