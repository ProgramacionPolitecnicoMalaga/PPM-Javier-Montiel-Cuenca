import java.util.ArrayList;

public class Empleado {
    String nombre;
    String apellido;
    ArrayList<Ventas> ventas=new ArrayList<Ventas>();
    public Empleado(String nombre, String apellido, ArrayList<Ventas> ventas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ventas = ventas;
    }

    public double getPromedioVentas(){
        double promedio=0;
        for(Ventas ventasDelDia: ventas){
            promedio+=ventasDelDia.getNumeroVentas();
        }
        promedio=promedio/ventas.size();
        return promedio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public ArrayList<Ventas> getVentas() {
        return ventas;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+" ; Apellido: "+apellido+" ; "+ventas+"\n";
    }
}
