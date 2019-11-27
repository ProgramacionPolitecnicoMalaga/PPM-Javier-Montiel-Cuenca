public class DiarioDeTemperaturas implements ConsumidorDeTemperaturas {
    private double temperaturaPorHoras[];
    public DiarioDeTemperaturas(){
       temperaturaPorHoras=new double[24];
    }
    @Override
    public void setNuevaTemperatura(double temperatura, int hora) {
        temperaturaPorHoras[hora]=temperatura;
    }

    @Override
    public String toString() {
        String cadena="";
        for (int f=0;f<temperaturaPorHoras.length;f++){
            cadena+= f +"("+temperaturaPorHoras[f]+")"+"-";
        }
        return cadena;
    }
}
