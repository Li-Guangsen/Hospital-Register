package com.lgs.backend.utils;

import com.lgs.backend.model.OrderSearchCount;
import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
//        LocalDate today = LocalDate.now();
//        System.out.println(today);
//        LocalDate firstDayOfWeek = today.with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
//        System.out.println(firstDayOfWeek);
//        List<OrderSearchCount> rows = new ArrayList<>();
//        rows.add(new OrderSearchCount("2024-08-12", 1));
//        rows.add(new OrderSearchCount("2024-08-15", 2));
//        List<Integer> data = new ArrayList<>();
//        for (int i = 0; i < 7; i++) {
//            String fdw = firstDayOfWeek.toString();
//            for (OrderSearchCount row : rows)
//                if (row.getName().equals(fdw))
//                    data.add(row.getValue());
//            if (data.size() < i + 1)
//                data.add(0);
//            firstDayOfWeek = firstDayOfWeek.plusDays(1);
//
//        }
//        for(int i=0;i<data.size();i++){
//            System.out.println(data.get(i));
//        }
//        String str = "humengqi";
//        String md5 = DigestUtils.md5DigestAsHex(str.getBytes());
//        String md6 = DigestUtils.md5DigestAsHex(str.getBytes(StandardCharsets.UTF_8));
//        System.out.println(md6);
//        System.out.println(md5);
//        PasswordEncryptor encryptor = new StrongPasswordEncryptor();
//        System.out.println(encryptor.encryptPassword("123456"));
//        System.out.println(encryptor.encryptPassword("123456"));
    }
}
