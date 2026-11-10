package proyectofidness;
import java.io.Serializable;
public class Cliente extends Usuario implements Serializable{
    private String nivel;

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String idUsuario, String email, String contra, String rol, String nivel) {
        super(nombre, apellidos, idUsuario, email, contra, rol);
        this.nivel = nivel;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Cliente: " + super.toString() + nivel;
    }
    
}
