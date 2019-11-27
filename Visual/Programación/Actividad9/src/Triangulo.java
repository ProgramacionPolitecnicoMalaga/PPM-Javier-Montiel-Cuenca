public class Triangulo extends FigurasGeometricas{
    String color;
    double base;
    double altura;
    public Triangulo(String color, double base, double altura) {
        this.color = color;
        this.base = base;
        this.altura = altura;
    }
    @Override
    public double calcularArea(double a, double b) {
        double area;
        area=a*b/2;
        return area;
    }

    @Override
    public String getColor() {
        String color=getClass().getName();
        return color;

    }



    @Override
    public String getTipoFigura() {
        String figura=getClass().getName();
        return figura;
    }


}
