package pack02;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pack01.bean.Account;
import pack01.util.MySessionUtil;

import java.util.List;

public class TestCRUD01 {
    @Test
    public void test01(){
        //1:获取会话（本质还是连接）
        SqlSession session = MySessionUtil.getSession();
        //2:查看会话
        System.out.println(session);
        //3:增删改查 select * from account;
       List<Account> list= session.selectList("pack01.bean.Account.findAll");//参1：sql
       System.out.println(list);
    }
}
