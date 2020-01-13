public class Ventas {
    int numeroVentas;
    String diaSemana;

    public int getNumeroVentas() {
        return numeroVentas;
    }

    public Ventas(int numeroVentas,String diaSemana) {
        this.numeroVentas = numeroVentas;
        this.diaSemana=diaSemana;
    }

    @Override
    public String toString() {
        return diaSemana+" ; Ventas: "+numeroVentas;
    }
}
