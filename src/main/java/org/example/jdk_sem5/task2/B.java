package org.example.jdk_sem5.task2;

public class B implements Runnable{
    private String nameB;
    private Switcher switcher;


    public B(Switcher switcher, String nameB) {
        this.nameB = nameB;
        this.switcher = switcher;
    }

    @Override
    public void run() {
        int count = 100;
        while (count > 0) {
            if (switcher.getSwitcher()) {
                System.out.println("count = " + count--);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
