import java.util.ArrayList;

public class Empleados {
    ArrayList<Empleado>listaEmpleados=new ArrayList<Empleado>();
    public void insertarNuevoEmpleado(Empleado empleado){
        listaEmpleados.add(empleado);
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public Empleado empleadoConMasVentasEnUnDia(){
        Empleado empleadoConMasVentas=null;
        int maximoVentasDia=0;
        for(Empleado empleado:listaEmpleados){
            for(Ventas venta:empleado.getVentas()){
                if(venta.getNumeroVentas()>maximoVentasDia){
                    maximoVentasDia=venta.getNumeroVentas();
                    empleadoConMasVentas=empleado;
                }
            }
        }
        return empleadoConMasVentas;
    }
    public ArrayList<Empleado> empleadosConNumeroDeObjetosVendidos(int numObj){
        ArrayList<Empleado> empleados=new ArrayList<Empleado>();
        for(Empleado empleado:listaEmpleados){
            for(Ventas venta:empleado.getVentas()){
                if(venta.getNumeroVentas()==numObj){
                   empleados.add(empleado);
                }
            }
        }
        return empleados;
    }
}
