package proyectofidness;
import java.io.Serializable;
import java.util.List;
public class Rutina implements Serializable{
    private String nombre;
    private Cliente cliente;
    private List<Ejercicio> listaE;

    public Rutina() {
    }

    public Rutina(String nombre, Cliente cliente, List<Ejercicio> listaE) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.listaE = listaE;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Ejercicio> getListaE() {
        return listaE;
    }

    public void setListaE(List<Ejercicio> listaE) {
        this.listaE = listaE;
    }
    
    public void agregarEjercicio(Ejercicio ejercicio) {
        listaE.add(ejercicio);
    }

    public String mostrarRutina() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rutina: ").append(nombre);
        sb.append("\nCliente: ").append(cliente.getNombre()).append(" ").append(cliente.getApellidos());
        sb.append("\n--- Ejercicios ---");
        for (Ejercicio e : listaE) {
            sb.append("\n").append(e.toString());
        }
        return sb.toString();
    }
}
