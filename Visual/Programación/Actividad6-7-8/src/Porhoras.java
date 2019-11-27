public class Porhoras extends Empleados {
    private double sueldoPorHora;
    private double horasTrabajadas;
    public Porhoras(String nombre, String apellidos,String DNI ,double horasTrabajadas,double sueldoPorHora) {
        super(nombre, apellidos,DNI);
        this.horasTrabajadas=horasTrabajadas;
        this.sueldoPorHora=sueldoPorHora;
    }

    @Override
    public double getsueldo() {
        return sueldoPorHora*horasTrabajadas;
    }
    public double getHorasTrabajadas(){
        return horasTrabajadas;
    }
    /*public String toString(){
        return super.toString()+"\n Sueldo: "+getsueldo()+"\nNumero de Horas: "+getHorasTrabajadas();
    }*/
    public String getSpecificdata(){
        return "\n Horas Trabajadas: "+horasTrabajadas+"\n Sueldo por Hora: "+sueldoPorHora+"\n Sueldo: "+getsueldo();
    }
}

