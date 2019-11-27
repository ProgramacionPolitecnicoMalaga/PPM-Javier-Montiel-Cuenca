public class Asalariado extends Empleados {
    private int sueldo;
    public Asalariado(String nombre, String apellidos,String DNI,int sueldo) {
        super(nombre, apellidos,DNI);
        this.sueldo=sueldo;
    }

    @Override
    public double getsueldo() {
        return sueldo;
    }

    @Override
    public String getSpecificdata() {
        return "\n Sueldo: "+getsueldo();
    }
    /*public String toString(){
        return super.toString()+"Sueldo: "+getsueldo();
    }*/

}
