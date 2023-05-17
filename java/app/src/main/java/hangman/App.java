package hangman;

import com.google.gson.Gson;
import hangman.models.Game;
import hangman.models.Guess;
import hangman.models.ResponseError;
import hangman.transformers.JsonTransformer;
import spark.Request;
import spark.Response;

import java.util.*;

import static spark.Spark.*;

public class App {
    private static HashMap<UUID, Game> games = new HashMap();
    private static List<String> words = Arrays.asList("Banana", "Canine", "Unosquare", "Airport");

    public static void main(String[] args) {

        after((request, response) -> response.type("application/json"));

        // Endpoint: POST /games/
        post("/games/", (request, response) -> createGame());

        // Endpoint: GET /games/{game_id}
        get("/games/:game_id", (request, response) -> getGame(request, response), new JsonTransformer());

        // Endpoint: POST /games/{game_id}/guesses
        post("/games/:game_id/guesses", "application/json", (request, response) -> makeGuess(request, response), new JsonTransformer());

        // handle illegal arguments.
        exception(IllegalArgumentException.class, (e, req, res) -> {
            res.status(400);
            res.body(new Gson().toJson(new ResponseError(e)));
            res.type("application/json");
        });
    }

    public static UUID createGame() {
        var newGameId = UUID.randomUUID();
        var newGame = new Game(6, retrieveWord());

        games.put(newGameId, newGame);

        return newGameId;
    }

    public static Game getGame(Request request, Response response) {
        var gameArgument = request.params("game_id");
        var gameId = UUID.fromString(gameArgument);
        if (gameId == null || !games.containsKey(gameId)) {
            response.status(404);
            return null;
        }

        return games.get(gameId);
    }

    public static Game makeGuess(Request request, Response response) {
        var game = getGame(request, response);
        if (game != null) {
            var guess = new Gson().fromJson(request.body(), Guess.class);

            if (guess == null || guess.getLetter() == null || guess.getLetter().length() != 1) {
                throw new IllegalArgumentException("Guess must be supplied with 1 letter");
            }

            // todo: add logic for making a guess, modifying the game and updating the status

            return game;
        }
        return null;
    }

    private static String retrieveWord() {
        Random rand = new Random();
        return words.get(rand.nextInt(words.size() - 1));
    }
}