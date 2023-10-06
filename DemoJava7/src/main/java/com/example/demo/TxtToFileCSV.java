package com.example.demo;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtToFileCSV {
    static class Transaction {
        String transaction_date, document_type, product_type, price_plan, transaction_type, group_type_1, group_name_1, delivery_mode, voucher, customer_title, customer_id, nationality, customer_category, customer_sub_category, hub_club_status, source, scr, dob, customer_name, email, mobile_number, group, division, top_hierarchy_level, placeholder13;
    }

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\Ky_7\\Demo\\DemoJava7\\src\\main\\resources\\static\\bad_json.txt";
        String outputFilePath = "D:\\Ky_7\\Demo\\DemoJava7\\src\\main\\resources\\static\\bad_json.csv";

        List<Transaction> transactions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            Gson gson = new Gson();
            while ((line = br.readLine()) != null) {
                Transaction transaction = gson.fromJson(line, Transaction.class);
                transactions.add(transaction);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            String header = "transaction_date,document_type,product_type,price_plan,transaction_type,group_type_1,group_name_1,delivery_mode,voucher,customer_title,customer_id,nationality,customer_category,customer_sub_category,hub_club_status,source,scr,dob,customer_name,email,mobile_number,group,division,top_hierarchy_level,placeholder13";
            writer.write(header);
            writer.newLine();

            for (Transaction transaction : transactions) {
                String csvLine = convertToCSV(transaction);
                writer.write(csvLine);
                writer.newLine();
            }

            System.out.println("Demo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String convertToCSV(Transaction transaction) {
        return String.join(",", transaction.transaction_date, transaction.document_type, transaction.product_type, transaction.price_plan, transaction.transaction_type, transaction.group_type_1, transaction.group_name_1, transaction.delivery_mode, transaction.voucher, transaction.customer_title, transaction.customer_id, transaction.nationality, transaction.customer_category, transaction.customer_sub_category, transaction.hub_club_status, transaction.source, transaction.scr, transaction.dob, transaction.customer_name, transaction.email, transaction.mobile_number, transaction.group, transaction.division, transaction.top_hierarchy_level, transaction.placeholder13);
    }
}
