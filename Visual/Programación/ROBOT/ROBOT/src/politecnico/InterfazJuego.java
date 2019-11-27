package politecnico;

import java.util.Scanner;

public class InterfazJuego {
    Scanner lectorTeclado;
    Tablero tablero=new Tablero();

    public InterfazJuego(){
        lectorTeclado = new Scanner(System.in).useDelimiter("\n");
    }

    public void cartelIntroducirNuevosRobots(){
        System.out.println("\n\nAHORA DEBES INTRODUCIR NUEVOS ROBOTS\n" +
                "=========================================\n\n");
    }

    public void cartelInicioJuego(){
        System.out.println("BIENVENIDO AL JUEGO DE LOS ROBOTS\n" +
                "==================================\n\n");
    }

    private int pedirEntero(String mensajeMostrado){
        System.out.print(mensajeMostrado);
        String textoIntroducido = lectorTeclado.nextLine();
        if (textoIntroducido.matches("[0-9]*")){
            return Integer.parseInt(textoIntroducido);
        } else
            return Integer.MIN_VALUE;
    }

    public Coordenadas pedirAnchoYAltoTablero(){
        int ancho = -1, alto = -1;
        while ((ancho < 0) && (alto < 0)){
            ancho = pedirEntero("Por favor, indica el ancho del tablero [1-?]:");
            alto = pedirEntero("Por favor, indica el alto del tablero: [1-?]:");
            if ((ancho < 0) || (alto < 0)){
                System.out.println("El ancho y el alto deben ser números mayores de que cero. Por favor, vuelva a introducir valores válidos.");
            }
        }
        return new Coordenadas(ancho,alto);
    }

    public String pedirNombreNuevoRobot(){
        System.out.print("Por favor, indique el nombre del nuevo robot :");
        return lectorTeclado.next();
    }

    public void cartelRobotRepetido(String nombreNuevoRobot){
        System.out.println("El robot " + nombreNuevoRobot + " ya existe. Por favor, elija otro nombre");
    }

    public boolean usuarioDeseaCrearNuevoRobot(){
        System.out.println("¿Desea crear un nuevo robot? (Pulse S para responder Sí, o cualquier otra tecla para responder No) :");
        String respuesta = lectorTeclado.next();
        if (respuesta.toUpperCase().equals("S"))
            return true;
        else
            return false;
    }
    public int pedirtipomovimiento(){
        int eleccion;
        do {
            System.out.println("Elige el tipo de movimiento para tu robot: \n" +
                    "1- Movimiento Basico \n 2- Movimiento en L \n 3-Movimiento en diagonal");
            lectorTeclado.nextLine();//comentar
            eleccion=Integer.parseInt(lectorTeclado.nextLine());

        }while(eleccion>3 || eleccion<1);
            return eleccion;
    }

    public void mostrarTurnoRobot(Robot robot){
        if (robot != null) {
            System.out.println("-------------------------------------");
            System.out.println("Turno del robot " + robot.getNombre());
            System.out.println(robot.getNombre() + " está en la posición " + robot.getCoordenadas());
        }
    }
    public boolean confirmarmovimientovalido(int numero){
        boolean confirmarmovimiento=true;
        if ((numero < 1) || (numero > 4)) {
            System.out.println("El movimiento elegido debe estar entre 1 y 4. Por favor, vuelva a introducir valores válidos");
            confirmarmovimiento=false;
        }
        return confirmarmovimiento;
    }
    public int movimientobasico(){
        int movimiento;
        System.out.println(Movimiento.HACIA_ARRIBA + ". Hacia arriba\n" +
                Movimiento.HACIA_DERECHA + ". Hacia la derecha\n" +
                Movimiento.HACIA_ABAJO + ". hacia abajo\n" +
                Movimiento.HACIA_IZQUIERDA + ". hacia la izquierda\n");
        movimiento = pedirEntero("Elija una opción: ");
        return movimiento;
    }
    public int movimientoenL(){
        int movimiento;
        System.out.println(Movimiento.HACIA_ARRIBA + ". Hacia Arriba-Derecha en L\n" +
                Movimiento.HACIA_DERECHA + ". Hacia la Abajo-Izquierda en L\n" +
                Movimiento.HACIA_ABAJO + ". hacia Abajo-Izquierda en L\n" +
                Movimiento.HACIA_IZQUIERDA + ". hacia Arriba-Izquierda en L\n");
        movimiento = pedirEntero("Elija una opción: ");
        return movimiento;
    }
    public int movimientoendiagonal(){
        int movimiento;
        System.out.println(Movimiento.HACIA_ARRIBA + ". Hacia Arriba-Derecha\n" +
                Movimiento.HACIA_DERECHA + ". Hacia la Abajo-Izquierda\n" +
                Movimiento.HACIA_ABAJO + ". hacia Abajo-Izquierda\n" +
                Movimiento.HACIA_IZQUIERDA + ". hacia Arriba-Izquierda\n");
        movimiento = pedirEntero("Elija una opción: ");
        return movimiento;
    }
    public int comparaypideMovimiento(Robot robot){
        int movimiento=0;
        if(robot.getTipomovimiento().equalsIgnoreCase("Basico")){
            movimiento=movimientobasico();
        }
        if(robot.getTipomovimiento().equalsIgnoreCase("L")){
            movimiento=movimientoenL();
        }
        if(robot.getTipomovimiento().equalsIgnoreCase("Diagonal")){
            movimiento=movimientoendiagonal();
        }
        return movimiento;
    }

    public int pedirMovimientoParaRobot(String nombreRobot){
        int movimiento = -1;
        do {
            System.out.println("Elija un movimiento para "+nombreRobot);
            Robot robot=tablero.getRobot(nombreRobot);
            movimiento=comparaypideMovimiento(robot);
        } while (confirmarmovimientovalido(movimiento));
        return movimiento;
    }

    public void cartelRobotGanador(String nombreRobotGanador){
        System.out.println("=======================================================================");
        System.out.println("EL ROBOT GANADOR ES: " + nombreRobotGanador);
        System.out.println("=======================================================================");
    }

}