package org.example.hw3;

import java.util.Comparator;

public class SalaryComparator implements Comparator<BaseWorker> {

    @Override
    public int compare(BaseWorker worker1, BaseWorker worker2) {
        if (worker1.getSalary() == worker2.getSalary()) {
            return 0;
        } else if (worker1.getSalary() < worker2.getSalary()) {
            return 1;
        } else {
            return -1;
        }
    }

}
