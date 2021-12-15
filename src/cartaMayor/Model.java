package cartaMayor;
/**
 * Model apply rules
 * estado 1= Machine winne
 * estado 2= Players winner
 * estado 3= draw
 * @author Alexander Valencia
 */
public class Model {
    private Carta turnoJ,turnoM,paloJ, paloM;
    private int[] cartas,palo;
    private int estado, estadoPalo;



    public Model(){
        turnoJ = new Carta();
        turnoM = new Carta();
        paloJ = new Carta();
        paloM = new Carta();
        cartas = new int[2];
        palo = new int[2];
    }


    public void calcularResultado(){
        cartas[0]=turnoJ.getNum();
        cartas[1]=turnoM.getNum();

        if (cartas[0] < cartas[1]){
            estado=1;
        }else{
            if(cartas[0] > cartas[1]){
                estado= 2;
            }else{
                definirPorPalo();
            }
        }
    }

    private void definirPorPalo() {
        palo[0]=paloJ.getPalo();
        palo[1]=paloM.getPalo();

        /**
         * (oros, copas, espadas y bastos)
         * Oro = 1
         * Copa = 2
         * Espada = 3
         * Basto = 4
         */

        if (palo[0] < palo[1] ){
            estado = 3;
        }else{
            estado = 4;
        }

    }
}


