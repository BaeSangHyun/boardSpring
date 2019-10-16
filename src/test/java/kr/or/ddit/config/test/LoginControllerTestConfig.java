package kr.or.ddit.config.test;

import kr.or.ddit.user.model.User;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/context-root.xml",
                                   "classpath:kr/or/ddit/config/spring/context-datasource-test.xml",
                                    "classpath:kr/or/ddit/config/spring/context-transaction.xml",
                                    "classpath:kr/or/ddit/config/spring/servlet-context.xml"})
@WebAppConfiguration
public class LoginControllerTestConfig {
    private static final Logger logger = LoggerFactory.getLogger(LoginControllerTestConfig.class);

    @Resource(name = "datasource")
    private BasicDataSource dataSource;

    @Autowired
    private WebApplicationContext context;

    protected MockHttpSession session;

    protected MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();


        session = new MockHttpSession();

    }

    @Ignore
    @Test
    public void dummy() {

    }
}
