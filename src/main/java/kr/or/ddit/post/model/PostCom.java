package kr.or.ddit.post.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

public class PostCom {
    private String commId;
    private String postId;
    private String userId;

    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" )
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private String reg_date;

    private String able;
    private String cont;
}
