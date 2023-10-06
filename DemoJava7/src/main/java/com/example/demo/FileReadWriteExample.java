package com.example.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWriteExample {
    public static void main(String[] args) {
        // Tên của hai tệp bạn muốn đọc
        String inputFile = "D:\\Ky_7\\Demo\\DemoJava7\\src\\main\\resources\\static\\bad_json.txt";
        // Tên của tệp CSV đầu ra
        String outputFile = "D:\\Ky_7\\Demo\\DemoJava7\\src\\main\\resources\\static\\bad_json.csv";
        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            // Đọc dữ liệu từ tệp 1 và ghi vào tệp CSV
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("output csv Pass");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
