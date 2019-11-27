package politecnico;

import politecnico.Coordenadas;

public class Robot {
    Coordenadas coordenadas;
    private String nombre;
    String tipomovimiento;

    public String getTipomovimiento() {
        return tipomovimiento;
    }

    public void setTipomovimiento(String tipomovimiento) {
        this.tipomovimiento = tipomovimiento;
    }

    public Robot(String nombre, Coordenadas posicionInicial, String tipomovimiento){
        this.nombre = nombre;
        this.coordenadas = posicionInicial;
        this.tipomovimiento=tipomovimiento;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setCoordenadas(Coordenadas coordenadas){
        this.coordenadas = coordenadas;
    }

    public Coordenadas getCoordenadas(){
        return coordenadas;
    }
}