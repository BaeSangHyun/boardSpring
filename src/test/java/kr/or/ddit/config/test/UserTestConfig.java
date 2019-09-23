package kr.or.ddit.config.test;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/context-root.xml",
                                   "classpath:kr/or/ddit/config/spring/context-datasource-test.xml",
                                    "classpath:kr/or/ddit/config/spring/context-transaction.xml"})
public class UserTestConfig {
    private static final Logger logger = LoggerFactory.getLogger(UserTestConfig.class);

    @Resource(name = "datasource")
    private BasicDataSource dataSource;

    @Before
    public void setup() {

    }

    @Ignore
    @Test
    public void dummy() {

    }
}
