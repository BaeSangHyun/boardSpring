package kr.or.ddit.board.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository
public class BoardDao implements IBoardDao {

    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate session;

    private BoardDao() {
    }

    @Override
    public int insertBoard(Map map) {
        int cnt = session.insert("board.createBoard", map);
        return cnt;
    }

    @Override
    public List<Map> allBoard() {
        return session.selectList("board.allBoard");
    }

    @Override
    public int updateBoard(Map map) {
        int cnt = session.update("board.updateBoard", map);
        return cnt;
    }
}
