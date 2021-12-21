package cartaMayor;

/**
 * Model apply rules
 * estado 1= Machine winne
 * estado 2= Players winner
 * estado 3= draw
 *
 * @author Alexander Valencia
 */
public class Model {
    private Carta turnoJ, turnoM, paloJ, paloM;
    private int[] cartas;
    private String estadoToString;
    private int estado, estadoPalo;


    public Model() {
        turnoJ = new Carta();
        turnoM = new Carta();
        paloJ = new Carta();
        paloM = new Carta();
        cartas = new int[4];
        estadoToString = new String();
    }


    public void calcularResultado() {
        cartas[0] = turnoJ.getNum();
        cartas[1] = paloJ.getPalo();
        cartas[2] = turnoM.getNum();
        cartas[3] = paloM.getPalo();

        //Player win
        //Si el turno de la maquina es menor que el del jugador
        if (cartas[2] < cartas[0]) {
            estado = 2;
        } else {
            //Machine win
            //Si el turno del jugador es menor que el de la maquina
            if (cartas[0] < cartas[2]) {
                estado = 1;
                //Draw
            } else {
                if (cartas[0] == cartas[2] || cartas[2] == cartas[0]) {
                    definirPorPalo();
                }

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

        if (cartas[1] < cartas[3]) {
            estado = 3;
        } else {
            if (cartas[1] > cartas[3]) {
                estado = 4;
            } else {
                estado = 5;
            }
        }
    }

    public String getEstadoToString() {
        switch (estado) {
            case 1:
                estadoToString = "Carta del jugador = " + cartas[0] + "\n" +
                        "Carta de la máquina = " + cartas[2] +
                        "\nLa máquina saco una carta de mayor valor, has perdido.";
                break;
            case 2:
                estadoToString = "Carta del jugador = " + cartas[0] + "\n" +
                        "Carta de la máquina = " + cartas[2] +
                        "\n¡¡Sacaste una carta de mayor valor, has ganado!!";
                break;
            case 3:
                estadoToString = "Carta del jugador = " + cartas[0] + "\n" +
                        "Carta de la máquina = " + cartas[2] +
                        "\nPor desempate el jugador ha ganado al obtener un palo mayor al de la máquina. \n" +
                        "¡¡FELICIDADES!!";
                break;
            case 4:
                estadoToString = "Carta del jugador = " + cartas[0] + "\n" +
                        "Carta de la máquina = " + cartas[2] +
                        "\nPor desempate la máquina ha ganado al obtener un palo mayor al del jugador. ";
                break;

            case 5:
                estadoToString = "Carta del jugador = " + cartas[0] + "\n" +
                        "Carta de la máquina = " + cartas[2] +
                        "\nEl juego ha quedado empate, ambos jugadores sacaron las mismas caras con los mismos palos. ";
                break;
        }
        return estadoToString;
    }

    public int[] getCartas() {
        return cartas;
    }
}


