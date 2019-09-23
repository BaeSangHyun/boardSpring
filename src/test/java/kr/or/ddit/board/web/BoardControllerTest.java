package kr.or.ddit.board.web;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.config.test.BoardControllerTestConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class BoardControllerTest extends BoardControllerTestConfig {
    private static final Logger logger = LoggerFactory.getLogger(BoardControllerTest.class);

    @Resource(name = "boardService")
    private IBoardService boardService;

    @Test
    public void boardMain() throws Exception {
        mockMvc.perform(get("/board/main"))
                .andExpect(status().isOk())
                .andExpect(view().name("main"));
    }

    @Test
    public void boardManage() throws Exception {
        mockMvc.perform(get("/board/manage"))
                .andExpect(status().isOk())
                .andExpect(view().name("board/boardManage"));
    }

    @Test
    public void createBoard() throws Exception {
        mockMvc.perform(post("/board/createBoard").session(session)
                .param("boardNm", "스프링다오테스트")
                .param("userId", "bshn123")
                .param("useable", "T"))
                .andExpect(status().is(302))
                .andExpect(redirectedUrl("/board/manage"));
    }

    @Test
    public void modifyBoard() throws Exception {
        mockMvc.perform(post("/board/modifyBoard")
                .param("useable", "F")
                .param("boardId", "5"))
                .andExpect(status().is(302))
                .andExpect(redirectedUrl("/board/manage"));
    }
}