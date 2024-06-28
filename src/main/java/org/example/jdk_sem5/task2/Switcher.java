package org.example.jdk_sem5.task2;

public class Switcher {

    private volatile boolean switcher = false;

    public void setSwitcher(boolean switcher) {
        this.switcher = switcher;
    }

    public boolean getSwitcher() {
        return switcher;
    }


}
