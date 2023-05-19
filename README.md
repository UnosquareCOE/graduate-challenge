# Hangman Game API Challenge 

This task is to complete a HTTP RESTful API for a Hangman game. The API should allow players to create and retrieve a game, along with modifying the game's state by guessing letters. The development of the API has been started but the logic to make a guess is pending.
 
The API can be developed with C#, Java, Javascript or Python and the codebase should be available through a public Github repository.

## Recommended approach:

The recommended approach for starting this exercise is to:
1. Install git onto your computer. See [here](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git) 
2. (optional) Create a new github account [here](https://github.com/join), you can also use an existing one. 
3. Copy the contents of either dotnet, java, javascript or python into your new repository.
4. Follow the specific README.md instructions for the chosen platform to run the application.
5. Follow instructions [here](#Running-the-application) to create games, check the game details and make a guess with the requests detailed below.
6. Review the guess logic for your chosen platform and update it so that the requirements are fulfilled.
7. (optional) Review the stretch items [here](#Stretch).
 
## Requirements:
- The API should be created using HTTP and RESTful principles.
- The API should allow creation of a game and during creation will select from a pre-defined set of words.
- The game should allow a maximum of 6 incorrect letter guesses.
- The API should track the list of incorrect letter guesses game for a game.
- The game should be completed (or marked as `won`) if all of the letters in the word have been correctly guessed and the remaining attempts is above 0.
- The game should be not completed (or marked as `lost`) if the remaining attempts reaches 0.
- If the game is not in progress then a guess cannot be made.
- The API should support the following HTTP endpoints:
 
`POST /games/`  
Starts a new game of Hangman. This endpoint should initialize a new game with a word and return a game ID.

`GET /games/{game_id}`  
Retrieves the current state of the game identified by the provided `game_id`. The response should include the word with masked letters, the incorrect guesses made so far, the number of remaining attempts, and the game status (e.g. `in progress,` `won` or `lost`).

`POST /games/{game_id}/guesses`  
Allows the player to make a letter guess for the game identified by `game_id`. The guess should be submitted as the request body in JSON format, containing the guessed letter. The response should include the updated game state after the guess.

## Example requests

The below examples are just suggestions, request and responses can be tailored per submission.
 
### Starting a new game
 
NOTE: the response below is just for demonstrative purposes, calling this API will return a different identifier each time.

Request: POST /games  
Response: 201  
```
"8dfff98b-976a-4141-9a96-38fb86522daf"
```

### Retrieving game state

NOTE: the ID in the path we use is from the game we have created, it will be different for each game created.  

Request: GET /games/8dfff98b-976a-4141-9a96-38fb86522daf  
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

NOTE: the ID in the path we use is from the game we have created, it will be different for each game created.  

Request: POST /games/8dfff98b-976a-4141-9a96-38fb86522daf/guesses  
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

## Running the application

Platform specific runtimes and guides can be found within the repository folders; however once the application is running the API usage is the same across the languages.

We recommend using [Postman](https://www.postman.com/) for making the requests above, 

Endpoints can be tested using Postman, available here: https://www.postman.com/

A recommended tutorial can be found here: https://www.guru99.com/postman-tutorial.html

## Notes 
- The exercise allows for variation in the answers or adjustments to the existing codebase, this is to allow flexibility for answers.
- The games are held in memory, as a result when an application is stopped or reloaded the collection of games will be cleared also. 

## Stretch
- The game should handle both uppercase and lowercase letters as valid guesses.
- The API should return appropriate error responses for invalid request body or game IDs.
- The submitted repository should include a brief README.md file in the root directory.
- The code should have unit test coverage.
- Implement an endpoint to remove an existing game using the DELETE HTTP method.
