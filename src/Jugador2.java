public class Jugador2 extends Jugador{


    //constructor
    public Jugador2() {
        super();
    }

    @Override
    protected void setFichaJugador(char fichaJugador) {
        super.setFichaJugador('0');
    }



    //mensaje
    @Override
    public void victoria() {
        System.out.println(" - ");
    }
}

