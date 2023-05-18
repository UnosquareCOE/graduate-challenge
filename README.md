# Hangman Game API Challenge 

This task is to complete a HTTP RESTful API for a Hangman game. The API should allow players to create and retrieve a game, along with modifying the game's state by guessing letters.  
 
The API can be developed with C#, Java, Javascript or Python and the codebase should be available through a public Github repository.
 
## Requirements:
- The API should be created using HTTP and RESTful principles.
- The API should allow creation of a game and during creation will select from a pre-defined set of words.
- The game should allow a maximum of 6 incorrect letter guesses.
- The API should track the list of incorrect letter guesses game for a game.
- The game should be completed (or marked as `won`) if all of the letters in the word have been correctly guessed and the remaining attempts is above 0.
- The game should be not completed (or marked as `lost`) if the remaining attempts reaches 0.
- If the game is not in progress then a guess cannot be made.
- The API should support the following endpoints:
 
`POST /games/`  
Starts a new game of Hangman. This endpoint should initialize a new game with a word and return a game ID.

`GET /games/{game_id}`  
Retrieves the current state of the game identified by the provided `game_id`. The response should include the word with masked letters, the incorrect guesses made so far, the number of remaining attempts, and the game status (e.g. `in progress,` `won` or `lost`).

`POST /games/{game_id}/guesses`  
Allows the player to make a letter guess for the game identified by `game_id`. The guess should be submitted as the request body in JSON format, containing the guessed letter. The response should include the updated game state after the guess.

## Example requests

The below examples are just suggestions, request and responses can be tailored per submission.
 
### Starting a new game
 
Request: POST /games  
Response: 201  
```
"1234567890"
```

### Retrieving game state
 
Request: GET /games/1234567890  
Response: 200  
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
Response: 201   
```
{
  "word": "_ A _ _ _",
  "incorrect_guesses": [],
  "remaining_attempts": 6,
  "status": "in progress"
}
```

## Testing endpoints
Endpoints can be tested using Postman, available here: https://www.postman.com/

A recommended tutorial can be found here: https://www.guru99.com/postman-tutorial.html


## Notes 
- The implementation can store the game state in memory or use a persistence mechanism like a database or file.
- The exercise allows for variation in the answers, giving flexibility in the code.

## Stretch/Optional
- The game should handle both uppercase and lowercase letters as valid guesses.
- The API should return appropriate error responses for invalid request body or game IDs.
- The submitted repository should include a brief README.md file in the root directory.
- The code should have unit test coverage.
- Implement an endpoint to delete an existing game using the DELETE HTTP method.
