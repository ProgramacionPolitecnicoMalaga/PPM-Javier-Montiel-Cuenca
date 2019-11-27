package politecnico;

public class MovimientoenL extends Movimiento {
    @Override
    public Coordenadas mover(Coordenadas punto, int movimiento) {

         switch(movimiento){
            case 1:
                punto.setX(punto.getX()+2);
                punto.setY(punto.getY()+1);
                break;
            case 2:
                punto.setY(punto.getX()-1);
                punto.setX(punto.getX()+2);
                break;
            case 3:
                punto.setX(punto.getX()-2);
                punto.setY(punto.getY()-1);
                break;
            case 4:
                punto.setY(punto.getY()+1);
                punto.setX(punto.getX()-2);
         }
         return punto;

    }

    @Override
    public void deshacerMovimiento(Coordenadas coordenadas, int tipoDeMovimiento) {
        switch(tipoDeMovimiento){
            case 3:
                mover(coordenadas,1);
                break;
            case 4:
                mover(coordenadas,2);
                break;
            case 1:
                mover(coordenadas,3);
                break;
            case 2:
                mover(coordenadas,4);
        }
    }
}
