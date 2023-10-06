package com.example.demo;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileCSV {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\Ky_7\\Demo\\DemoJava7\\src\\main\\resources\\static\\bad_json.txt"; // Thay đổi thành đường dẫn của tệp văn bản bạn muốn đọc
        String outputFilePath = "D:\\Ky_7\\Demo\\DemoJava7\\src\\main\\resources\\static\\bad_json.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Tạo một đối tượng Gson
            Gson gson = new Gson();
            List<Object> listObjs = new ArrayList<>();
            // Đọc từng dòng văn bản từ tệp và in ra dưới dạng JSON
            while ((line = br.readLine()) != null) {
                //                System.out.println("Dữ liệu JSON: " + line);
                Object object = gson.fromJson(line, Object.class);
                listObjs.add(object);
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                String header = "transaction_date,document_type,product_type,price_plan,transaction_type,group_type_1," +
                        "group_name_1,delivery_mode,voucher,customer_title,customer_id,nationality,customer_category," +
                        "customer_sub_category,hub_club_status,source,scr,dob,customer_name,email,mobile_number,group," +
                        "division,top_hierarchy_level,placeholder13";
                writer.append(header);
                writer.newLine();
                // Viết dữ liệu từ đối tượng Java vào tệp CSV
                for (Object obj : listObjs) {
                    String csvLine = convertToCSV(obj); // Tạo chuỗi CSV từ đối tượng Java
                    writer.write(csvLine);
                    writer.newLine();
                }
                System.out.println("Demo");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Lớp đại diện cho cấu trúc JSON thực tế, thay thế MyData bằng tên lớp tương ứng
    static class Object {
        // Các trường tương ứng với dữ liệu JSON
        String transaction_date;
        String document_type;
        String product_type;
        String price_plan;
        String transaction_type;
        String group_type_1;
        String group_name_1;
        String delivery_mode;
        String voucher;
        String customer_title;
        String customer_id;
        String nationality;
        String customer_category;
        String customer_sub_category;
        String hub_club_status;
        String source;
        String scr;
        String dob;
        String customer_name;
        String email;
        String mobile_number;
        String group;
        String division;
        String top_hierarchy_level;
        String placeholder13;
    }

    // Chuyển đổi đối tượng Java thành chuỗi CSV
    private static String convertToCSV(Object obj) {
        return obj.transaction_date + "," +
                obj.document_type + "," +
                obj.product_type + "," +
                obj.price_plan + "," +
                obj.transaction_type + "," +
                obj.group_type_1 + "," +
                obj.group_name_1 + "," +
                obj.delivery_mode + "," +
                obj.voucher + "," +
                obj.customer_title + "," +
                obj.customer_id + "," +
                obj.nationality + "," +
                obj.customer_category + "," +
                obj.customer_sub_category + "," +
                obj.hub_club_status + "," +
                obj.source + "," +
                obj.scr + "," +
                obj.dob + "," +
                obj.customer_name + "," +
                obj.email + "," +
                obj.mobile_number + "," +
                obj.group + "," +
                obj.division + "," +
                obj.top_hierarchy_level + "," +
                obj.placeholder13;
    }

    //Tạo mảng json
//    private static String[] Json = {"transaction_date,document_type,product_type,price_plan,transaction_type,group_type_1," +
//            "group_name_1,delivery_mode,voucher,customer_title,customer_id,nationality,customer_category," +
//            "customer_sub_category,hub_club_status	source,scr,dob,customer_name,email,mobile_number,group,division," +
//            "top_hierarchy_level,placeholder13"};
}
