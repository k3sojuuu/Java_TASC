package Thread;

public class SynchronizedTest {
    class Counter {
        private int count = 0;

        // Synchronized method to increment the count
        public synchronized void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    class MyThread extends Thread {
        private Counter counter;

        public MyThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        }
    }
}

