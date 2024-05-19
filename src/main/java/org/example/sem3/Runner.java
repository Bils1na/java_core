package org.example.sem3;

public interface Runner {

    String getName();

    int getMaxRun();

    int getMaxJump();

    default boolean jump(int height) {
        if (height == getMaxJump()) {
            System.out.printf("%s перепрыгнул через стену %d\n", getName(), height);
            return true;
        } else {
            System.out.printf("%s не смог перепрыгнуть стену с высотой %d\n", getName(), height);
            return false;
        }
    }

    default boolean run(int length) {
        if (length == getMaxRun()) {
            System.out.printf("%s пробежал дистанцию в %dм\n", getName(), getMaxRun());
            return true;
        } else {
            System.out.printf("%s не смог пробежать дистанцию в %dм\n", getName(), getMaxRun());
            return false;
        }
    }

}
