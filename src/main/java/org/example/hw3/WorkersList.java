package org.example.hw3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class WorkersList implements Iterable<BaseWorker> {
    private BaseWorker[] workers;

    public WorkersList(BaseWorker[] workers) {
        this.workers = workers;
    }

    @Override
    public Iterator<BaseWorker> iterator() {
        return new Iterator<BaseWorker>() {

            private int index = -1;

            @Override
            public boolean hasNext() {
                return index + 1 < workers.length;
            }

            @Override
            public BaseWorker next() {
                index++;
                if (index >= 0 && index < workers.length) {
                    return workers[index];
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

}
