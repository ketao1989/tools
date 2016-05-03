package io.github.ketao1989.jackson;

/**
 * Created by ketao on 15-2-8.
 */
public class TypeB {

    String address;

    int code;

    public TypeB() {
    }

    public TypeB(String address, int code) {
        this.address = address;
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "TypeB{" +
                "address='" + address + '\'' +
                ", code=" + code +
                '}';
    }
}
