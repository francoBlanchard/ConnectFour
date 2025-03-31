public class Tablero {

    //constantes
    static final byte FILAS = 6;
    static final byte COLUMNAS = 6;
    static final char SET_MATRIZ = '-';

    //atributos
    private byte[] posicionesLibres;
    private char[][] tablero;

    //constructor
    public Tablero() {
        this.posicionesLibres = new byte[COLUMNAS];
        this.tablero = new char[FILAS][COLUMNAS];
    }

    //inicializo vector
    private void inicializoArray(){
        for(byte i = 0; i <= FILAS; i++){
            this.posicionesLibres[i] = 0;
        }
    }

    //inicializo matriz
    private void inicializoMatriz(){
        for(byte fila = 0; fila <= FILAS; fila++){
            for(byte columna = 0; columna <= COLUMNAS; columna++){
                this.tablero[fila][columna] = SET_MATRIZ;
            }
        }
    }

    //Getters
    public byte[] getPosicionesLibres() {
        return posicionesLibres;
    }

    public char[][] getTablero() {
        return tablero;
    }

    //Setters
    public void setPosicionesLibres(byte[] posicionesLibres) {
        this.posicionesLibres = posicionesLibres;
    }

    public void setTablero(char[][] tablero) {
        this.tablero = tablero;
    }
}
