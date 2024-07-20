package model.board;
import java.util.Random;

/**
 * Esta clase representa un dado en el juego.
 * Un dado tiene un número de caras y una cantidad de dados.
 * Se utiliza para generar números aleatorios durante el juego.
 *
 * @author [GRUPO NUMERO 1: ESTANCIERO]
 * @version 2.0
 */

public class Dice {

    /** El número de caras del dado. */
    private int side;

    /** El resultado del primer dado. */
    private int diceOne;

    /** El resultado del segundo dado. */
    private int diceTwo;

    /** Generador de números aleatorios para simular los lanzamientos de dados. */
    private Random random;

    /**
     * Constructor que inicializa los resultados de los dados con valores dados.
     *
     * @param diceOne Valor inicial para el primer dado.
     * @param diceTwo Valor inicial para el segundo dado.
     */
    public Dice(int diceOne, int diceTwo) {
        this.diceOne = diceOne;
        this.diceTwo = diceTwo;
    }

    /**
     * Constructor por defecto que inicializa los dados con valores aleatorios entre 1 y 6.
     */
    public Dice(){
        random= new Random();
        rollDice();
    }

    /**
     * Simula el lanzamiento de los dados y actualiza sus valores con resultados aleatorios.
     */
    public void rollDice(){
        diceOne= random.nextInt(6)+1;
        diceTwo= random.nextInt(6)+1;
    }




    /**
     * Comprueba si los valores de ambos dados son iguales.
     *
     * @return true si los valores de ambos dados son iguales, false sino.
     */

    public boolean getDiceEquals() {
        return diceOne == diceTwo;
    }

    /**
     * Obtiene el resultado del lanzamiento del primer dado.
     *
     * @return El valor del primer dado diceOne.
     */

    public int getDiceOne() {
        return diceOne;
    }

    /**
     * Obtiene el resultado de lanzar el dadoTwo, segundo dado.
     * Este método devuelve un número aleatorio que representa el resultado del lanzamiento del dado dos.
     *
     * @return El resultado del lanzamiento del dado número dos.
     */
    public int getDiceTwo() {
        return diceTwo;
    }

    /**
     * Calcula y devuelve la suma de los valores de ambos dados.
     *
     * @return La suma de los valores de ambos dados.
     */
    public Integer getTotalDices(){return getDiceOne()+getDiceTwo();}

}