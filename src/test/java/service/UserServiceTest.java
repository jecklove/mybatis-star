package service;

import entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
@Slf4j
public class UserServiceTest {
    UserService service ;
    @Before
    public void setUp() throws Exception {
       service = new UserService();
    }

    @After
    public void tearDown() throws Exception {
        service = null;
    }

    @Test
    public void selectAll() {
        List<User> userList = service.selectAll();
        log.info("===>{}",userList);
        assertNotNull(userList);
    }

    @Test
    public void insertOne() {
        service.insertOne("落雁", "女", 18, "2002-07-07", "北京", "博士", "112");
    }

    @Test
    public void updateOne() {
        service.updateOne(User.builder().id(1).name("麻子").age(10).build());
    }

    @Test
    public void deleteOne() {
        service.deleteOne(1);
    }
}