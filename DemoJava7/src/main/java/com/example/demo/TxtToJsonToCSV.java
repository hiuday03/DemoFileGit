package com.example.demo;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TxtToJsonToCSV {

    public static void main(String[] args) throws IOException {
        String inputFilePath = "D:\\Ky_7\\Demo\\DemoJava7\\src\\main\\resources\\static\\bad_json.txt";
        String outputFilePath = "D:\\Ky_7\\Demo\\DemoJava7\\src\\main\\resources\\static\\bad_json.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            // Đọc dữ liệu từ tệp JSON và ghi vào tệp CSV
            String line;
            while ((line = br.readLine()) != null) {
                JsonObject jsonObject = JsonParser.parseString(line).getAsJsonObject();
                String csvLine = convertToCSV(jsonObject);
                bw.write(csvLine);
                bw.newLine();
            }

            System.out.println("Chuyển đổi thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String convertToCSV(JsonObject jsonObject) {
        // Trích xuất các giá trị từ JsonObject và chuyển thành chuỗi CSV
        return jsonObject.get("transaction_date")+ "," +
                jsonObject.get("document_type") + "," +
                jsonObject.get("product_type") + "," +
                jsonObject.get("price_plan") + "," +
                jsonObject.get("transaction_type") + "," +
                jsonObject.get("group_type_1") + "," +
                jsonObject.get("group_name_1") + "," +
                jsonObject.get("delivery_mode") + "," +
                jsonObject.get("voucher") + "," +
                jsonObject.get("customer_title") + "," +
                jsonObject.get("customer_id") + "," +
                jsonObject.get("nationality") + "," +
                jsonObject.get("customer_category") + "," +
                jsonObject.get("customer_sub_category")+ "," +
                jsonObject.get("hub_club_status") + "," +
                jsonObject.get("source") + "," +
                jsonObject.get("scr") + "," +
                jsonObject.get("dob") + "," +
                jsonObject.get("customer_name") + "," +
                jsonObject.get("email") + "," +
                jsonObject.get("mobile_number")+ "," +
                jsonObject.get("group") + "," +
                jsonObject.get("division") + "," +
                jsonObject.get("top_hierarchy_level") + "," +
                jsonObject.get("placeholder13");
    }
}
