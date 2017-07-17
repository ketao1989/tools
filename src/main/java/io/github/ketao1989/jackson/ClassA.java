package io.github.ketao1989.jackson;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;

import io.github.ketao1989.diff.PropertyCnName;

/**
 * Created by ketao on 15-2-7.
 */
public class ClassA {

    @PropertyCnName(cnName = "名字")
    String name;

    @PropertyCnName(cnName = "年龄")
    int age;

    @PropertyCnName(cnName = "爱好")
    private List<String> hobby;

    @PropertyCnName(cnName = "类型B")
    private TypeB b;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @JsonSerialize(using = CustomizeJsonSerializerBaser.class)
    public TypeB getB() {
        return b;
    }

    @JsonDeserialize(using = CustomizeJsonDeserializer.class)
    public void setB(TypeB b) {
        this.b = b;
    }

    @JsonSerialize(using = CustomizeJsonSerializer.class)
    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
