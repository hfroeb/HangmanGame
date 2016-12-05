import spark.ModelAndView;
import spark.Session;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static int guessNum;
    static ArrayList<String> gameBoard;
    static ArrayList<String> randomWordArray;
    static String randomWord;

    public static void main(String[] args) {
        Game game = new Game();
        ArrayList<String> guesses = new ArrayList<>();
        ArrayList<String> wrongGuesses = new ArrayList<>();

        Spark.init();
        Spark.get("/",
                (request, response) -> {
                    HashMap m = new HashMap();
                    String end = null;
                    String win = null;
                    String error = null;
                    String lost = null;

                    Session session = request.session();
                    String input = session.attribute("letterGuess");

                    if (input == null) {
                        randomWord = game.selectRandomWord();
                        gameBoard = game.makeGameBoard(randomWord);
                        randomWordArray = game.makeRandomWordArray(randomWord);
                        guessNum = 0;
                    }

                    if (guessNum < 10 && guessNum > 0) {
                        if (guesses.contains(input)) {
                            error = "you already guessed this letter!";
                        } else {
                            error = null;
                            guesses.add(input);
                            guessNum = guesses.size();
                            if (randomWordArray.contains(input)) {
                                gameBoard = game.updateGameBoard(input, gameBoard, randomWordArray);
                            } else {
                                wrongGuesses.add(input);
//                                String hangman = game.makeHangman(wrongGuesses);
//                                m.put("hangMan", hangman);
                            }
                        }
                    }
                    String randomArray = randomWordArray.toString();
                    String guessed = guesses.toString();
                    String wrong = wrongGuesses.toString();
                    String board = gameBoard.toString();


                    m.put("wrongGuesses", wrong);
                    m.put("guesses", guessed);
                    m.put("gameBoard", board);
                    m.put("error", error);
                    if (board.equalsIgnoreCase(randomArray)) {
                        win = "not null!";
                        end = "you win";
                        m.put("win", win);
                        m.put("end", end);
                    }
                    if (guessNum > 10) {
                        guessNum = 0;
                        end = "You lose!";
                        lost = "true";
                        m.put("lost", lost);
                        m.put("end", end);
                    }
                    m.put("randomWord", randomWord);
                    return new ModelAndView(m, "home.html");
                }, new

                        MustacheTemplateEngine()
        );
        Spark.post(
                "/guess",
                (request, response) -> {
                    Session session = request.session();
                    String guess = request.queryParams("letterGuess");
                    session.attribute("letterGuess", guess);
                    guessNum = 1;
                    response.redirect("/");
                    return "";
                }
        );
        Spark.post("/new-game",
                ((request, response) -> {
                    Session session = request.session();
                    session.invalidate();
                    gameBoard.clear();
                    randomWordArray.clear();
                    guesses.clear();
                    wrongGuesses.clear();
                    response.redirect("/");
                    return "";
                })
        );
    }
}
