package Collection;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueCollection {
    public static void main(String[] args) {
        // Sử dụng LinkedList như một Queue
        Queue<String> linkedListQueue = new LinkedList<>();
        linkedListQueue.add("Alice");
        linkedListQueue.add("Bob");
        linkedListQueue.add("Charlie");

        System.out.println("LinkedList Queue:");
        while (!linkedListQueue.isEmpty()) {
            System.out.println("Processing: " + linkedListQueue.poll()); // Lấy và loại bỏ phần tử đầu tiên
        }

        // Sử dụng PriorityQueue
        Queue<Integer> priorityQueue = new PriorityQueue<>(); // Mặc định là tăng dần
        priorityQueue.add(5);
        priorityQueue.add(1);
        priorityQueue.add(3);
        priorityQueue.add(2);

        System.out.println("\nPriority Queue:");
        while (!priorityQueue.isEmpty()) {
            System.out.println("Processing: " + priorityQueue.poll()); // Lấy và loại bỏ phần tử nhỏ nhất
        }

        // Sử dụng ArrayDeque
        Queue<String> arrayDequeQueue = new ArrayDeque<>();
        arrayDequeQueue.add("David");
        arrayDequeQueue.add("Eve");
        arrayDequeQueue.add("Frank");

        System.out.println("\nArrayDeque Queue:");
        while (!arrayDequeQueue.isEmpty()) {
            System.out.println("Processing: " + arrayDequeQueue.poll()); // Lấy và loại bỏ phần tử đầu tiên
        }
    }
}
