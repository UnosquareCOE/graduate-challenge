namespace api.Utils;

public interface IIdentifierGenerator
{
    Guid RetrieveIdentifier();
}

public class IdentifierGenerator : IIdentifierGenerator
{
    public Guid RetrieveIdentifier()
    {
        return Guid.NewGuid();
    }
}