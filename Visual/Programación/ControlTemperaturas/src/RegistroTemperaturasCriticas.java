public class RegistroTemperaturasCriticas implements ConsumidorDeTemperaturas {
    private double[] temperaturasCriticas;
    private  final static double UMBRAL_SUPERIOR=110.0;
    public  RegistroTemperaturasCriticas(){
        temperaturasCriticas =new double[24];

    }
    @Override
    public void setNuevaTemperatura(double temperatura, int hora) {
        if(temperatura>UMBRAL_SUPERIOR){
            temperaturasCriticas[hora]++;
        }
    }

    @Override
    public String toString() {
        String textoTemperaturascriticas="";
        for(int i=0;i<temperaturasCriticas.length;i++){
            textoTemperaturascriticas+= i+"("+temperaturasCriticas[i]+") -";
        }
        return  textoTemperaturascriticas;
    }
}
