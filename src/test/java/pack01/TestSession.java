package pack01;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pack01.util.MySessionUtil;

public class TestSession {
    @Test
    public void test01(){
        //1:获取会话（本质还是连接）
        SqlSession session = MySessionUtil.getSession();
        //2:查看会话
        System.out.println(session);
        //3:增删改查
    }
}
