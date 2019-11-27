public class Comisionado extends Empleados{
    double sueldoBase;
    int numVentas;
    double comisionporventa;
    public Comisionado(String nombre, String apellidos,String DNI, double sueldoBase,int numVentas,double comisionporventa) {
        super(nombre, apellidos,DNI);
        this.sueldoBase=sueldoBase;
        this.numVentas=numVentas;
        this.comisionporventa=comisionporventa;
    }

    @Override
    public double getsueldo() {
        return sueldoBase+(numVentas*comisionporventa);
    }

    @Override
    public String getSpecificdata() {
        return "\nSueldo Base: "+sueldoBase+"\n Numero de ventas: "+numVentas+
                "\n Comision de ventas: "+comisionporventa+"\n Sueldo: "+getsueldo();
    }

    public String toString(){
        return super.toString()+"Sueldo: "+getsueldo();
    }
}

