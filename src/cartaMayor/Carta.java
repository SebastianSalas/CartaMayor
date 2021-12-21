package cartaMayor;
import java.util.Random;
/**
 * Class Carta generate a random value for num and palo.
 * @author Alexander Valencia
 * @author Sebastian Salas
 * @version 1.0.0
 * */
public class Carta {
    private int num, palo;
    /**
     * Method that generates a random value to num
     * @return number between (1,12)
     */
    public int getNum(){
        Random aleatorio = new Random();
        //nextInt generates random number between 1 and 12
        num = aleatorio.nextInt(12)+1;
        return num;
    }

    /**
     * Method that generates a random value to palo
     * @return number between (1,4)
     */
    public int getPalo(){
        Random paloA= new Random();
        palo = paloA.nextInt(4)+1;
        return palo;
    }
}
