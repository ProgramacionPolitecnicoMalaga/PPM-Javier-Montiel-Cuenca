import java.util.Scanner;

public class MiMain {
    public static void main(String[] args) {
        DiarioDeTemperaturas diario=new DiarioDeTemperaturas();
        RegistroTemperaturasCriticas registro= new RegistroTemperaturasCriticas();
        PromedioTemperatura promedio=new PromedioTemperatura();
        Scanner teclado=new Scanner(System.in).useDelimiter("\n");
        boolean terminar=false;
        int hora;
        double temperatura;
        String terminado;
        while(!terminar){
            System.out.print("Indica hora:");
            hora=Integer.parseInt(teclado.nextLine());
            System.out.print("Indica temperatura:");
            temperatura=Double.parseDouble(teclado.nextLine());
            System.out.println("=================================================");
            System.out.println("¿Terminar? : ");
            terminado=teclado.nextLine();
        }
    }
}
