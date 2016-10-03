import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by halleyfroeb on 9/19/16.
 */
public class WordToArrayListTest {
    @Test
    // Test to see if the random word turns into an arrayList of Strings
    // That contain each letter of the word in order, with opposing index

    public void wordToArray() {
        String randomWord = "bicycle";
        ArrayList<String> randomWordArray = new ArrayList<>();

        for (int i = 0; i < randomWord.length(); i++){
            randomWordArray.add(String.valueOf(randomWord.charAt(i)));
        }

        System.out.println(randomWordArray);

    }
}

