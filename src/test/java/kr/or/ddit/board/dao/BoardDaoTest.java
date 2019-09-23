package kr.or.ddit.board.dao;

import kr.or.ddit.config.test.BoardTestConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class BoardDaoTest extends BoardTestConfig {
    private static final Logger logger = LoggerFactory.getLogger(BoardDaoTest.class);

    @Resource(name = "boardDao")
    private IBoardDao boardDao;

    @Test
    public void insertBoard() {
        /***Given***/
        Map map = new HashMap();
        map.put("boardNm", "스프링다오테스트");
        map.put("userId", "bshn123");
        map.put("useable", "T");

        /***When***/
        int i = boardDao.insertBoard(map);

        /***Then***/
        assertEquals(1, i);
    }

    @Test
    public void allBoard() {
        /***Given***/

        /***When***/
        List<Map> maps = boardDao.allBoard();

        /***Then***/
        logger.debug("BoardList() : {}, {}", maps, maps.size());
        assertEquals(16, maps.size());
    }

    @Test
    public void updateBoard() {
        /***Given***/
        /***Given***/
        Map map = new HashMap();
        map.put("useable", "F");
        map.put("boardId", 5);

        /***When***/
        int i = boardDao.updateBoard(map);
        /***Then***/
        assertEquals(1, i);

    }
}
