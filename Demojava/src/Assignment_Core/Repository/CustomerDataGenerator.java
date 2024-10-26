package Assignment_Core.Repository;

import Assignment_Core.Model.Customers;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;

public class CustomerDataGenerator {
    private static final String FILE_PATH = "src/Assignment_Core/resources/cus.txt";
    private static final Map<String, Customers> customers = new HashMap<>();
    private static final Random random = new Random();
    private static final int NUM_THREADS = 4; // Số lượng luồng

    public static void main(String[] args) {
        try {
//            int totalRecords = 5_000_000; // Số lượng bản ghi bạn muốn tạo
            long startTime = System.currentTimeMillis();
//            generateCustomers(totalRecords);
//            saveToFile();
            long endTime = System.currentTimeMillis();

            System.out.println("Data generated and saved to " + FILE_PATH);
            System.out.println("Total time to save data: " + (endTime - startTime) + " ms");

            // Đếm số bản ghi bằng đơn luồng
//            long singleThreadStartTime = System.currentTimeMillis();
//            int singleThreadRecordCount = countTotalRecordsSingleThread();
//            long singleThreadEndTime = System.currentTimeMillis();
//
//            System.out.println("Total records in file (Single Thread): " + singleThreadRecordCount);
//            System.out.println("Time taken to read using Single Thread: " + (singleThreadEndTime - singleThreadStartTime) + " ms");
//
//             Đếm số bản ghi bằng đa luồng
            long multiThreadStartTime = System.currentTimeMillis();
            int multiThreadRecordCount = countTotalRecords();
            long multiThreadEndTime = System.currentTimeMillis();

            System.out.println("Total records in file (Multi Thread): " + multiThreadRecordCount);
            System.out.println("Time taken to read using Multi Thread: " + (multiThreadEndTime - multiThreadStartTime) + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countTotalRecordsSingleThread() throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            while (reader.readLine() != null) {
                count++;
            }
        }
        return count;
    }

    private static int countTotalRecords() throws IOException {
        int totalLines = 0;

        // Đọc toàn bộ file vào một danh sách
        List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
        int partitionSize = (int) Math.ceil((double) lines.size() / NUM_THREADS);

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        Future<Integer>[] futures = new Future[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            final int start = i * partitionSize;
            final int end = Math.min(start + partitionSize, lines.size());

            futures[i] = executor.submit(() -> {
                int count = 0;
                for (int j = start; j < end; j++) {
                    count++; // Đếm số dòng
                }
                return count;
            });
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            try {
                totalLines += futures[i].get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        return totalLines;
    }

    private static void generateCustomers(int count) {
        while (customers.size() < count) {
            String phoneNumber = generatePhoneNumber();
            if (!customers.containsKey(phoneNumber)) {
                String name = generateRandomString(10);
                String email = generateRandomEmail();
                customers.put(phoneNumber, new Customers(name, email, phoneNumber));
            }
        }
    }

    private static String generatePhoneNumber() {
        String prefix = random.nextBoolean() ? "097" : "098";
        return prefix + String.format("%07d", random.nextInt(10_000_000));
    }

    private static String generateRandomString(int length) {
        return random.ints('a', 'z' + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static String generateRandomEmail() {
        return generateRandomString(6) + "@gmail.com";
    }

    private static void saveToFile() throws IOException {
//        if (Files.exists(Paths.get(FILE_PATH))) {
//            Files.delete(Paths.get(FILE_PATH));
//        }

        // Tạo file mới và bắt đầu ghi dữ liệu
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Customers customer : customers.values()) {
                writer.write(customer.getPhoneNumber() + "," + customer.getName() + "," + customer.getEmail());
                writer.newLine(); // Thêm dòng mới sau mỗi bản ghi
            }
        }
    }
}
