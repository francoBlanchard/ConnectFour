public class Jugador1 extends Jugador{


    //constructor
    public Jugador1() {
        this.fichaJugador= 'X';
        this.posicionFicha = 0;
        this.conexiones = 0;
    }

    //asigno posicion de ingreso
    @Override
    public void ingresoPosicion( byte posicionFicha) {
         this.posicionFicha =  posicionFicha;
    }

    //actualizo conexiones realizadas
    @Override
    public void actualizoConexiones( byte conexiones) {
        this.conexiones =  conexiones;
    }

    //mensaje
    @Override
    public void victoria() {
        System.out.println(" - ");
    }
}
