package kr.or.ddit.user.dao;

import kr.or.ddit.config.test.UserTestConfig;
import kr.or.ddit.user.model.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserDaoTest extends UserTestConfig {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    @Resource(name = "userDao")
    private IUserDao userDao;

    @Test
    public void getUser() {
        /***Given***/
        Map map = new HashMap();
        map.put("userId", "bshn123");
        map.put("pass", "password");

        /***When***/
        User user = userDao.getUser(map);

        /***Then***/
        logger.debug("user : {}", user);
        assertNotNull(user);

    }
}