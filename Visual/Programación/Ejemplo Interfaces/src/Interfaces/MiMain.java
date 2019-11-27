package Interfaces;

public class MiMain {
    public static void main(String[] args) {
        SentenciadeDatos secuencia = new PilaTradicional(10);
        secuencia.insertar(new Persona("Borja","Badia"));
        secuencia.insertar(new Persona("Roberto","Muñoz de Leon"));
        secuencia.insertar(new Persona("Rocio","Reina"));
        System.out.println(secuencia.extraer());
        secuencia.remove();
        System.out.println(secuencia.extraer());

    }
}
