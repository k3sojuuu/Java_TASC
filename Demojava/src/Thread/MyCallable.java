package Thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private Integer taskName;

    public MyCallable(Integer taskName) {
        this.taskName = taskName;
    }


//    @Override
//    public String call() throws Exception {
//        Thread.sleep(1000);
//        return "Task " + taskName + " completed!";
//    }
    Integer number;
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i;
        }
        return sum;
    }
}
