package service;

import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserService {
      //1.主配置文件位置
      private  String resource = "mybatis-config.xml";
      //2.加载主配置文件  ===》文件输入流   抛出IOException
      private InputStream inputStream;

    {
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //3.读取配置文件，创建SqlSessionFactory对象
      private SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    //4.获取SqlSession对象   ====》Connection对象
     private SqlSession sqlSession = sqlSessionFactory.openSession();



    /**
     * 查询所有数据
     * @return allUser
     */
    public List<User> selectAll(){

        return  sqlSession.selectList("getList");
    }

    /**
     *
     * @param name
     * @param sex
     * @param age
     * @param birthday(yyyy-MM-DD)
     * @param address
     * @param education
     * @param tel
     * @return
     */
    public int insertOne(String name, String sex, int age, String birthday, String address, String education, String tel) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-DD");
        Date birthday1 = new Date();
        try {
            birthday1 = simpleDateFormat.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int result = sqlSession.insert("insert", User.builder().name(name).age(age).birthday(birthday1).address(address).sex(sex).education(education).tel(tel).build());
        sqlSession.commit();
        return result;
    }

    /**
     * 修改一条记录
     * @param user
     * @return result
     */
    public int updateOne(User user){
        int result = sqlSession.update("update", user);
        sqlSession.commit();
        return result;
    }

    /**
     * 删除一条记录
     * @param id
     * @return
     */
    public int deleteOne(int id){

        int result = sqlSession.delete("delete", id);
        sqlSession.commit();
        return result;
    }
}
