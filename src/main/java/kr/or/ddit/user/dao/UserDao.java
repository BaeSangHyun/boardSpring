package kr.or.ddit.user.dao;

import kr.or.ddit.user.model.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

@Repository
public class UserDao implements IUserDao {
    private static IUserDao dao;

    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate session;

    private UserDao() {}

    @Override
    public User getUser(Map map) {
        return session.selectOne("user.getUser", map);
    }
}
