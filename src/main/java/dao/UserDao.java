package dao;

import entity.User;

import java.util.Date;
import java.util.List;

public interface UserDao {

    List<User> getList();
    User getOne(int id);
    int insert(User user);
    int update(User user);
    int delete(int id);
    Date formatDate(String str);
}
