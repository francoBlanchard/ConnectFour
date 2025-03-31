public abstract class Jugador {

    //atributos
    protected byte posicionFicha;
    protected char fichaJugador;
    protected byte conexiones;


    //constructor por defecto
    public Jugador() {
        this.posicionFicha = 0;
        this.fichaJugador = '-';
        this.conexiones = 0;
    }

    //metodos abastractos
    public abstract void ingresoPosicion( byte posicionFicha);
    public abstract void actualizoConexiones(byte conexiones);
    public abstract void victoria();
}
