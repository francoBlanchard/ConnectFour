public class Tablero  {


    //constantes
    final byte FILAS = 6;
    final byte COLUMNAS = 7;
    final byte SET_TABLERO = 0;

    //atributos
    private byte[] posicionesLibres;
    private char[][] tablero;

    //constructor por defecto
    public Tablero() {
        super();
        this.posicionesLibres = new byte[FILAS];
        this.tablero = new char[FILAS][COLUMNAS];
    }

    //inicializo cada posicion del array en 6
    private void inicializoArray(){
        for (int fila = 0; fila < FILAS; fila++) {
            this.posicionesLibres[fila] = FILAS;
        }
    }

    //inicializo cada posicion de la matriz en 0
    private void inicializoMatriz(){
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                this.tablero[fila][columna] = SET_TABLERO;
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

   //metodo de ingreso ficha de jugador
    public void ingresoFicha(){

    }





}
