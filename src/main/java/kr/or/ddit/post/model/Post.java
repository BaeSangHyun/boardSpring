package kr.or.ddit.post.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

public class Post {
    private String postId;
    private String boardId;
    private String pa_postId;
    private String title;
    private String userId;

    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" )
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private String reg_date;

    private String able;
    private String cont;
    private String postGn;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getPa_postId() {
        return pa_postId;
    }

    public void setPa_postId(String pa_postId) {
        this.pa_postId = pa_postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getPostGn() {
        return postGn;
    }

    public void setPostGn(String postGn) {
        this.postGn = postGn;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId='" + postId + '\'' +
                ", boardId='" + boardId + '\'' +
                ", pa_postId='" + pa_postId + '\'' +
                ", title='" + title + '\'' +
                ", userId='" + userId + '\'' +
                ", reg_date='" + reg_date + '\'' +
                ", able='" + able + '\'' +
                ", cont='" + cont + '\'' +
                ", postGn='" + postGn + '\'' +
                '}';
    }
}
