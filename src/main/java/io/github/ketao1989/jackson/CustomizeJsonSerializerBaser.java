package io.github.ketao1989.jackson;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.std.SerializerBase;
import org.codehaus.jackson.type.JavaType;

import java.io.IOException;

/**
 * Created by ketao on 15-2-8.
 */
public class CustomizeJsonSerializerBaser extends SerializerBase<TypeB> {

    public CustomizeJsonSerializerBaser(){
        super(TypeB.class);
    }

    protected CustomizeJsonSerializerBaser(Class<TypeB> t) {

        super(t);
    }

    protected CustomizeJsonSerializerBaser(JavaType type) {
        super(type);
    }

    protected CustomizeJsonSerializerBaser(Class<?> t, boolean dummy) {
        super(t, dummy);
    }

    @Override
    public void serialize(TypeB value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {

        jgen.writeString(value.toString());
       // System.out.println("======================");
    }
}
