package pack04;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pack01.bean.Account;
import pack01.dao.AccountDao;
import pack01.util.MySessionUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestSql {
    @Test
    public void test01(){
        //1:获取会话（本质还是连接）
        SqlSession session = MySessionUtil.getSession();
        //2:查看会话  调用dao的增删改查
        AccountDao dao = session.getMapper(AccountDao.class);//生成接口的动态代理类 参1：接口
        Account account = new Account();
        account.setId(3L);
    //    account.setMoney(1000D);
        account.setAccount("tony");
        dao.update(account);//sql
    }

    @Test
    public void test02(){
        //1:获取会话（本质还是连接）
        SqlSession session = MySessionUtil.getSession();
        //2:查看会话  调用dao的增删改查
        AccountDao dao = session.getMapper(AccountDao.class);//生成接口的动态代理类 参1：接口
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("keyword","%c%");
//        map.put("min",100D);
//        map.put("max",1000D);

        dao.search(map);//select
    }
    @Test
    public void test03(){
        //1:获取会话（本质还是连接）
        SqlSession session = MySessionUtil.getSession();
        //2:查看会话  调用dao的增删改查
        AccountDao dao = session.getMapper(AccountDao.class);//生成接口的动态代理类 参1：接口
        List<Long> ids=new ArrayList<Long>();
        ids.add(3L);
        ids.add(5L);
        dao.deleteByIds(ids);//delete
        session.commit();
    }
    @Test
    public void test04(){
        //1:获取会话（本质还是连接）
        SqlSession session = MySessionUtil.getSession();
        //2:查看会话  调用dao的增删改查
        AccountDao dao = session.getMapper(AccountDao.class);//生成接口的动态代理类 参1：接口
        Account account = new Account();
        account.setId(1005L);
//        account.setAccount("tony");
//        account.setMoney(33D);
        dao.save2(account);//insert
        session.commit();
    }
}
