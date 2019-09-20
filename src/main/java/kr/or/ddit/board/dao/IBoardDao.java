package kr.or.ddit.board.dao;

import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public interface IBoardDao {
    // 게시판 생성
    public int insertBoard(Map map);

    // 모든 게시판 출력
    public List<Map> allBoard();

    public int updateBoard(Map map);
}
