package politecnico;

import javax.swing.*;

public class JuegoRobot {
    private static InterfazJuego interfazJuego;
    private static Tablero tablero;
    private static Robot robotGanador;

    public static void inicializarJuego(){
        robotGanador = null;
        interfazJuego  = new InterfazJuego();
        interfazJuego.cartelInicioJuego();
        Coordenadas anchoAltoTablero = interfazJuego.pedirAnchoYAltoTablero();
        tablero = new Tablero(anchoAltoTablero);
    }

    public static void crearRobotsParaElJuego(){
        interfazJuego.cartelIntroducirNuevosRobots();
        do{
            String nombreNuevoRobot = interfazJuego.pedirNombreNuevoRobot();
            String tipomovimiento=asignartipomovimiento();
            if (!tablero.estaEnTablero(nombreNuevoRobot)) {
                Robot nuevoRobot = new Robot(nombreNuevoRobot, new Coordenadas(0, 0),tipomovimiento);
                System.out.println("fbyfn thgn fnfnyfnyhnmh");
                tablero.anadirRobot(nuevoRobot);
            } else
                interfazJuego.cartelRobotRepetido(nombreNuevoRobot);
        } while (interfazJuego.usuarioDeseaCrearNuevoRobot());
    }
    public static  String asignartipomovimiento(){
        String tipomovimiento="";
        int eleccion=interfazJuego.pedirtipomovimiento();
        switch (eleccion){
            case 1:
                tipomovimiento="Basico";
                break;
            case 2:
                tipomovimiento="L";
                break;
            case 3:
                tipomovimiento="Diagonal";
                break;
            default:
                tipomovimiento="Basico";
        }
        return tipomovimiento;
    }

    public static void moverRobotEnTablero( int tipoDeMovimiento, Tablero tablero, String nombreRobot){
        Movimiento movimiento = new Movimiento();
        MovimientoenL movimientoL=new MovimientoenL();
        MovimientoDiagonal movimientodiagonal=new MovimientoDiagonal();
        Robot robotAMover = tablero.getRobot(nombreRobot);
        if (robotAMover != null){
            switch (robotAMover.getTipomovimiento()){
                case "Basico":
                    movimiento.mover(robotAMover.getCoordenadas(),tipoDeMovimiento);
                    break;
                case "L":
                    movimientoL.mover(robotAMover.getCoordenadas(),tipoDeMovimiento);
                    break;
                case "Diagonal":
                    movimientodiagonal.mover(robotAMover.getCoordenadas(),tipoDeMovimiento);
                    break;
            }

        }
    }

    public static void iniciarJuego(){
        Movimiento mov =new Movimiento();
        do {
            for (int i = 0; i < tablero.getNumeroActualDeRobots(); i++) {
                Robot robotActual = tablero.getRobot(i);
                interfazJuego.mostrarTurnoRobot(robotActual);
                int movimiento = interfazJuego.pedirMovimientoParaRobot(robotActual.getNombre());
                moverRobotEnTablero(movimiento, tablero, robotActual.getNombre());
                if(!tablero.estaEnTablero(robotActual.getCoordenadas())){
                    System.out.println("Te has salido del tablero. Deshaciendo movimiento");
                    mov.deshacerMovimiento(robotActual.getCoordenadas(),movimiento);
                }
                if (tablero.estaRobotEnObjetivo(robotActual.getNombre()))
                    robotGanador = robotActual;
            }
        } while (!hayRobotGanador());
    }

    public static boolean hayRobotGanador(){
        return robotGanador != null;
    }

    public static void main(String[] args) {
        inicializarJuego();
        crearRobotsParaElJuego();
        iniciarJuego();
        interfazJuego.cartelRobotGanador(robotGanador.getNombre());
    }
}


















/*public class politecnico.JuegoRobot {

    public static void mostrarInfoPunto(politecnico.Coordenadas punto){
        System.out.println("Las coordenadas son (" +
                punto.getX() + "," +
                punto.getY() + ")");
    }

    public static void mostrarInfoRobot(politecnico.Robot robot){
        System.out.println( robot.getNombre() +
                "---> (" +
                robot.getCoordenadas().getX() +
                "," +  ")" +
                robot.getCoordenadas().getY());
    }

    public static void main(String[] args) {
        politecnico.Tablero tablero = new politecnico.Tablero(10,10);
        politecnico.Robot astroboy = new politecnico.Robot(astroboy, new politecnico.Coordenadas(0,0));
        tablero.anadirRobot(astroboy);
        if (tablero(astroboy.getNombre()){
            System.out.println("pepe está");}
    }
    /*  AÑADIR EL SIGUIENTE MÉTODO
        public static void moverRobotEnTablero( int tipoDeMovimiento, politecnico.Tablero tablero, String nombreRobot){
     */


  /*  public static void main(String[] args) {/*Equals*/
     /*   politecnico.Coordenadas punto = new politecnico.Coordenadas(0,0);
        mostrarInfoPunto(punto);
        politecnico.Movimiento movimiento = new politecnico.Movimiento();
        punto = movimiento.mover(punto,politecnico.Movimiento.HACIA_ARRIBA);
        mostrarInfoPunto(punto);


      /*  movimiento = new politecnico.Movimiento();*/ /*LO he añadido yo*/

        //-------------------------
     /*   politecnico.Robot robot1 = new politecnico.Robot("C3PO",new politecnico.Coordenadas(0,0));
        mostrarInfoRobot(robot1);
        //-------------------------

        politecnico.Coordenadas punto1 = new politecnico.Coordenadas(4,5);
        politecnico.Coordenadas punto2 = new politecnico.Coordenadas(0,0);

        politecnico.Coordenadas punto3 = punto1.compararCon(punto2);
        System.out.println("Punto3 = (" + punto3.getX() +
                "," +
                punto3.getY()+")");


    }


}*/
