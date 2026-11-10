package proyectofidness;
import java.io.Serializable;
public class Administrador extends Usuario implements Serializable{
    private String codigo;

    public Administrador() {
    }

    public Administrador(String nombre, String apellidos, String idUsuario, String email, String contra, String rol, String codigo) {
        super(nombre, apellidos, idUsuario, email, contra, rol);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Administrador: " + super.toString() + codigo;
    }
    
}
