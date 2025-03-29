public abstract class Jugador {

    //atributos
    protected byte ingresoFicha;
    private char fichaJugador;
    private byte conexiones;


    //constructor por defecto
    public Jugador() {
        this.ingresoFicha = 0; //fichaIngreso
        this.fichaJugador = '-';
        this.conexiones = 0;

    }

    //constructor por parametro
    public Jugador(char fichaJugador) {
        this.fichaJugador = fichaJugador;
    }

    //getters
    public byte getIngresoFicha() {
        return ingresoFicha;
    }

    public char getFichaJugador() {
        return fichaJugador;
    }

    public byte getConexiones() {
        return conexiones;
    }

    //setters
    public void setConexiones(byte conexiones) {
        this.conexiones = conexiones;
    }


}
