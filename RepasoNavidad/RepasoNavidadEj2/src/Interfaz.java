import java.util.ArrayList;
import java.util.Scanner;

public class Interfaz {
    static Scanner teclado =new Scanner(System.in);
    public static int menu(){
        System.out.println("1-Empleados que vendieron un numero de items \n" +
                "2-Obtener el promedio de ventas en cada uno \n" +
                "3-Averiguar quien ha consegido el mayor numero de ventas en un dia \n" +
                "4-Insertar un nuevo empleado y sus ventas \n" +
                "5-Leer Lista Empleados \n"+
                "6-Salir");
        return Integer.parseInt(teclado.nextLine());

    }
    public static Empleado insertarDatosEmpleado(){
        System.out.println("Nombre del nuevo empleado: ");
        String nombre=teclado.nextLine();
        System.out.println("Apellido del nuevo empleado: ");
        String apellido=teclado.nextLine();
        ArrayList<Ventas> ventas=insertarVentasEmpleado();
        Empleado empleado=new Empleado(nombre,apellido,ventas);
        return empleado;
    }
    public static ArrayList<Ventas> insertarVentasEmpleado(){
        ArrayList<Ventas> ventas=new ArrayList<Ventas>();
        DiaSemana dia=new DiaSemana();
        for(int f=0;f<=4;f++){
            System.out.println("Introduce venta del dia");
            int ventasDia=Integer.parseInt(teclado.nextLine());
            Ventas venta=new Ventas(ventasDia,dia.devolverDiaSemana(f));
            ventas.add(venta);
        }
        return ventas;
    }

    public static void main(String[] args) {
        Empleados lista=new Empleados();
        boolean salir=false;
        do {
            switch (menu()){
                case 1:
                    System.out.println("Número de items a buscar: ");
                    int numero=Integer.parseInt(teclado.nextLine());
                    System.out.println(lista.empleadosConNumeroDeObjetosVendidos(numero));
                    break;
                case 2:
                    for(Empleado empleado:lista.getListaEmpleados()){
                        System.out.println(empleado.getNombre()+" ;Promedio"+empleado.getPromedioVentas());
                    }
                    break;
                case 3:
                    System.out.println(lista.empleadoConMasVentasEnUnDia());
                    break;
                case 4:
                    lista.insertarNuevoEmpleado(insertarDatosEmpleado());
                    break;
                case 5:
                    System.out.println(lista.getListaEmpleados());
                    break;
                case 6:
                    salir=true;
                    break;
            }
        }while(!salir);


    }
}
