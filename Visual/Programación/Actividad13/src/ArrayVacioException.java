public class ArrayVacioException extends Exception{
    public ArrayVacioException(){
        System.out.println(getMessage());
    }
    public String getMessage() {
        return "Cola vacia, rellena la cola antes";

    }
}
