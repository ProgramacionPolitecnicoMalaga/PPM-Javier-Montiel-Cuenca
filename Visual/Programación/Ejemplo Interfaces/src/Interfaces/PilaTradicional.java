package Interfaces;

public class PilaTradicional implements SentenciadeDatos {
    Persona [] pila;
    int cabeza;
    public PilaTradicional(int tamaño) {
        pila=new Persona[tamaño];
        cabeza=-1;
    }

    @Override
    public void insertar(Persona persona) {
        if(cabeza<pila.length){
            cabeza++;
            pila[cabeza]=persona;
        }
    }

    @Override
    public Persona extraer() {
        if(cabeza>=0){
            return pila[cabeza];
        }
        return null;
    }
    @Override
    public void remove(){
        if(cabeza>=0){
            pila[cabeza]=null;
            cabeza--;
        }
    }
}
