import java.util.ArrayList;
import java.util.Random;

/**
 * Created by halleyfroeb on 9/19/16.
 */
public class Game {

    public static ArrayList<String> wordBank() {
        ArrayList<String> wordBank = new ArrayList<>();
        wordBank.add("bicycle");
        wordBank.add("apple");
        wordBank.add("angle");
        wordBank.add("basis");
        wordBank.add("false");
        wordBank.add("enemy");
        wordBank.add("fight");
        wordBank.add("mayor");
        wordBank.add("royal");
        wordBank.add("sheet");
        wordBank.add("sleep");
        wordBank.add("youth");
        wordBank.add("vexed");
        return wordBank;
    }

    public String selectRandomWord() {
        String randomWord;
        Random randomGenerator = new Random();
        ArrayList<String> wordBank = Game.wordBank();
        int random = randomGenerator.nextInt(wordBank.size());
        randomWord = wordBank.get(random);
        return randomWord.toString();
    }

    public static ArrayList<String> makeGameBoard(String randomWord) {
        ArrayList<String> gameBoard = new ArrayList<>();
        for (int i = 0; i < randomWord.length(); i++) {
            gameBoard.add(" _ ");
        }
        return gameBoard;
    }
    public static ArrayList<String> makeRandomWordArray(String randomWord) {
        ArrayList<String> randomWordArray = new ArrayList<>();
        for (int i = 0; i < randomWord.length(); i++) {
            randomWordArray.add(String.valueOf(randomWord.charAt(i)));
        }
        return randomWordArray;
    }

    public ArrayList<String> updateGameBoard(String input, ArrayList<String>gameBoard, ArrayList<String>randomWordArray) {
        for (int i = 0; i < randomWordArray.size(); i++) {
            String letter = randomWordArray.get(i);
            if (letter.equalsIgnoreCase(input)) {
                gameBoard.set(i, letter);
            }
        }
        return gameBoard;
    }

}