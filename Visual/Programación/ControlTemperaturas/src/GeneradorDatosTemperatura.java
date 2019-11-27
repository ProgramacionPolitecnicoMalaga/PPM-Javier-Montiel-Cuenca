import java.util.Scanner;

public class GeneradorDatosTemperatura implements FuenteDeTemperatura{
    private  double ultimatemperaturaregistrada;
    private int ultimahoraregistrada;
    private ConsumidorDeTemperaturas[] consumidores;
    private  final  static int MAX_CONSUMIDORES=100;
    private  int numeroconsumidores;
    public GeneradorDatosTemperatura(){
        numeroconsumidores=0;
        consumidores =new ConsumidorDeTemperaturas[MAX_CONSUMIDORES];
    }
    @Override
    public void registrarConsumidor(ConsumidorDeTemperaturas consumidor) {
        consumidores[numeroconsumidores]=consumidor;
        numeroconsumidores++;
    }

    @Override
    public void informaraconsumidores() {
        for(int f=0; f<numeroconsumidores;f++){
            consumidores[f].setNuevaTemperatura(ultimatemperaturaregistrada,ultimahoraregistrada);
        }
    }
    public void NuevalecturadeTemperatura(double temperatura, int hora) {
        this.ultimahoraregistrada=hora;
        this.ultimatemperaturaregistrada=temperatura;
        informaraconsumidores();
    }
}
