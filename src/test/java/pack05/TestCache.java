package pack05;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pack01.bean.Account;
import pack01.dao.AccountDao;
import pack01.util.MySessionUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCache {
    @Test
    public void test01(){
        //1:获取会话（本质还是连接）
        SqlSession session = MySessionUtil.getSession();
        //2:查看会话  调用dao的增删改查
        AccountDao dao = session.getMapper(AccountDao.class);//生成接口的动态代理类 参1：接口
        dao.find(1003L); //将对象保存在集合中
        dao.find(1003L);
    }


}
