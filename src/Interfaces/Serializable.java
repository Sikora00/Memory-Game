package Interfaces;

import Exceptions.DeserializationException;
import Exceptions.SerializationException;
import Services.ExceptionHandler;
import Services.Serializer;

import java.io.IOException;

public interface Serializable<T> extends java.io.Serializable {
    public default String serialize() {
        try {
            return Serializer.serialize(this);
        } catch (IOException e) {
            ExceptionHandler.handle(new DeserializationException(this));
        }
        return null;
    }

    public static Object deserialize(String serializedObject) {
        try {
            return Serializer.deserialize(serializedObject);
        } catch (Throwable e) {
            ExceptionHandler.handle(new SerializationException(serializedObject));
            return null;
        }
    }
}
