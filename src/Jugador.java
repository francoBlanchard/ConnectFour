public class Jugador {

    //constantes
    final int TOTAL_FICHAS = 21;

    //atributos
    private byte ingresoFicha;
    private byte totalAcierto;

    //constructor por defecto
    public Jugador() {
        this.ingresoFicha = 0;
        this.totalAcierto = 0;
    }

    //getters
    public byte getIngresoFicha() {
        return ingresoFicha;
    }

    public byte getTotalAcierto() {
        return totalAcierto;
    }

    //setters
    public void setIngresoFicha(byte ingresoFicha) {
        this.ingresoFicha = ingresoFicha;
    }

    public void setTotalAcierto(byte totalAcierto) {
        this.totalAcierto = totalAcierto;
    }
}
