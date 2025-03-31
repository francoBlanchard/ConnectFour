public class Jugador1 extends Jugador{

    //atributos


    //constructor
    public Jugador1() {
        super();
    }

    @Override
    protected void setFichaJugador(char fichaJugador) {
        super.setFichaJugador('X');
    }

    //getter
/*    public char getFichaJugador() {
        return fichaJugador;
    }*/

    //mensaje
    @Override
    public void victoria() {
        System.out.println(" - ");
    }
}
