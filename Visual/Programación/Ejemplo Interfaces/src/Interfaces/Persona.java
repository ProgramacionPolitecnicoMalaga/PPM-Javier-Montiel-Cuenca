package Interfaces;

public class Persona {
    String nombre;
    String apellidos;
    public Persona(String nombre, String apellidos){
        this.nombre=nombre;
        this.apellidos=apellidos;
    }

    @Override
    public String toString() {
        return nombre+ " "+apellidos;
    }
}
