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

        //session查找sql时候，有两个条件，第一，映射文件必须添加到核心文件中。 第二，查找字符串=namesapce+id
       List<Account> list= session.selectList("pack01.bean.Account.findAll");//参1：sql
       System.out.println(list);

        List<Account> list2= session.selectList("pack01.bean.Account.findAll2");//参1：sql
        System.out.println(list2);
    }

    @Test
    public void test02(){
        //1:获取会话（本质还是连接）
        SqlSession session = MySessionUtil.getSession();
        //2:查看会话
        System.out.println(session);
        //3:增删改查
        Account account = new Account(1002L,"jack",100D);
        int row=session.insert("pack01.bean.Account.save",account);//参1：namespace+id,参2：对象
        System.out.println(row);
        session.commit();
    }

    @Test
    public void test03(){
        //1:获取会话（本质还是连接）
        SqlSession session = MySessionUtil.getSession();
        //2:查看会话
        System.out.println(session);
        //3:增删改查
        session.delete("pack01.bean.Account.delete",1002L);
        session.commit();
    }
}
