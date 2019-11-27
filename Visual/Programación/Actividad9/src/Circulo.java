public class Circulo extends FigurasGeometricas {
    String color;
    double radio;

    public Circulo(String color, double radio) {
        this.color = color;
        this.radio = radio;
    }

    @Override
    public double calcularArea(double a, double b) {
        double area=Math.PI *Math.pow (a, 2);;
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
