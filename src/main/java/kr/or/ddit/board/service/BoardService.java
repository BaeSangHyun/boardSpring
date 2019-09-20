package kr.or.ddit.board.service;

import kr.or.ddit.board.dao.IBoardDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BoardService implements IBoardService {
    @Resource(name = "boardDao")
    private IBoardDao dao;

    private BoardService() {
    }

    @Override
    public int insertBoard(Map map) {
        int cnt = dao.insertBoard(map);
        return cnt;
    }

    @Override
    public List<Map> allBoard() {
        List<Map> boardList = dao.allBoard();
        return boardList;
    }

    @Override
    public int updateBoard(Map map) {
        int cnt = dao.updateBoard(map);
        return cnt;
    }
}
