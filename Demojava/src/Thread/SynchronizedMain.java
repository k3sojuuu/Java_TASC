package Thread;

public class SynchronizedMain {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest.Counter counter = new SynchronizedTest().new Counter();

        // Tạo hai thread chạy đồng thời
        Thread thread1 = new SynchronizedTest().new MyThread(counter);
        Thread thread2 = new SynchronizedTest().new MyThread(counter);

        // Bắt đầu các thread
        thread1.start();
        thread2.start();

        // Đợi cho đến khi cả hai thread hoàn thành
        thread1.join();
        thread2.join();

        // In ra giá trị cuối cùng của count
        System.out.println("Final count: " + counter.getCount());
    }
}
