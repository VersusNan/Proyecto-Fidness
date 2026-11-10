package proyectofidness;
import java.io.Serializable;
public abstract class Usuario implements Serializable{
    private String nombre;
    private String apellidos;
    private String idUsuario;
    private String email;
    private String contra;
    private String rol;

    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, String idUsuario, String email, String contra, String rol) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.idUsuario = idUsuario;
        this.email = email;
        this.contra = contra;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +" | "+ "Apellidos: " + apellidos +" | "+ "Identificación: " +
        idUsuario +" | "+ "Email: " + email + "Contraseña: " + contra +" | "+ "Rol: " + rol;
    }
    
}
