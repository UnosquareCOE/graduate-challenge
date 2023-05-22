package hangman.mocks;

import hangman.interfaces.IdentifierGeneration;

import java.util.UUID;

public class MockIdentifierGenerator implements IdentifierGeneration {

    private final UUID newId;

    public MockIdentifierGenerator(UUID newId) {
        this.newId = newId;
    }

    @Override
    public UUID retrieveIdentifier() {
        return newId;
    }
}
