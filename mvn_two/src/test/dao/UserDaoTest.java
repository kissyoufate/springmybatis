package dao;

import model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import tool.SqlSessionFactoryTool;


import java.io.IOException;

/**
 * Created by wudi on 2017/11/10.
 */
public class UserDaoTest {

    @Test
    public void testOne() throws IOException {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryTool.getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            UserMapper mapper = openSession.getMapper(UserMapper.class);
            User user = mapper.getUserById(1);

            System.out.println(user);
        } finally {
            openSession.close();
        }

    }
}
