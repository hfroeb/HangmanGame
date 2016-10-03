import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.String.valueOf;

/**
 * Created by halleyfroeb on 9/19/16.
 */
public class Game {
    static ArrayList<String> words = new ArrayList<>();
    static Random randomGenerator = new Random();
    static String randomWord;
    static ArrayList<String> gameBoard = new ArrayList<>();
    static ArrayList<String> randomWordArray = new ArrayList<>();


    public Game() {
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
        words.add("vexed");
    }

    public static ArrayList<String> getRandomWord() {
        int random = randomGenerator.nextInt(words.size());
        randomWord = words.get(random);

        for (int i = 0; i < randomWord.length(); i++) {
            randomWordArray.add(String.valueOf(randomWord.charAt(i)));
            gameBoard.add(" _");
        }
        return gameBoard;
    }
}
