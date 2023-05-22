package hangman;

import com.google.gson.Gson;
import hangman.controllers.GameController;
import hangman.models.ResponseError;
import hangman.transformers.JsonTransformer;
import hangman.utils.IdentifierGenerator;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        var identifierGenerator = new IdentifierGenerator();
        var gameController = new GameController(identifierGenerator);

        after((request, response) -> response.type("application/json"));

        // Endpoint: POST /games/
        post("/games/", (request, response) -> gameController.createGame());

        // Endpoint: GET /games/{game_id}
        get("/games/:game_id", (request, response) -> gameController.getGame(request, response), new JsonTransformer());

        // Endpoint: POST /games/{game_id}/guesses
        post("/games/:game_id/guesses", "application/json", (request, response) -> gameController.makeGuess(request, response), new JsonTransformer());

        // handle illegal arguments.
        exception(IllegalArgumentException.class, (e, req, res) -> {
            res.status(400);
            res.body(new Gson().toJson(new ResponseError(e)));
            res.type("application/json");
        });
    }
}