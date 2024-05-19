package org.example.sem3;

public class Human extends BaseHuman implements Runner {

    private int maxRun;
    private int maxJump;

    @Override
    public int getMaxRun() {
        return maxRun;
    }

    @Override
    public int getMaxJump() {
        return maxJump;
    }

    public Human(String name, int age, int maxRun, int maxJump) {
        super(name, age);
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public void printDisplayInfo() {
        System.out.printf("%s %d %d %d", name, age, maxRun, maxJump);
    }

    public static Human create(String name, int age, int maxRun, int maxJump) {
        if (age < 18) {
            throw new RuntimeException("Некорректный возраст!");
        }
        if (name == null || name.length() < 2) {
            throw new RuntimeException("Некорректное имя!");
        }
        return new Human(name, age, maxRun, maxJump);
    }

}
