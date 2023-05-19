using dotnet.Controllers;

namespace api.test.Controllers;

public class GamesControllerTests
{
    private readonly GamesController _gamesController;

    public GamesControllerTests() => _gamesController = new GamesController();

    [Fact]
    public void CreateGame_WhenCalled_ReturnsValidIdentifier()
    {
        var id = _gamesController.CreateGame();
        
        Assert.NotEqual(Guid.Empty, id);
    }
}