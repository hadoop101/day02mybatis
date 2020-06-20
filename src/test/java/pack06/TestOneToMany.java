package pack06;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pack01.bean.Account;
import pack01.bean.User;
import pack01.dao.AccountDao;
import pack01.dao.UserDao;
import pack01.util.MySessionUtil;

import java.util.List;

public class TestOneToMany {
    @Test
    public void test01(){
        //1:获取会话（本质还是连接）
        SqlSession session = MySessionUtil.getSession();
        //2:查看会话  调用dao的增删改查
        //查出所有用户的所有账户信息
        UserDao userDao= session.getMapper(UserDao.class);
        List<User> userList = userDao.findAll();//select
        System.out.println(userList);
    }


}
