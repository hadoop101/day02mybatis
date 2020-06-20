package pack03;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pack01.bean.Account;
import pack01.dao.AccountDao;
import pack01.util.MySessionUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class TestCRUD02 {
    @Test
    public void test01(){
        //1:获取会话（本质还是连接）
        SqlSession session = MySessionUtil.getSession();
        //2:查看会话  调用dao的增删改查
        AccountDao dao = session.getMapper(AccountDao.class);//生成接口的动态代理类 参1：接口
        List<Account> list = dao.findAll();
        System.out.println(list);
    }
    @Test
    public void test02(){
        //1:获取会话（本质还是连接）
        SqlSession session = MySessionUtil.getSession();
        //2:查看会话  调用dao的增删改查
        AccountDao dao = session.getMapper(AccountDao.class);//生成接口的动态代理类 参1：接口
        Account account = new Account(1004L,"tony",0D);
        dao.save(account);//insert
        session.commit();
    }
    @Test
    public void test03(){
        //1:获取会话（本质还是连接）
        SqlSession session = MySessionUtil.getSession();
        //2:查看会话  调用dao的增删改查
        System.out.println(session); //Mybatis里面也使用Proxy给你实现了接口
        AccountDao dao = session.getMapper(AccountDao.class);//生成接口的动态代理类 参1：接口
        dao.deleteById(1L);//delete
        System.out.println(dao);
        session.commit();
    }
    @Test
    public void test04(){
        //1:获取会话（本质还是连接）
        SqlSession session = MySessionUtil.getSession();
        //2:查看会话  调用dao的增删改查
        AccountDao dao = getMapper(session,AccountDao.class);//生成接口的动态代理类 参1：接口
        dao.deleteById(2L);//delete
        session.commit();
    }

    private AccountDao getMapper(final SqlSession session, Class accountDaoClass) {
        ClassLoader loader=accountDaoClass.getClassLoader();
        Class<?>[] interfaces=new Class[]{accountDaoClass};
        InvocationHandler handler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("------invoke");
                if(method.getName().contains("delete")){
                    session.delete("pack01.dao.AccountDao.deleteById",args[0]);
                }

                return null;
            }
        };
       return (AccountDao) Proxy.newProxyInstance(loader,interfaces,handler);
    }
}
