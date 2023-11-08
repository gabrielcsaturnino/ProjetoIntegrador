package org.conrel;

public class test {
    public String name;

    public test(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return
                "name= " + name;
    }
}
