import java.util.Scanner;

public class Hotel {
    Scanner teclado=new Scanner(System.in);
    public Clientes pedirDatosCliente(){
        String nombre;
        String apellidos;
        String DNI;
        System.out.print("Introduzca Nombre: ");
        nombre=teclado.nextLine();
        System.out.print("Introduzca Apellidos: ");
        apellidos=teclado.nextLine();
        System.out.print("Introduzca DNI: ");
        DNI=teclado.nextLine();
        Clientes cliente=new Clientes(nombre,apellidos,DNI);
        return cliente;
    }


}
