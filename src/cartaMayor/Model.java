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
    private int[] cartas;
    private String estadoToString;
    private int estado, estadoPalo;



    public Model(){
        turnoJ = new Carta();
        turnoM = new Carta();
        paloJ = new Carta();
        paloM = new Carta();
        cartas = new int[4];

        estadoToString = new String();
    }


    public void calcularResultado(){
        cartas[0]=turnoJ.getNum();
        cartas[1]=paloJ.getPalo();
        cartas[2]=turnoM.getNum();
        cartas[3]=paloM.getPalo();

        //Machine win
        if (cartas[0] < cartas[1]){
            estado=1;
        }else{
            //Player win
            if(cartas[0] > cartas[1]){
                estado= 2;
                //Draw
            }else{
                definirPorPalo();
            }
        }
    }

    private void definirPorPalo() {


        /**
         * (oros, copas, espadas y bastos)
         * Oro = 1
         * Copa = 2
         * Espada = 3
         * Basto = 4
         */

        if (cartas[1] < cartas[3] ){
            estado = 3;
        }else{
            estado = 4;
        }

    }

    public String getEstadoToString() {
        switch (estado){
            case 1:
                estadoToString = "Carta del jugador = "+cartas[0]+"\n" +
                        "Carta de la máquina = "+cartas[2]+
                        "\nLa máquina saco una carta de mayor valor, has perdido.";
                break;
            case 2:
                estadoToString = "Carta del jugador = "+cartas[0]+"\n" +
                        "Carta de la máquina = "+cartas[2]+
                        "\n¡¡Sacaste una carta de mayor valor, has ganado!!";
                break;
            case 3:
                estadoToString = "Carta del jugador = "+cartas[0]+"\n" +
                        "Carta de la máquina = "+cartas[2]+
                        "Por desempate el jugador ha ganado al obtener un palo mayor al de la máquina. \n" +
                        "¡¡FELICIDADES!!";
                break;
            case 4:
                estadoToString = "Carta del jugador = "+cartas[0]+"\n" +
                        "Carta de la máquina = "+cartas[2]+
                        "Por desempate la máquina ha ganado al obtener un palo mayor al del jugador. ";
                break;
        }
        return estadoToString;
    }
}


