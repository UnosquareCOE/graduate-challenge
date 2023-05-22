package hangman.utils;

import hangman.interfaces.IdentifierGeneration;

import java.util.UUID;

public class IdentifierGenerator implements IdentifierGeneration {
    @Override
    public UUID retrieveIdentifier() {
        return UUID.randomUUID();
    }
}
