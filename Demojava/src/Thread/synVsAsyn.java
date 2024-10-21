package Thread;

import java.util.concurrent.CompletableFuture;

public class synVsAsyn {
    public static void main(String[] args) {
        //Syn
//        System.out.println("Start task 1");
//        task1();
//        System.out.println("Start task 2");
//        task2();
//        System.out.println("All tasks completed");

        /// Asyn
        System.out.println("Start task 1");
        // Gọi task1 bất đồng bộ
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> task1());
        System.out.println("Start task 2");
        // Gọi task2 bất đồng bộ
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> task2());
        // Chờ cả hai task hoàn thành
        CompletableFuture.allOf(future1, future2).join();
        System.out.println("All tasks completed");
    }

    public static void task1() {
        try {
            Thread.sleep(2000); // Giả lập task mất 2 giây để hoàn thành
            System.out.println("Task 1 completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void task2() {
        try {
            Thread.sleep(3000); // Giả lập task mất 3 giây để hoàn thành
            System.out.println("Task 2 completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
