public class Jugador {

    //constantes
    final int TOTAL_FICHAS = 21;

    //atributos
    private byte ingresoFicha;
    private byte totalAcierto;
    private char fichaJugador;

    //constructor por defecto
    public Jugador() {
        this.ingresoFicha = 0;
        this.totalAcierto = 0;
        this.fichaJugador = '-';
    }

    public Jugador(char fichaJugador) {
        this.fichaJugador = fichaJugador;
    }

    //getters
    public byte getIngresoFicha() {
        return ingresoFicha;
    }

    public byte getTotalAcierto() {
        return totalAcierto;
    }

    public char getFichaJugador() {
        return fichaJugador;
    }

    //setters
    public void setIngresoFicha(byte ingresoFicha) {
        this.ingresoFicha = ingresoFicha;
    }

    public void setTotalAcierto(byte totalAcierto) {
        this.totalAcierto = totalAcierto;
    }
}
