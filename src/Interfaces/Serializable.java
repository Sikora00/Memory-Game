package Interfaces;

import Services.Serializer;

import java.io.IOException;

public interface Serializable<T> extends java.io.Serializable {
    public default String serialize() throws IOException {
        return Serializer.serialize(this);
    }

    public static Object deserialize(String serializedObject) throws IOException, ClassNotFoundException {
        return Serializer.deserialize(serializedObject);
    }
}
