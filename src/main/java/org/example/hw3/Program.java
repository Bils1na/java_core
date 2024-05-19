package org.example.hw3;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {

        ArrayList<BaseWorker> workers1 = new ArrayList<>();
        workers1.add(new Worker("Петр", "Янков", "Босс"));
        workers1.add(new Worker("Алла", "Павлова", "Менеджер"));
        workers1.add(new Worker("Андрей", "Филимонов", "Работник"));
        workers1.add(new Worker("Кирилл", "Иванов", "Работник"));
        workers1.add(new Worker("Елизавета", "Косенко", "Работник"));
        workers1.add(new Freelancer("Томаш", "Ковальский", 450));

        SalaryComparator comparator = new SalaryComparator();
        workers1.sort(comparator);

        for (BaseWorker worker : workers1) {
            System.out.println(worker);
        }

        System.out.println();

        BaseWorker[] workers = {
                new Worker("Петр", "Янков", "Босс"),
                new Worker("Алла", "Павлова", "Менеджер"),
                new Worker("Андрей", "Филимонов", "Работник"),
                new Worker("Кирилл", "Иванов", "Работник"),
                new Worker("Елизавета", "Косенко", "Работник"),
                new Freelancer("Томаш", "Ковальский", 450)
        };

        WorkersList workers2 = new WorkersList(workers);

        for (BaseWorker worker : workers2){
            System.out.println(worker);
        }

    }

}
