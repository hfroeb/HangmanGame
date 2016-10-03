import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by halleyfroeb on 9/19/16.
 */
// test to make sure we get a random word

public class randomWordTest {

    @Test //test to see if you get a random word from word bank
    public void getRandomWord() {
        Random randomGenerator = new Random();
        String randomWord;
        ArrayList<String> words = new ArrayList<>();
        words.add("vexed");
        words.add("bicycle");
        words.add("apple");
        words.add("angle");
        words.add("basis");
        words.add("false");
        words.add("enemy");
        words.add("fight");
        words.add("mayor");
        words.add("royal");
        words.add("sheet");
        words.add("sleep");
        words.add("youth");


        int index = randomGenerator.nextInt(words.size());
        randomWord = words.get(index);
        System.out.println(randomWord);
    }
    }


