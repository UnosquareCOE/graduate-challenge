const express = require("express");
const cors = require("cors");
const morgan = require("morgan");
const { json, urlencoded } = require("body-parser");
const { v4: uuid } = require("uuid");

const app = express();
app.use(cors());
app.use(json());
app.use(morgan("tiny"));
app.use(urlencoded({ extended: true }));

const words = ["Banana", "Canine", "Unosquare", "Airport"];
const games = {};

const retrieveWord = () => words[Math.floor(Math.random(words.length - 1))];

const clearUnmaskedWord = (game) => {
   
    const gameToReturn = { 
        ...game,
    };
    delete gameToReturn.unmaskedWord;

    return gameToReturn;
}

app.post("/games", (req, res) => {
  const newGameWord = retrieveWord();
  const newGameId = uuid();
  const newGame = {
    remainingGuesses: 3,
    unmaskedWord: newGameWord,
    word: newGameWord.replace(/[^a-zA-Z0-9]/, "_"),
    status: "In Progress",
    incorrectGuesses: []
  };

  games[newGameId] = newGame;

  res.send(newGameId);
});

app.get("/games/:gameId", (req, res) => {
    const { gameId } = req.params;
    if (!gameId) return res.sendStatus(404);

    var game = games[gameId];
    if (!game) {
        return res.sendStatus(404); 
    }

    res.status(200).json(clearUnmaskedWord(game));
});

app.post("/games/:gameId/guesses", (req, res) => {
    const { gameId } = req.params;
    const { letter } = req.body;

    if (!gameId) return res.sendStatus(404);

    var game = games[gameId];
    if (!game) return res.sendStatus(404); 

    if (!letter || letter.length != 1) {
        return res.status(400).json({
            Message: "Guess must be supplied with 1 letter"
        })
    }

    // todo: add logic for making a guess, modifying the game and updating the status

    return res.status(200).json(clearUnmaskedWord(game));
});



app.listen(4567);