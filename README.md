# Hangman Game API Challenge 

This task is to complete a HTTP RESTful API for a Hangman game. The API should allow players to create and retrieve a game, along with modifying the game's state by guessing letters. The development of the API has been started but the logic to make a guess is pending.
 
The API can be developed with C# (using .NET 6), Java (version 17), Javascript (version 18) or Python (3.11.x) and the codebase should be available through a public Github repository.

## Recommended approach:

The recommended approach for starting this exercise is to:
1. Install git onto your computer. See [here](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git) 
2. (optional) Create a new github account [here](https://github.com/join), you can also use an existing one. 
3. Copy the contents of either csharp, java, javascript or python into your new repository.
4. Follow the specific README.md instructions for the chosen platform to run the application.
5. Follow instructions [here](#Running-the-application) to create games, check the game details and make a guess with the requests detailed below.
6. Review the guess logic for your chosen platform and update it so that the requirements are fulfilled.
7. (optional) Review the stretch items [here](#Stretch).
 
## Requirements:
- The API should be created using HTTP and RESTful principles.
- The API should allow creation of a game and during creation will select from a pre-defined set of words.
- The game should allow a maximum of 6 incorrect letter guesses.
- The API should track the list of incorrect letter guesses game for a game.
- The game word returned in the API should unmask characters as correct guesses have been made.
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
 
### Starting/Creating a new game
 
NOTE: the response below is just for demonstrative purposes, calling this API will return a different identifier each time.

Request: POST /games  
Response: 201  
```
"8dfff98b-976a-4141-9a96-38fb86522daf"
```

### Retrieving current game state

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

### Make a guess for a game

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

Platform specific runtimes and README guides can be found within the repository platform folders; however once the application is running the API usage is the same across the languages. All of the hangman APIs run on port 4567 and can be accessed from http://localhost:4567

We recommend using [Postman](https://www.postman.com/downloads/?utm_source=postman-home) for making the requests above. Once postman is installed, you can skip the account creation and you will be presented with a user interface similar to this:

![postman_home.png](/images/postman_home.png)

At this point if you select `New` from the top ribbon and then select `HTTP Request`:

![postman_new_http.png](/images/postman_new_http.png)

You should be presented with an empty HTTP request to be filled out. At this point using the example requests and requirements above you can call the APIs (provided the application is running). An example of how a successful request would look us:

![postman_example_request.png](/images/postman_example_request.png)

NOTE: If interested additional tutorials for postman can be found here: https://www.guru99.com/postman-tutorial.html

## Development tools

For most of the API choices [Visual Studio Code](https://code.visualstudio.com/) is a good choice for minor adjustments, especially if you're running the application via the terminal/command line.

For language specific tooling the following options exist to facilitate better debugging and more coupled options:

### Python
[PyCharm Community](https://www.jetbrains.com/pycharm/) is often the go to IDE. 

### C# .NET
For Windows we typically use [Visual Studio](https://visualstudio.microsoft.com/), a macOS & Linux version does exist (originally Xamarin studio, then adjusted). However we typically recommend using [Rider](https://www.jetbrains.com/rider/) (NOTE: Rider does not have a community edition, it does however have a 30 day free trial).

### Javascript
Visual Studio Code is often the go-to tooling for Javascript, especially when paired with prettier and ESLint plugins. 

### Java
Most Java developers begin development using Eclipse; however we recommend using [IntelliJ Community](https://www.jetbrains.com/idea/). The support is often better and it's generally a better experience for most tasks.

## Notes 
- The exercise allows for variation in the answers or adjustments to the existing codebase, this is to allow flexibility for answers.
- The created games are held in memory, as a result when an application is stopped or reloaded the existing games will be cleared also. Subsequently games would need to be re-created with the POST /games/ API endpoint.

## Stretch
- The game should handle both uppercase and lowercase letters as valid guesses.
- The API should return appropriate error responses for invalid request body or game IDs.
- The submitted repository should include a brief README.md file in the root directory.
- The code should have unit test coverage.
- Implement an endpoint to remove an existing game using the DELETE HTTP method `DELETE /games/{game_id}`. An example is:  

Request: DELETE /games/8dfff98b-976a-4141-9a96-38fb86522daf  
Response: 204  
