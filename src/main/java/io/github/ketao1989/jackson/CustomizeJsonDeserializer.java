package io.github.ketao1989.jackson;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;
import java.util.Map;

/**
 * Created by ketao on 15-2-10.
 */
public class CustomizeJsonDeserializer extends JsonDeserializer<TypeB> {

    @Override
    public TypeB deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        String value = jp.getText();
        Map<String, String> properities = Splitter.on(",").trimResults().withKeyValueSeparator("=").split(StringUtils.substringBetween(value, "{", "}"));

        System.out.println(JsonUtils.encode(properities));

        TypeB typeB = new TypeB(properities.get("address"), Integer.valueOf(properities.get("code")));

        return typeB;
    }
}
