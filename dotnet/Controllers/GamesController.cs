using System.Text.RegularExpressions;
using dotnet.Models;
using Microsoft.AspNetCore.Mvc;

namespace dotnet.Controllers;

[ApiController]
[Route("[controller]")]
public class GamesController : ControllerBase
{
    private readonly string[] _words = {"Banana", "Canine", "Unosquare", "Airport"};

    private static readonly IDictionary<Guid, Game> Games = new Dictionary<Guid, Game>();

    [HttpPost]
    public Guid CreateGame()
    {
        var newGameWord = RetrieveWord();
        var newGameId = Guid.NewGuid();
        var newGame = new Game
        {
            RemainingGuesses = 3,
            UnmaskedWord = newGameWord,
            Word = Regex.Replace(newGameWord, @"[a-zA-Z0-9_]", "_"),
            Status = "In Progress",
            IncorrectGuesses = new List<string>()
        };
        Games.Add(newGameId, newGame);

        return newGameId;
    }
    
    [HttpGet("{gameId:guid}")]
    public ActionResult<Game> GetGame([FromRoute] Guid gameId)
    {
        var game = RetrieveGame(gameId);
        if (game == null) return NotFound();
        
        return Ok(game);
    }
    
    [HttpPost("{gameId:guid}/guesses")]
    public ActionResult<Game> MakeGuess([FromRoute] Guid gameId, [FromBody] Guess guess)
    {
        var game =  RetrieveGame(gameId);
        if (game == null) return NotFound();

        if (string.IsNullOrWhiteSpace(guess.Letter) || guess.Letter.Length != 1)
        {
            return BadRequest(new ResponseError
            {
                Message = "Guess must be supplied with 1 letter"
            });
        }
        
        // todo: add logic for making a guess, modifying the game and updating the status
        
        return Ok(game);
    }

    private static Game? RetrieveGame(Guid gameId)
    {
        return Games.TryGetValue(gameId, out var game) ? game : null;
    }
    
    private string RetrieveWord() {
        var rand = new Random();
        return _words[rand.Next(_words.Length - 1)];
    }
}
