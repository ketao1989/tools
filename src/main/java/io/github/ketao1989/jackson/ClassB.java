package io.github.ketao1989.jackson;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * Created by ketao on 15-2-10.
 */
public class ClassB {

    int age;

    List<String> hobby;

    List<TypeB> bb;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public List<TypeB> getBb() {
        return bb;
    }

    public void setBb(List<TypeB> bb) {
        this.bb = bb;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
