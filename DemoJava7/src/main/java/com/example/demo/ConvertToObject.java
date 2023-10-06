//package com.example.demo;
//
//
//import com.google.gson.Gson;
//import java.io.FileReader;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class ConvertToObject {
//
//    public final static String headers = "TransactionDate,DocumentType,ProductType,PricePlan,TransactionType," +
//            "GroupType1,GroupName1,DeliveryMode,Voucher,CustomerTitle,CustomerId,Nationality,CustomerCategory,CustomerSubCategory," +
//            "HubClubStatus,Source,Scr,Dob,CustomerName,Email,MobileNumber,Group,Division,TopHierachy,PlaceHolder13";
//
//    public static void main(String[] args) throws IOException {
//        File file = new File("D:\\Ky_7\\Demo\\DemoJava7\\src\\main\\resources\\static\\bad_json.txt");
//        BufferedReader br = new BufferedReader(new FileReader(file));
//
//        Gson gson = new Gson();
//        List<Object> listObjs = new ArrayList<>();
//
//        String text;
//        while ((text = br.readLine()) != null) {
//            Object object = gson.fromJson(text, Object.class);
//            listObjs.add(object);
//        }
//        File outputFile = new File("D:\\Ky_7\\Demo\\DemoJava7\\src\\main\\resources\\static\\bad_json.csv");
//        try (FileWriter fw = new FileWriter(outputFile)) {
//            fw.append(headers);
//            fw.append("\n");
//            for (Object obj : listObjs) {
//                fw.append(obj.transaction_date).append(",");
//                fw.append(obj.document_type).append(",");
//                fw.append(obj.product_type).append(",");
//                fw.append(obj.price_plan).append(",");
//                fw.append(obj.transaction_type).append(",");
//                fw.append(obj.group_type_1).append(",");
//                fw.append(obj.group_name_1).append(",");
//                fw.append(obj.delivery_mode).append(",");
//                fw.append(obj.voucher).append(",");
//                fw.append(obj.customer_title).append(",");
//                fw.append(obj.customer_id).append(",");
//                fw.append(obj.nationality).append(",");
//                fw.append(obj.customer_category).append(",");
//                fw.append(obj.customer_sub_category).append(",");
//                fw.append(obj.hub_club_status).append(",");
//                fw.append(obj.source).append(",");
//                fw.append(obj.scr).append(",");
//                fw.append(obj.dob).append(",");
//                fw.append(obj.customer_name).append(",");
//                fw.append(obj.email).append(",");
//                fw.append(obj.mobile_number).append(",");
//                fw.append(obj.group).append(",");
//                fw.append(obj.division).append(",");
//                fw.append(obj.top_hierachy_level).append(",");
//                fw.append(obj.placeholder13).append("\n");
//            }
//        }
//        System.out.print("Done");
//
//    }
//}
