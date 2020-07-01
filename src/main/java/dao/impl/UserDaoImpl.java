package dao.impl;

import dao.UserDao;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import utils.DbUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private SqlSession sqlSession;

    @Override
    public List<User> getList() {
        sqlSession = DbUtil.getSqlSession();
        List<User> userList = sqlSession.selectList("getList");
        sqlSession.close();
        return userList;
    }

    @Override
    public User getOne(int id) {
        sqlSession = DbUtil.getSqlSession();
        User user = sqlSession.selectOne("getOne",id);
        sqlSession.close();
        return user;
    }

    @Override
    public int insert(User user) {
        sqlSession = DbUtil.getSqlSession();
        int result = sqlSession.insert("insert", user);
        sqlSession.close();
        return result;
    }

    @Override
    public int update(User user) {
        sqlSession = DbUtil.getSqlSession();
        int result = sqlSession.update("update", user);
        sqlSession.close();
        return result;
    }

    @Override
    public int delete(int id) {
        sqlSession = DbUtil.getSqlSession();
        int result = sqlSession.delete("delete", id);
        sqlSession.close();
        return result;
    }

    /**
     * 格式化日期方法
     * @param str
     * @return
     */
    public Date formatDate(String str){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-DD");
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
