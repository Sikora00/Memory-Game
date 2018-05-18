package Exceptions;

public class DeserializationException extends Exception {
    public DeserializationException(Object o) {
        super("Can't serialize object "+ o.toString());
    }
}
