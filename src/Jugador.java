public abstract class Jugador {

    //atributos
    private char fichaJugador;
    private byte posicionFicha;
    private byte conexiones;


    //constructor por defecto
    public Jugador() {
        this.fichaJugador = fichaJugador;
        this.posicionFicha = 0;
        this.conexiones = 0;
    }

    //asignar ficha
    protected void setFichaJugador(char fichaJugador) {
        this.fichaJugador = fichaJugador;
    }

    //getters
    public byte getPosicionFicha() {
        return posicionFicha;
    }

    public byte getConexiones() {
        return conexiones;
    }

    public char getFichaJugador() {
        return fichaJugador;
    }

    //setters
    public void setPosicionFicha(byte posicionFicha) {
        this.posicionFicha = posicionFicha;
    }
    public void setConexiones(byte conexiones) {
        this.conexiones = conexiones;
    }

    //metodos abastractos
    public abstract void victoria();
}
