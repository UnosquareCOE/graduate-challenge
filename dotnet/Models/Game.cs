namespace dotnet.Models;

public class Game {
    
    public int RemainingGuesses { get; set; }
    public string Word;
    public string UnmaskedWord { get; set; }
    public List<string> IncorrectGuesses { get; set; }
    public string Status { get; set; }

}