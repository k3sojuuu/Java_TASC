package Thread;

public class Threads extends Thread{
    private String threadName;

    public Threads(String name) {
        this.threadName = name;
    }

    // Override phương thức run để định nghĩa công việc của thread
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " is running - count: " + i);
            try {
                // Cho thread ngủ 500ms giữa mỗi lần in ra
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted.");
            }
        }
        System.out.println(threadName + " has finished execution.");
    }
    public static void main(String[] args) {
        // Tạo 2 đối tượng thread
        Threads thread1 = new Threads("Thread 1");
        Thread thread2 = new Threads("Thread 2");

        // Bắt đầu chạy các thread
        thread1.start();
        thread2.start();

        // Kiểm tra khi cả hai thread đã kết thúc
        System.out.println("Main thread is finished.");
    }
}
