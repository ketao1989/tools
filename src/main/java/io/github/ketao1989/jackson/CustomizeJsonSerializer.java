package io.github.ketao1989.jackson;

import com.google.common.base.Joiner;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.util.List;

/**
 * Created by ketao on 15-2-8.
 */
public class CustomizeJsonSerializer extends JsonSerializer<List> {

    @Override
    public void serialize(List value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeStartArray();

        for (Object va :value){
            jgen.writeString(va.toString()+"TestSerialize");
        }

        //jgen.writeString(Joiner.on(";").join(value));
        jgen.writeEndArray();
    }
}
