public abstract class Empleados {
    String nombre;
    String apellidos;
    String DNI;
    public Empleados(String nombre, String apellidos,String DNI) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI=DNI;
    }
    public abstract double getsueldo();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    /*public String toString(){
        return "Nombre: "+nombre+"\n Apellidos: "+apellidos+"\n DNI: "+DNI;
    }*/
    public abstract String getSpecificdata();
    public String toString(){
        return "Nombre: "+nombre+"\n Apellidos: "+apellidos+"\n DNI: "+DNI+getSpecificdata();
    }


}
