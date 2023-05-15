# Hangman Game API Challenge 

You are tasked with developing a HTTP RESTful API for a Hangman game. The API should allow players to interact with a game by guessing letters and retrieving game information. The API endpoints should handle the game logic and provide responses accordingly.
 
The game can be developed with C#, Java, Javascript or Python and the codebase should be available through a public Github repository.
 
## Requirements:
- The API should be implemented using RESTful principles.
- The game should implement the standard rules of Hangman, including the number of attempts allowed and updating the game state based on correct or incorrect guesses.
- The game should track the list of incorrect guesses made by the player.
- The API should support the following endpoints:
 
`POST /games/`  
Starts a new game of Hangman. This endpoint should initialize a new game with a word and return a game ID.

`GET /games/{game_id}`  
Retrieves the current state of the game identified by the provided game_id. The response should include the word with masked letters, the incorrect guesses made so far, the number of remaining attempts, and the game status (e.g. `in progress,` `won` or `lost`).

`POST /games/{game_id}/guesses`  
Allows the player to make a letter guess for the game identified by game_id. The guess should be submitted as the request body in JSON format, containing the guessed letter. The response should include the updated game state after the guess.

## Example requests
 
### Starting a new game
 
Request: POST /games  
Response: 
```
{ "game_id": "1234567890" }
```

### Retrieving game state
 
Request: GET /games/1234567890  
Response:  
```
{
  "word": "_ _ _ _ _",
  "incorrect_guesses": [],
  "remaining_attempts": 6,
  "status": "in progress"
}
```

### Make a guess
Request: POST /games/1234567890/guesses  
Request body:  
```
{ "letter": "A" }  
```
Response:  
```
{
  "word": "_ A _ _ _",
  "incorrect_guesses": [],
  "remaining_attempts": 6,
  "status": "in progress"
}
```

## Notes 
- You can choose to store the game state in memory or use a mechanism for persistance like a database or file.
- This exercise is designed to permit a variation of answers, you can tailor your code 

## Stretch

- The game should handle both uppercase and lowercase letters as valid guesses.
- The API should return appropriate error responses for invalid game IDs, repeated guesses, or any other invalid requests. 
- The submitted repository should include some brief details within a README.md
- There is some unit test coverage.
- There is an API to delete an existing game using the DELETE HTTP Method.
