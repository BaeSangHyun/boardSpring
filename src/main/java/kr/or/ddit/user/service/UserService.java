package kr.or.ddit.user.service;

import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class UserService implements IUserService {
    private static IUserService instance;

    @Resource(name = "userDao")
    private IUserDao dao;


    @Override
    public User getUser(Map map) {
        User user = dao.getUser(map);
        return user;
    }
}
