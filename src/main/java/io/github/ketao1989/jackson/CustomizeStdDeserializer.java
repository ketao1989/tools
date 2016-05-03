package io.github.ketao1989.jackson;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.std.StdDeserializer;
import org.codehaus.jackson.type.JavaType;

import java.io.IOException;

/**
 * Created by ketao on 15-2-10.
 */
public class CustomizeStdDeserializer extends StdDeserializer {

    protected CustomizeStdDeserializer(Class vc) {
        super(vc);
    }

    protected CustomizeStdDeserializer(JavaType valueType) {
        super(valueType);
    }

    @Override
    public Object deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return null;
    }
}
