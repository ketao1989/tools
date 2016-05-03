package io.github.ketao1989.jackson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by ketao on 15-2-7.
 */
public abstract class ParameterizedTypeReference<T> {

    private final Type type;

    public ParameterizedTypeReference() {
        Type clazz = getClass().getGenericSuperclass();
        type = ((ParameterizedType) clazz).getActualTypeArguments()[0];
    }

    public Type getType() {
        return this.type;
    }
}
