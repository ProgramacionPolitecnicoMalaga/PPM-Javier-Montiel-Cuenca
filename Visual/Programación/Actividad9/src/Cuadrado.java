public class Cuadrado extends FigurasGeometricas{
    String color;
    double lado;

    public Cuadrado(String color, double lado) {
        this.color = color;
        this.lado = lado;
    }

    @Override
    public double calcularArea(double a, double b) {
        double area=Math.pow(a,2);
        return area;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getTipoFigura() {
        String figura=getClass().getName();
        return figura;
    }
}
