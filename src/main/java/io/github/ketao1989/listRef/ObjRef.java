/*
* Copyright (c) 2015 ketao1989.github.com. All Rights Reserved.
*/
package io.github.ketao1989.listRef;

/**
 * @author tao.ke Date: 16/2/26 Time: 上午10:37
 */
public class ObjRef {

    private int value;

    private String name;

    public ObjRef(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return "ObjRef{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
