package proyectofidness;
/**
 *Esta clase la presenté como administradora en el avance 1 pero para evitar confunciones con la clase administrador decidí nombrarla como gestora
 */
import javax.swing.JOptionPane;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class Gestora {
    private final File archivoE;
    private final File archivoA;
    private final File archivoC;
    private final File archivoR;

    public Gestora() {
        this.archivoE = new File("archivoE.dat");
        this.archivoA = new File("archivoA.dat");
        this.archivoC = new File("archivoC.dat");
        this.archivoR = new File("archivoR.dat");
    }
    
    public List<Ejercicio> agregarEjercicio(List<Ejercicio> ejercicios, Ejercicio nuevo)throws ExcepcionFidness{
        if(buscarEjercicio(ejercicios, nuevo.getNombre()) != null){
            throw new ExcepcionFidness("El ejercicio '" + nuevo.getNombre() + "' ya se encuentra registrado.");
        }
        ejercicios.add(nuevo);
        JOptionPane.showMessageDialog(null, "Ejercicio agregado con éxito");
        return ejercicios;
    }
    
    public List<Ejercicio> eliminarEjercicio(List<Ejercicio> ejercicios, Ejercicio nuevo)throws ExcepcionFidness{
        if (buscarEjercicio(ejercicios, nuevo.getNombre()) == null) {
            throw new ExcepcionFidness("El ejercicio no existe en el sistema.");
        }
        ejercicios.remove(nuevo);
        JOptionPane.showMessageDialog(null, "Ejercicio eliminado correctamente.");
        return ejercicios;
    }
    
    public Ejercicio buscarEjercicio(List<Ejercicio> ejercicios, String nom){
        for(Ejercicio e : ejercicios){
            if(e.getNombre().equalsIgnoreCase(nom)){
                return e;
            }
        }
        return null;
    }
    
    public void mostrarEjercicios(List<Ejercicio> ejercicios){
        String contenido = "";
        for(Ejercicio ejer : ejercicios){
            contenido = contenido + "\n" + ejer.toString();
        }
        JOptionPane.showMessageDialog(null, "Ejercicios guardados" + contenido);
    }
    
    public List<Ejercicio> cargarEjerciciosFile()throws IOException, ClassNotFoundException{
        if(!archivoE.exists()){
            return new ArrayList<>();
        }
        try(FileInputStream archivoEinput = new FileInputStream(archivoE);ObjectInputStream obInput = new ObjectInputStream(archivoEinput)){
            Object contenido = obInput.readObject();
            if(!(contenido instanceof List<?>)){
                throw new IOException("El archivo no contiene una lista");
            }
            List<?> registros = (List<?>) contenido;
            List<Ejercicio> ejercicios = new ArrayList<>();
            for(Object registro : registros){
                if(!(registro instanceof Ejercicio)){
                    throw new IOException("Se encontró un registro que no es un ejercicio");
                }
                ejercicios.add((Ejercicio) registro);
            }
            return ejercicios;
        }
    }
    
    public void guardarEjerciciosFile(List<Ejercicio> ejercicios)throws IOException{
        File carpeta = archivoE.getParentFile();
        if(carpeta != null && !carpeta.exists() && !carpeta.mkdirs()){
            throw new IOException("No se puede crear la carpeta");
        }
        try(FileOutputStream archivoEoutput = new FileOutputStream(archivoE);
            ObjectOutputStream obOutput = new ObjectOutputStream(archivoEoutput)){
            obOutput.writeObject(new ArrayList<>(ejercicios));
        }
    }
    
    public List<Administrador> agregarAdmin(List<Administrador> admins, Administrador ad)throws ExcepcionFidness{
        if(buscarAdmin(admins, ad.getIdUsuario())){
            throw new ExcepcionFidness("El administrador con el id '" + ad.getIdUsuario() + "' ya se encuentra registrado.");
        }
        admins.add(ad);
        JOptionPane.showMessageDialog(null, "Administrador agregado con éxito");
        return admins;
    }
    
    public boolean buscarAdmin(List<Administrador> admins, String id){
        boolean encontrado = false;
        if(admins == null || id == null){
            return encontrado;
        }
        for(Administrador admin : admins){
            if(admin != null && admin.getIdUsuario() != null){
                if(admin.getIdUsuario().equalsIgnoreCase(id)){
                    encontrado = true;
                    break;
                }
            }
        }
        return encontrado;
    }
    
    public List<Administrador> cargarAdminFile()throws IOException, ClassNotFoundException{
        if(!archivoA.exists()){
            return new ArrayList<>();
        }
        try(FileInputStream archivoAinput = new FileInputStream(archivoA);ObjectInputStream obInput = new ObjectInputStream(archivoAinput)){
            Object contenido = obInput.readObject();
            if(!(contenido instanceof List<?>)){
                throw new IOException("El archivo no contiene una lista");
            }
            List<?> registros = (List<?>) contenido;
            List<Administrador> admins = new ArrayList<>();
            for(Object registro : registros){
                if(!(registro instanceof Administrador)){
                    throw new IOException("Se encontró un registro que no es un administrador");
                }
                admins.add((Administrador) registro);
            }
            return admins;
        }
    }
    
    public void guardarAdminFile(List<Administrador> admins)throws IOException{
        File carpeta = archivoA.getParentFile();
        if(carpeta != null && !carpeta.exists() && !carpeta.mkdirs()){
            throw new IOException("No se puede crear la carpeta");
        }
        try(FileOutputStream archivoAoutput = new FileOutputStream(archivoA);ObjectOutputStream obOutput = new ObjectOutputStream(archivoAoutput)){
            obOutput.writeObject(new ArrayList<>(admins));
        }
    }
     
    public List<Cliente> agregarCliente(List<Cliente> clientes, Cliente client)throws ExcepcionFidness{
        if(buscarCliente(clientes, client.getIdUsuario())){
            throw new ExcepcionFidness("El cliente con el id '" + client.getIdUsuario() + "' ya se encuentra registrado.");
        }
        clientes.add(client);
        JOptionPane.showMessageDialog(null, "Cliente agregado con éxito");
        return clientes;
    }
    
    public boolean buscarCliente(List<Cliente> clientes, String id){
        boolean encontrado = false;
        if(clientes == null || id == null){
            return encontrado;
        }
        for(Cliente c : clientes){
            if(c != null && c.getIdUsuario() != null){
                if(c.getIdUsuario().equalsIgnoreCase(id)){
                    encontrado = true;
                    break;
                }
            }
        }
        return encontrado;
    }
    
    public List<Cliente> cargarClientesFile()throws IOException, ClassNotFoundException{
        if(!archivoC.exists()){
            return new ArrayList<>();
        }
        try(FileInputStream archivoCinput = new FileInputStream(archivoC);ObjectInputStream obInput = new ObjectInputStream(archivoCinput)){
            Object contenido = obInput.readObject();
            if(!(contenido instanceof List<?>)){
                throw new IOException("El archivo no contiene una lista");
            }
            List<?> registros = (List<?>) contenido;
            List<Cliente> clientes = new ArrayList<>();
            for(Object registro : registros){
                if(!(registro instanceof Cliente)){
                    throw new IOException("Se encontró un registro que no es un cliente");
                }
                clientes.add((Cliente) registro);
            }
            return clientes;
        }
    }
    
    public void guardarClientesFile(List<Cliente> clientes)throws IOException{
        File carpeta = archivoC.getParentFile();
        if(carpeta != null && !carpeta.exists() && !carpeta.mkdirs()){
            throw new IOException("No se puede crear la carpeta");
        }
        try(FileOutputStream archivoCoutput = new FileOutputStream(archivoC);ObjectOutputStream obOutput = new ObjectOutputStream(archivoCoutput)){
            obOutput.writeObject(new ArrayList<>(clientes));
        }
    }
    
    public List<Rutina> agregarRutina(List<Rutina> rutinas, Rutina nueva) throws ExcepcionFidness {
        if(buscarRutina(rutinas, nueva)){
            throw new ExcepcionFidness("La rutina con el nombre '" + nueva.getNombre() + "' y el cliente '"+ nueva.getCliente().getNombre()+"' ya se encuentra registrada.");
        }
        rutinas.add(nueva);
        return rutinas;
    }
    
    public boolean buscarRutina(List<Rutina> rutinas, Rutina nueva){
        boolean encontrado = false;
        if(rutinas == null || nueva == null){
            return encontrado;
        }
        for(Rutina ru : rutinas){
            if(ru != null && ru.getCliente().getIdUsuario() != null){
                if(ru.getNombre().equalsIgnoreCase(nueva.getNombre()) && ru.getCliente().getIdUsuario().equalsIgnoreCase(nueva.getCliente().getIdUsuario())){
                    encontrado = true;
                    break;
                }
            }
        }
        return encontrado;
    }
    
    public List<Rutina> cargarRutinasFile()throws IOException, ClassNotFoundException{
        if(!archivoR.exists()){
            return new ArrayList<>();
        }
        try(FileInputStream archivoRinput = new FileInputStream(archivoR);ObjectInputStream obInput = new ObjectInputStream(archivoRinput)){
            Object contenido = obInput.readObject();
            if(!(contenido instanceof List<?>)){
                throw new IOException("El archivo no contiene una lista");
            }
            List<?> registros = (List<?>) contenido;
            List<Rutina> rutinas = new ArrayList<>();
            for(Object registro : registros){
                if(!(registro instanceof Rutina)){
                    throw new IOException("Se encontró un registro que no es una rutina");
                }
                rutinas.add((Rutina) registro);
            }
            return rutinas;
        }
    }
    
    public void guardarRutinasFile(List<Rutina> rutinas)throws IOException{
        File carpeta = archivoR.getParentFile();
        if(carpeta != null && !carpeta.exists() && !carpeta.mkdirs()){
            throw new IOException("No se puede crear la carpeta");
        }
        try(FileOutputStream archivoRoutput = new FileOutputStream(archivoR);ObjectOutputStream obOutput = new ObjectOutputStream(archivoRoutput)){
            obOutput.writeObject(new ArrayList<>(rutinas));
        }
    }
    
}
