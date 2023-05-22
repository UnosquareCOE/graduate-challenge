using api.Controllers;
using api.Utils;
using Microsoft.AspNetCore.Mvc;

namespace api.test.Controllers;

public class MockIdentifierGenerator : IIdentifierGenerator
{
    private readonly Guid _newId;

    public MockIdentifierGenerator(Guid newId) => _newId = newId;

    public Guid RetrieveIdentifier() => _newId;
}

public class GamesControllerTests
{
    [Fact]
    public void CreateGame_WhenCalled_ReturnsValidIdentifier()
    {
        var newId = Guid.NewGuid();
        
        var gamesController = RetrieveController(new MockIdentifierGenerator(newId));
        
        var response = gamesController.CreateGame();
        
        Assert.IsType<OkObjectResult>(response.Result);
        Assert.Equal(newId, ((OkObjectResult)response.Result).Value);
    }
    
    private static GamesController RetrieveController(IIdentifierGenerator identifierGenerator) =>
        new GamesController(identifierGenerator);
}