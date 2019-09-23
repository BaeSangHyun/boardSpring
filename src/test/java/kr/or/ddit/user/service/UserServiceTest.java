package kr.or.ddit.user.service;

import kr.or.ddit.config.test.UserTestConfig;
import kr.or.ddit.user.model.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserServiceTest extends UserTestConfig {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Resource(name = "userService")
    private IUserService userService;

    @Test
    public void getUser() {
        /***Given***/
        Map map = new HashMap();
        map.put("userId", "bshn123");
        map.put("pass", "password");

        /***When***/
        User user = userService.getUser(map);

        /***Then***/
        logger.debug("user : {}", user);
        assertNotNull(user);

    }
}