public class LogicaJuego extends Jugador {

    //instancia
    Tablero tableroPrincipal;

    //atributos
    private byte fichaIngreso;
    private char ficha;
    private byte filaActual;
    private byte columnaActual;
    private byte conexiones;
    private byte[] posicionLibreTablero;
    private char[][] tablero;

    //constructor
    public LogicaJuego(Jugador jugador,Tablero tableroPrincipal) {
        super();
        this.tableroPrincipal = tableroPrincipal;
        this.fichaIngreso = this.getIngresoFicha();
        this.ficha = this.getFichaJugador();
        this.filaActual = 0;
        this.columnaActual = 0;
        this.conexiones = jugador.getConexiones();
        this.posicionLibreTablero = tableroPrincipal.getPosicionesLibres();
        this.tablero = tableroPrincipal.getTablero();

    }

    //metodo que valida ficha ingresada
    private void validacionIngresoFicha(){
        //variables
        byte posicionAsignada = this.posicionLibreTablero[this.fichaIngreso];

            if (this.posicionLibreTablero[this.fichaIngreso] >=0){
                tablero[posicionAsignada][this.fichaIngreso] = ficha;
                tableroPrincipal.setTablero(tablero);
            }

        this.filaActual = posicionAsignada;
        this.columnaActual = this.fichaIngreso;
    }

    //recorro horizontalmente la matriz para comparar si se cumplen igualdades
    private void validacionHorizontal(){

        //variables
        byte columna = this.columnaActual;
        boolean condicionRecorridoIzquierda = columna >= 0 && tablero[this.filaActual][columna] == tablero[this.filaActual][columna-1] && (this.conexiones < 4);
        boolean condicionRecorridoDerecha = columna <= 7 && tablero[this.filaActual][columna] == tablero[this.filaActual][columna+1] && (this.conexiones < 4);


            //validacion Derecha
            while(condicionRecorridoDerecha){
                this.conexiones++;
                this.setConexiones(this.conexiones);
                columna++;

                //recalculo validaciones
                condicionRecorridoDerecha = columna <= 7 && tablero[this.filaActual][columna] == tablero[this.filaActual][columna+1] && (this.conexiones < 4);
            }

            //validacion izqierda
            while(condicionRecorridoIzquierda ){
                this.conexiones++;
                this.setConexiones(this.conexiones);
                columna--;

                //recalculo validaciones
                condicionRecorridoIzquierda = columna >= 0 && tablero[this.filaActual][columna] == tablero[this.filaActual][columna-1] && (this.conexiones < 4);
            }
    }

    //recorro Diagonalmente la matriz para comparar si se cumplen igualdades
    private void validacionVertical(){

        //variables
        byte fila = this.filaActual;
        boolean condicionRecorridoArriba = fila >= 0 && tablero[fila][this.columnaActual] == tablero[fila][this.columnaActual] && (this.conexiones < 4);
        boolean condicionRecorridoAbajo = fila <= 6 && tablero[fila][this.columnaActual] == tablero[fila][this.columnaActual] && (this.conexiones < 4);


        //validacion abajo
        while(condicionRecorridoAbajo){
            this.conexiones++;
            this.setConexiones(this.conexiones);
            fila++;

            //recalculo validaciones
            condicionRecorridoAbajo = fila <= 6 && tablero[fila][this.columnaActual] == tablero[fila][this.columnaActual] && (this.conexiones < 4);
        }

        //validacion izqierda
        while(condicionRecorridoArriba ){
            this.conexiones++;
            this.setConexiones(this.conexiones);
            fila--;

            //recalculo validaciones
            condicionRecorridoArriba = fila >= 0 && tablero[fila][this.columnaActual] == tablero[fila][this.columnaActual] && (this.conexiones < 4);
        }
    }

    //recorro Diagonal la matriz para comparar si se cumplen igualdades
    private void validacionDiagonal(){

        //variables
        byte fila = this.filaActual;
        byte columna = this.columnaActual;
        boolean RecorridoInferiorDerecha = (fila <= 6 && columna <=7) && tablero[fila][columna] == tablero[fila][columna] && (this.conexiones < 4);
        boolean RecorridoInferiorIzquierda = (fila <= 6 && columna >=0) && tablero[fila][columna] == tablero[fila][columna] && (this.conexiones < 4);
        boolean RecorridoSuperiorDerecha = (fila >= 0 && columna <=7) && tablero[fila][columna] == tablero[fila][columna] && (this.conexiones < 4);
        boolean RecorridoSuperiorIzquierda = (fila >= 0 && columna >=0) && tablero[fila][columna] == tablero[fila][columna] && (this.conexiones < 4);


        //validacion inferior derecha
        while(RecorridoInferiorDerecha){
            this.conexiones++;
            this.setConexiones(this.conexiones);
            fila++;
            columna++;

            //recalculo validaciones
            RecorridoInferiorDerecha = (fila <= 6 && columna <=7) && tablero[fila][columna] == tablero[fila+1][columna+1] && (this.conexiones < 4);
        }

        //validacion inferior izquierda
        while(RecorridoInferiorIzquierda){
            this.conexiones++;
            this.setConexiones(this.conexiones);
            fila++;
            columna--;

            //recalculo validaciones
            RecorridoInferiorIzquierda = (fila <= 6 && columna >=0) && tablero[fila][columna] == tablero[fila+1][columna-1] && (this.conexiones < 4);
        }

        //validacion superior derecha
        while(RecorridoSuperiorDerecha){
            this.conexiones++;
            this.setConexiones(this.conexiones);
            fila--;
            columna++;

            //recalculo validaciones
            RecorridoSuperiorDerecha = (fila >= 0 && columna <=7) && tablero[fila][columna] == tablero[fila-1][columna+1] && (this.conexiones < 4);
        }

        //validacion superior izquierda
        while(RecorridoSuperiorIzquierda){
            this.conexiones++;
            this.setConexiones(this.conexiones);
            fila--;
            columna--;

            //recalculo validaciones
            RecorridoSuperiorIzquierda = (fila >= 0 && columna >=0) && tablero[fila][columna] == tablero[fila-1][columna-1] && (this.conexiones < 4);
        }
    }


}
