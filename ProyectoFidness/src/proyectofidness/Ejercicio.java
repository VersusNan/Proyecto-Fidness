package proyectofidness;
import java.io.Serializable;
public class Ejercicio implements Serializable{
    private String nombre;
    private String categoria;
    private int repeticiones;
    private String descripcion;//Decidí agregar este nuevo atributo para cumplir con el objetivo del gimnasio Fidness "Los usuarios puedan consultar los ejercicios y como se ejecuta cada uno de ellos"

    public Ejercicio() {
    }

    public Ejercicio(String nombre, String categoria, int repeticiones, String descripcion) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.repeticiones = repeticiones;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +" | "+ "Categoria: " + categoria +" | "+ "Repeticiones: " + repeticiones +" | "+ "Descripción: " +descripcion;
    }
    
}
