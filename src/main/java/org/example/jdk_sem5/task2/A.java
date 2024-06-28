package org.example.jdk_sem5.task2;

public class A implements Runnable {
    private String nameA;
    private Switcher switcher;


    public A(Switcher switcher, String nameA) {
        this.switcher = switcher;
        this.nameA = nameA;
    }

    @Override
    public void run() {
        while (true) {
            try {
                switcher.setSwitcher(!switcher.getSwitcher());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
