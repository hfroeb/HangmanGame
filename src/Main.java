import spark.ModelAndView;
import spark.Session;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        ArrayList<String> gameBoard = Game.getRandomWord();
        ArrayList<String> guesses = new ArrayList<>();
        ArrayList<String> wrongGuesses = new ArrayList<>();

        Spark.init();
        Spark.get("/",
                ((request, response) -> {

                    HashMap m = new HashMap();
                    Session session = request.session();
                    String input = session.attribute("letterGuess");

                    int guessNum = 0;
                    if (guessNum < 10) {
                        guesses.add(input);
                        guessNum = guessNum + guesses.indexOf(input);
                        if (game.randomWordArray.contains(input)) {
                            for (int i = 0; i < game.randomWordArray.size(); i++) {
                                String letter = game.randomWordArray.get(i);
                                if (letter.equalsIgnoreCase(input))
                                game.gameBoard.set(i, letter);
                            }
                        } else {
                            wrongGuesses.add(input);
                        }
                        String wrong = wrongGuesses.toString();
                        String board = gameBoard.toString();
                        String guessed = guesses.toString();
                        m.put("wrongGuesses", wrong);
                        m.put("gameBoard", board);
                        m.put("guesses", guessed);
                    }
                    return new ModelAndView(m, "home.html");
                }), new MustacheTemplateEngine()

        );
        Spark.post(
                "/guess",
                (request, response) -> {
                    Session session = request.session();
                    String guess = request.queryParams("letterGuess");
                    session.attribute("letterGuess", guess);
                    response.redirect("/");
                    return "";
                }
        );
    }
}
