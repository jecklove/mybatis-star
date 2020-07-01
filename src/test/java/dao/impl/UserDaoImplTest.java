package dao.impl;

import dao.UserDao;
import entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@Slf4j
public class UserDaoImplTest {
    UserDao userDao;
    @Before
    public void setUp() throws Exception {
        userDao = new UserDaoImpl();
    }

    @After
    public void tearDown() throws Exception {
        userDao = null;
    }

    @Test
    public void getList() {
        List<User> userList = userDao.getList();
        log.info("===>{}",userList);
        assertNotNull(userList);
    }

    @Test
    public void getOne() {
        User user = userDao.getOne(12);
        log.info("===>",user);
        assertNotNull(user);
    }

    @Test
    public void insert() {
        Date birthday = userDao.formatDate("2020-06-06");

        int result = userDao.insert(User.builder().name("闭月").sex("女").age(20).birthday(birthday).address("日本").education("博士后").tel("119").build());

        log.info("===>{}",result);
        assertEquals(result,1);
    }

    @Test
    public void update() {
        int result = userDao.update(User.builder().id(14).address("合肥").build());
        log.info("====>{}",result);
        assertEquals(result,1);
    }

    @Test
    public void delete() {
        int result = userDao.delete(17);
        log.info("===>{}",result);
        assertEquals(result,0);
    }
}