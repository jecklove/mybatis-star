package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DbUtil {
    private  DbUtil(){};

    private  static SqlSessionFactory sqlSessionFactory;
    private static final String CONFIG_FILE = "mybatis-config.xml";


    //初始化SqlSessionFaction工厂类对象
     static{
        try {
            InputStream inputStream = Resources.getResourceAsStream(CONFIG_FILE);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(true);
    }
}
