package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import dao.UserMapper;
import model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import tool.JsonReverTool;
import tool.SqlSessionFactoryTool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wudi on 2017/11/10.
 */
public class TestService {

    public String getAllUsers() throws IOException {

        List<User> userList = new ArrayList<User>();

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryTool.getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        String jsonstr;
        try {
            UserMapper mapper = openSession.getMapper(UserMapper.class);
            List lists = mapper.getAllUser();

            jsonstr = null;

            if (lists != null) {
                jsonstr = JsonReverTool.reverObjectToJsonStr(lists, 1, null);
            } else {
                jsonstr = JsonReverTool.reverObjectToJsonStr(null, 0, "用户获取失败");
            }
        } finally {
            openSession.close();
        }

        return jsonstr;
    }

    public String addUser(String name, String password) throws IOException {
        String jsonstr = null;

        if (name == null || name.equals("")) {
            jsonstr = JsonReverTool.reverObjectToJsonStr(null, 0, "用户名不能为空");
        }

        if (password == null || password.equals("")) {
            jsonstr = JsonReverTool.reverObjectToJsonStr(null, 0, "密码不能为空");
        }


        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryTool.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            User u = new User(name, password);

            int i = sqlSession.getMapper(UserMapper.class).addUser(u);

            if (i > 0) {
                //提交操作
                sqlSession.commit();
                u.setId(i);
                jsonstr = JsonReverTool.reverObjectToJsonStr(u, 1, null);
            } else {
                jsonstr = JsonReverTool.reverObjectToJsonStr(null, 0, "用户添加失败");
            }
        } finally {
            sqlSession.close();
        }
        return jsonstr;
    }
}
