public abstract class LogicaJuego {

    //inyecciones
    Jugador jugador1;
    Jugador jugador2;
    Jugador jugadorActual;
    Tablero tableroPrincipal;

    //constantes
    final byte FILAS = 6;
    final byte COLUMNAS = 7;
    final byte SET_TABLERO = 0;

    //atributos
    private byte filaActual;
    private byte columnaActual;
    private byte[] posicionLibre;
    private char[][] tablero;

    //constructor
    public LogicaJuego(Jugador jugador1, Jugador jugador2, Jugador jugadorActual, Tablero tableroPrincipal) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugadorActual = jugadorActual;
        this.posicionLibre = tableroPrincipal.getPosicionesLibres();
        this.tablero = tableroPrincipal.getTablero();
        this.filaActual = 0;
        this.columnaActual = 0;
    }

    //turno actual
    private void turnoJugador(){
        if (jugadorActual == jugador1){
            jugadorActual = jugador2;
        } else jugadorActual = jugador1;
    }
    //------------------------------------------------------------------------------------------------------
    private void validaciongresoFicha(){
        this.filaActual = this.posicionLibre[jugadorActual.getPosicionFicha()];

        if (this.filaActual >=0){
            this.columnaActual = jugadorActual.getPosicionFicha();
            tablero[this.filaActual][this.columnaActual] = jugadorActual.getFichaJugador();
        }
    }

    //-------------------VALIDACION DE FICHA INGRESADA-------------------------------------------------------
    //metodo que valida ficha ingresada
    public void posicionFichaInrgesada(){
        turnoJugador();
        validaciongresoFicha();
    }
    //-------------------------------------------------------------------------------------------------------

    //-------------------RECORRIDO Matriz -------------------------------------------------------
    private void validacionHorizontal(){
        //variables
        byte columna = this.columnaActual;
        byte conexiones = 0;
        boolean condicionRecorridoIzquierda = columna >= 0 && tablero[this.filaActual][columna] == tablero[this.filaActual][columna-1] && (conexiones < 4);
        boolean condicionRecorridoDerecha = columna <= 7 && tablero[this.filaActual][columna] == tablero[this.filaActual][columna+1] && (conexiones < 4);


        //validacion Derecha
        while(condicionRecorridoDerecha){
            conexiones++;
            jugadorActual.setConexiones(conexiones);
            columna++;

            //recalculo validaciones
            condicionRecorridoDerecha = columna <= 7 && tablero[this.filaActual][columna] == tablero[this.filaActual][columna+1] && (conexiones < 4);
        }

        columna = this.columnaActual;
        //validacion izqierda
        while(condicionRecorridoIzquierda ){
            conexiones++;
            jugadorActual.setConexiones(conexiones);
            columna--;

            //recalculo validaciones
            condicionRecorridoIzquierda = columna >= 0 && tablero[this.filaActual][columna] == tablero[this.filaActual][columna-1] && (conexiones < 4);
        }
    }

    private void validacionVertical(){

        //variables
        byte fila = this.filaActual;
        byte conexiones = 0;
        boolean condicionRecorridoArriba = fila >= FILAS && tablero[fila][this.columnaActual] == tablero[fila][this.columnaActual] && (conexiones < 4);
        boolean condicionRecorridoAbajo = fila <= FILAS && tablero[fila][this.columnaActual] == tablero[fila][this.columnaActual] && (conexiones < 4);


        //validacion abajo
        while(condicionRecorridoAbajo){
            conexiones++;
            jugadorActual.setConexiones(conexiones);
            fila++;

            //recalculo validaciones
            condicionRecorridoAbajo = fila <= 6 && tablero[fila][this.columnaActual] == tablero[fila][this.columnaActual] && (conexiones < 4);
        }

        fila = this.filaActual;
        //validacion izqierda
        while(condicionRecorridoArriba ){
            conexiones++;
            jugadorActual.setConexiones(conexiones);
            fila--;

            //recalculo validaciones
            condicionRecorridoArriba = fila >= 0 && tablero[fila][this.columnaActual] == tablero[fila][this.columnaActual] && (conexiones < 4);
        }
    }


    //-------------------------------------------------------------------------------------------------------
    //recorro horizontalmente la matriz para comparar si se cumplen igualdades
    public void recorridoHorizontal(Jugador jugador) {
        validacionHorizontal();
    }

    //recorro Diagonalmente la matriz para comparar si se cumplen igualdades
    public void recorridoVertical(){
        validacionVertical();
    }

    //recorro Diagonal la matriz para comparar si se cumplen igualdades
    protected void validacionDiagonal(){

        //variables
        byte fila = this.filaActual;
        byte columna = this.columnaActual;
        byte conexiones = 0;
        //revisar
        boolean RecorridoInferiorDerecha = (fila <= 6 && columna <=7) && tablero[fila][columna] == tablero[fila][columna] && (conexiones < 4);
        boolean RecorridoInferiorIzquierda = (fila <= 6 && columna >=0) && tablero[fila][columna] == tablero[fila][columna] && (conexiones < 4);
        boolean RecorridoSuperiorDerecha = (fila >= 0 && columna <=7) && tablero[fila][columna] == tablero[fila][columna] && (conexiones < 4);
        boolean RecorridoSuperiorIzquierda = (fila >= 0 && columna >=0) && tablero[fila][columna] == tablero[fila][columna] && (conexiones < 4);


        //validacion inferior derecha
        while(RecorridoInferiorDerecha){
            conexiones++;
            jugadorActual.setConexiones(conexiones);
            fila++;
            columna++;

            //recalculo validaciones
            RecorridoInferiorDerecha = (fila <= 6 && columna <=7) && tablero[fila][columna] == tablero[fila+1][columna+1] && (conexiones < 4);
        }

        fila = this.filaActual;
        columna = this.columnaActual;
        //validacion inferior izquierda
        while(RecorridoInferiorIzquierda){
            conexiones++;
            jugadorActual.setConexiones(conexiones);
            fila++;
            columna--;

            //recalculo validaciones
            RecorridoInferiorIzquierda = (fila <= 6 && columna >=0) && tablero[fila][columna] == tablero[fila+1][columna-1] && (conexiones < 4);
        }

        fila = this.filaActual;
        columna = this.columnaActual;
        //validacion superior derecha
        while(RecorridoSuperiorDerecha){
            conexiones++;
            jugadorActual.setConexiones(conexiones);
            fila--;
            columna++;

            //recalculo validaciones
            RecorridoSuperiorDerecha = (fila >= 0 && columna <=7) && tablero[fila][columna] == tablero[fila-1][columna+1] && (conexiones < 4);
        }

        fila = this.filaActual;
        columna = this.columnaActual;
        //validacion superior izquierda
        while(RecorridoSuperiorIzquierda){
            conexiones++;
            jugadorActual.setConexiones(conexiones);
            fila--;
            columna--;

            //recalculo validaciones
            RecorridoSuperiorIzquierda = (fila >= 0 && columna >=0) && tablero[fila][columna] == tablero[fila-1][columna-1] && (conexiones < 4);
        }
    }

}
