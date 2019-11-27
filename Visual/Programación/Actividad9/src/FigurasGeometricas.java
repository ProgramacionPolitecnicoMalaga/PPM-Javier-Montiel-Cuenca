public abstract class FigurasGeometricas {

    public abstract double calcularArea(double a, double b);
    public abstract String getColor();
    public abstract  String getTipoFigura();

    public static void main(String[] args) {
        FigurasGeometricas[] figuras=new FigurasGeometricas[5];
        figuras[0]=new Circulo("verde",5);
        figuras[1]=new Cuadrado("amarillo",4);
        figuras[2]=new Triangulo("rojo",3,5);
        figuras[3]=new Triangulo("morado",5,6);
        figuras[4]=new Cuadrado("azul",5);
    }

}
