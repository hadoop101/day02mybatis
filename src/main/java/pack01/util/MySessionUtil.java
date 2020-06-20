package pack01.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MySessionUtil {
    //读配置文件
    private static SqlSessionFactory sessionFactory;
    static {
        InputStream inputStream=MySessionUtil.class.getResourceAsStream("/mybatis-config.xml");
        //解析  SqlSessionFactoryBuilder解析配置文件，并且创建session工厂
         sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    public static SqlSession getSession() {
        //1:必须知道数据库的参数
        //2:发起连接
        return sessionFactory.openSession();
    }
}
