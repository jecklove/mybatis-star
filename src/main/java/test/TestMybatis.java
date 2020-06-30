package test;


import entity.User;
import service.UserService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestMybatis {
    public static void main(String[] args) {
        UserService service = new UserService();
//        int result = service.insertOne("落雁", "女", 18, "2002-07-07", "北京", "博士", "112");
//        System.out.println(result);

//        List<User> users = service.selectAll();
//        users.forEach(System.out::println);
//        int result = service.updateOne(User.builder().id(1).name("麻子").age(10).build());
//        System.out.println(result);
        int result = service.deleteOne(1);
        System.out.println(result);
    }
}
