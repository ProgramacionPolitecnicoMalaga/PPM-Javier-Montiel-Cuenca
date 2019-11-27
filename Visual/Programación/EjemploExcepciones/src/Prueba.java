public class Prueba {
    static int []array={4,5,3,2,6};
    public static void bucle(int i){
        try{
            System.out.println(array[i]);

        }catch ( ArrayIndexOutOfBoundsException e){
            System.out.print("El indice estaba fuera del limite");
        }

    }
    public int getElemento(int i) throws ElementoNoExistenteException{
        throw new ElementoNoExistenteException()
    }

    public static void main(String[] args) {
        bucle(8);
    }
}
