package Exceptions;

public class SerializationException extends Exception {
    public SerializationException(String o) {
        super("Can't serialize object "+ o);
    }
}
