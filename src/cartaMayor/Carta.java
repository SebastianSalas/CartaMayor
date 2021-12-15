package cartaMayor;
import java.util.Random;
/**
 * Class Dado generate a random value between 1 and 6
 * @author Alexander Valencia
 * @version 1.0.0
 * */
public class Carta {
    private int num, palo;
    /**
     * Method that generates a random value to cara
     * @return number between (1,12)
     */
    public int getNum(){
        Random aleatorio = new Random();

        //nextInt genera aleatorio comprendido entre 1 y 12
        num = aleatorio.nextInt(12)+1;
        return num;
    }

    public int getPalo(){
        Random paloA= new Random();
        palo = paloA.nextInt(4)+1;
        return palo;
    }
}
