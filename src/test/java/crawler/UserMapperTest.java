package crawler;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.crawler.dao.UserDao;
import com.crawler.po.UserPo;

public class UserMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    //ע��Before����ִ�б������в��Է���֮ǰ�ȵ����������  
    @Before
    public void setup() throws Exception {
        //����SqlSessionFactory  
        String resource = "SqlMapConfig.xml";

        //�������ļ����س���  
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //�����Ự����������mybatis�����ļ�����Ϣ  
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserById() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //����UserMapper�������  
        UserDao userMapper = sqlSession.getMapper(UserDao.class);

        //����userMapper�ķ���  
        UserPo user = userMapper.getUserById("1");

        System.out.println(user.getName());
    }
}
