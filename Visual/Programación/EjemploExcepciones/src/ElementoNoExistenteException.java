public class ElementoNoExistenteException extends Exception{
    public ElementoNoExistenteException(String messaje, int LongitudMaxima){
        super.getMessage();
        System.out.println("La longitud máxima es: "+LongitudMaxima);
    }
    public String advertencia(){
        return "Ten mas cuidadito la proxima vez";
    }

}
