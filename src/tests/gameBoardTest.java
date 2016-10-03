import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by halleyfroeb on 10/3/16.
 */
public class gameBoardTest {
    ArrayList<String> gameBoard = new ArrayList<>();
    ArrayList<String> randomWordArray = new ArrayList<>();

    @Test // create arraylist and gameboard for word
    public void wordToArray() {
        String randomWord = "bicycle";
        for (int i = 0; i < randomWord.length(); i++) {
            randomWordArray.add(String.valueOf(randomWord.charAt(i)));
            gameBoard.add(" _");
        }
        System.out.println(randomWordArray);
        assertTrue(randomWordArray.size() == 7);
        System.out.println(gameBoard);
        assertTrue(gameBoard.size() == 7);
    }
}
