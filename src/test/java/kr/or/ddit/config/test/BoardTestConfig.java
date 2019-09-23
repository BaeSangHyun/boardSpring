package kr.or.ddit.config.test;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/context-root.xml",
                                   "classpath:kr/or/ddit/config/spring/context-datasource-test.xml",
                                    "classpath:kr/or/ddit/config/spring/context-transaction.xml"})
public class BoardTestConfig {
    private static final Logger logger = LoggerFactory.getLogger(BoardTestConfig.class);

    @Resource(name = "datasource")
    private BasicDataSource dataSource;

    protected MockMvc mockMvc;

    @Before
    public void setup() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("/kr/or/ddit/config/db/init-board.sql"));
        populator.setContinueOnError(false);
        DatabasePopulatorUtils.execute(populator, dataSource);
    }

    @Ignore
    @Test
    public void dummy() {

    }
}
