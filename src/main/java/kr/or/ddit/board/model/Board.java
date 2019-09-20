package kr.or.ddit.board.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

public class Board {
    private String boardId;
    private String boardNm;
    private String userId;

    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" )
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private String reg_date;

    private String able;

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getBoardNm() {
        return boardNm;
    }

    public void setBoardNm(String boardNm) {
        this.boardNm = boardNm;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public String getAble() {
        return able;
    }

    public void setAble(String able) {
        this.able = able;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardId='" + boardId + '\'' +
                ", boardNm='" + boardNm + '\'' +
                ", userId='" + userId + '\'' +
                ", reg_date='" + reg_date + '\'' +
                ", able='" + able + '\'' +
                '}';
    }
}
