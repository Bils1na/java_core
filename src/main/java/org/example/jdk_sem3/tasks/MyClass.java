package org.example.jdk_sem3.tasks;

import java.io.DataInput;
import java.io.InputStream;

public class MyClass <T extends Comparable<String>, V extends InputStream & DataInput, K extends Number> {
    T var1;
    V var2;
    K var3;


    public MyClass(T var1, V var2, K var3) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
    }

    public T getVar1() {
        return var1;
    }

    public V getVar2() {
        return var2;
    }

    public K getVar3() {
        return var3;
    }

    public void nameVarClasses() {
        System.out.printf("var1 - %s, var2 - %s, var - %s",
                var1.getClass().getName(), var2.getClass().getName(), var3.getClass().getName());
    }


}
