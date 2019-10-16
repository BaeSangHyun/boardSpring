package kr.or.ddit.login.web;

import kr.or.ddit.config.test.LoginControllerTestConfig;
import kr.or.ddit.user.service.IUserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class LoginControllerTest extends LoginControllerTestConfig {
    private static final Logger logger = LoggerFactory.getLogger(LoginControllerTest.class);

    @Resource(name = "userService")
    private IUserService userService;

    @Test
    public void login() throws Exception {
        mockMvc.perform(post("/login")
                .param("userId", "bshn123")
                .param("pass", "password"))
                .andExpect(status().is(302))
                .andExpect(redirectedUrl("/board/main"));
    }

    @Test
    public void logout() throws Exception{
        mockMvc.perform(get("/logout").session(session))
                .andExpect(status().is(302))
                .andExpect(redirectedUrl("/login"));
    }
}