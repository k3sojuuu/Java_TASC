package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {
    // Tạo một lớp Callable tùy chỉnh
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        MyCallable callableTask = new MyCallable(10);

        Future<Integer> future = executor.submit(callableTask);

        // Kết quả sẽ là tổng các số từ 1 đến 10
        Integer result = future.get();

        System.out.println("Sum from 1 to 10: " + result);  // Output: Sum from 1 to 10: 55

        executor.shutdown();
//        dung
    }
}
