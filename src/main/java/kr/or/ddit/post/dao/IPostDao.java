package kr.or.ddit.post.dao;

import java.util.List;
import java.util.Map;

public interface IPostDao {
    // 모든 게시글 가져오기
    public List<Map> getAllPost(Map data);

    // 게시글 숫자
    public int getCntPost(int boardId);

    public Map getPost(int postId);

    public List<Map> getPostCom(int postId);

    public List<Map> getPostFile(int postId);

    public int regCom(Map data);

    public int createForm(Map data);

    public int setFile(Map fileMap);

    public int delPost(Map data);

    public int delFile(int fileId);

    public int updatePost(Map data);

    public String getFilePath(int fileId);

    public int delCom(int comId);
}
