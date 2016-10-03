import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static junit.framework.TestCase.assertTrue;


/**
 * Created by halleyfroeb on 9/19/16.
 */
public class GuessLetterTest {
    // Test to see if correct letter is guessed,
    // it puts correct letter in the space on the gameboard
    ArrayList<String> gameBoard = new ArrayList<>();
    ArrayList<String> randomWordArray = new ArrayList<>();


    @Test
    public void guessLetter() {
        String randomWord = "bicycle";
        for (int i = 0; i < randomWord.length(); i++) {
            randomWordArray.add(String.valueOf(randomWord.charAt(i)));
            gameBoard.add(" _");
        }
        // test to see if c will occupy two spots on the gameboard
        String input = "c";
        for (int i = 0; i < randomWordArray.size(); i++) {
                String letter = randomWordArray.get(i);
                if (letter.equalsIgnoreCase(input)){
                    gameBoard.set(i, letter);
                }
            }

        System.out.println(gameBoard);
        assertTrue(gameBoard.get(2).equalsIgnoreCase(input));
        assertTrue(gameBoard.get(4).equalsIgnoreCase(input));
    }
}


