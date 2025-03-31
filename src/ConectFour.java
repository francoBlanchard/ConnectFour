/*public class ConectFour extends LogicaJuego implements Juego{

    //constructor
    public ConectFour() {
        super();
    }

    @Override
    public void ingresoFicha() {
        this.validacionIngresoFicha();
    }

    @Override
    public void connectFor() {

        //variables
        boolean validacion =this.getConexiones() == 4;

        switch ('H'){

            case 'H':
                this.validacionHorizontal();
                    if(validacion)  break;
            case 'D':
                this.validacionDiagonal();
                    if(validacion) break;
            case 'V':
                this.validacionVertical();
                    if(validacion) break;

        }

    }

    @Override
    public void gameOver() {
        //variables
        boolean validacion =this.getConexiones() == 4;

        if(validacion){

        }
    }
}
*/