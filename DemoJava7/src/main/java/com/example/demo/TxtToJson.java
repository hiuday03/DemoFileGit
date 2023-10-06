package com.example.demo;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TxtToJson {
    public static void main(String[] args) {
        String filePath = "D:\\Ky_7\\Demo\\DemoJava7\\src\\main\\resources\\static\\bad_json.txt"; // Đường dẫn đến tệp văn bản

        try {
            // Phân tích chuỗi và tạo 1 đối tượng json từ nó chuỗi đó
            List<JSONObject> jsonArray = readTextFileToJSONList(filePath);
            // Sử dụng mảng JSON tại đây hoặc xuất ra JSON dưới dạng chuỗi
            JSONArray jsonResult = new JSONArray(jsonArray);
            System.out.println("Dữ liệu JSON: " + jsonResult.toString(4)); // in ra màn hình dữ liệu json đọc được
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }


    // readTextFileToJSONList đọc tệp văn bản dưới dạng danh sách các đối tượng json
    public static List<JSONObject> readTextFileToJSONList(String filePath) throws IOException {
        List<JSONObject> jsonObjects = new ArrayList<>();
        Gson gson = new Gson();

        // BufferedReader Dùng để đọc văn bản dưới dạng dòng
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                JSONObject jsonObject = convertTextToJSON(line);
                if (jsonObject != null) {
                    jsonObjects.add(jsonObject);
                }
            }
        }

        return jsonObjects;
    }


    // convertTextToJSON Chuyển đổi mỗi dòng văn bản thành 1 đối tượng json
    public static JSONObject convertTextToJSON(String text) {
        try {
            return new JSONObject(text);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
