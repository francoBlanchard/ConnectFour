public class LogicaJuego {

    // Dependencias inyectadas
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorActual;
    private Tablero tableroPrincipal;

    // Constantes
    private static final byte FILAS = 6;
    private static final byte COLUMNAS = 7;
    private static final byte CONEXIONES_PARA_GANAR = 4;

    // Atributos
    private byte filaActual;
    private byte columnaActual;
    private byte[] posicionesLibres;
    private char[][] tablero;

    // Constructor
    public LogicaJuego(Jugador jugador1, Jugador jugador2, Jugador jugadorActual, Tablero tableroPrincipal) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugadorActual = jugadorActual;
        this.tableroPrincipal = tableroPrincipal;
        this.posicionesLibres = tableroPrincipal.getPosicionesLibres();
        this.tablero = tableroPrincipal.getTablero();
    }

    // Cambia al siguiente jugador
    private void cambiarTurno() {
        jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;
    }

    // Intenta colocar la ficha en la columna seleccionada
    private void colocarFichaSiEsPosible() {
        byte columna = jugadorActual.getPosicionFicha();
        byte fila = posicionesLibres[columna];

        if (fila >= 0) {
            tablero[fila][columna] = jugadorActual.getFichaJugador();
            this.filaActual = fila;
            this.columnaActual = columna;
        }
    }

    // Procesa el turno actual: cambia jugador y coloca ficha
    public void procesarTurno() {
        cambiarTurno();
        colocarFichaSiEsPosible();
    }

    // Recorre horizontalmente el tablero para buscar conexiones
    public void recorrerHorizontal() {
        validarConexiones(0, 1);   // derecha
        validarConexiones(0, -1);  // izquierda
    }

    // Recorre verticalmente el tablero para buscar conexiones
    public void recorrerVertical() {
        validarConexiones(1, 0);   // abajo
        validarConexiones(-1, 0);  // arriba
    }

    // Recorre en diagonal el tablero para buscar conexiones
    public void recorrerDiagonal() {
        validarConexiones(1, 1);    // inferior derecha
        validarConexiones(1, -1);   // inferior izquierda
        validarConexiones(-1, 1);   // superior derecha
        validarConexiones(-1, -1);  // superior izquierda
    }

    // Valida conexiones en una dirección específica (usado por todas las direcciones)
    private void validarConexiones(int deltaFila, int deltaColumna) {
        byte conexiones = 1; // Incluye la ficha actual
        byte fila = filaActual;
        byte columna = columnaActual;
        char ficha = jugadorActual.getFichaJugador();

        // Movimiento hacia una dirección
        fila += deltaFila;
        columna += deltaColumna;

        while (estaEnRango(fila, columna) && tablero[fila][columna] == ficha && conexiones < CONEXIONES_PARA_GANAR) {
            conexiones++;
            fila += deltaFila;
            columna += deltaColumna;
        }

        jugadorActual.setConexiones(conexiones);
    }

    // Verifica si una celda está dentro del rango del tablero
    private boolean estaEnRango(int fila, int columna) {
        return fila >= 0 && fila < FILAS && columna >= 0 && columna < COLUMNAS;
    }
}
