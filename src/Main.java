import java.util.Scanner;
public class Main {

    //declaro constantes
    static final byte FILAS = 6;
    static final byte COLUMNAS = 7;

    //inicializo vector de posiciones libres en 0
    public static void inicializacionVector(int[] pocisionLibre){
        for (int i = 0; i <= COLUMNAS; i++){
            pocisionLibre[i] = 0;
        }
    }

    //inicializo matriz de tablero
    public static void inicializacionMatriz(char[][] tablero){
        for (int fila = 0; fila <= FILAS; fila++){
            for (int columna = 0; columna <= COLUMNAS; columna++) {
                tablero[fila][columna] = '0';
            }
        }
    }

    //presentacion del juego
    public static void presentacionJuego(){
        System.out.println("Bienvenido");
        System.out.println(" ");
        System.out.println("precione espacio para iniciar el juego");
    }

    //validacion del ingreso ficha del usuario
    public static void ingresoFicha(Jugador jugador1, Jugador jugador2,int[] posicionLibre,char[][] tablero){

        //variables local
        int fichaIngresada = jugador1.getIngresoFicha();
        boolean estadoColumna = posicionLibre[fichaIngresada] >= 0;

        //validacion de estado column
        if (estadoColumna ){
            for (byte fila = FILAS; fila <= FILAS; fila--){
                if (tablero[fila][fichaIngresada] != '0'){
                    tablero[fila][fichaIngresada] = jugador1.getFichaJugador();
                }
            }
        }
    }



    public static void main(String[] args) {
//--------------------------declaraciones ------------------------------------
        //declaro variables
        boolean gameOver = false;

        //declaro arreglo
        int[] posicionLibre= new int[COLUMNAS];

        //declaro matriz
        char[][] tablero = new char[FILAS][COLUMNAS];

        //declaro Scanner
        Scanner lector = new Scanner(System.in);

        //declaro nuevos jugadores
        Jugador jugador1 = new Jugador('x');
        Jugador jugador2 = new Jugador('o');
//------------------------------------------------------------------------------

//--------------------------inicializaciones ------------------------------------
        //inicializo vector
        inicializacionVector(posicionLibre);

        //inicializo matriz
        inicializacionMatriz(tablero);
//------------------------------------------------------------------------------

//--------------------------funcionabilidad del juego---------------------------

        //presentacion de juego
        presentacionJuego();

        //bucle condicional
        do {

            // ingreso de ficha
           ingresoFicha(jugador1, jugador2, posicionLibre, tablero);

            //validacion de la posicionq eu toma la ficha
            //public void posicionFicha ();

            //evaluacion de cumplimiento de juego
            //public void connectFour ();

        } while (gameOver);


    }
}