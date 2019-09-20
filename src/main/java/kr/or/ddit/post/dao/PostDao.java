package kr.or.ddit.post.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository
public class PostDao implements IPostDao {
    private static IPostDao ourInstance;

    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate session;

    private PostDao() {
    }


    @Override
    public List<Map> getAllPost(Map data) {
        return session.selectList("post.getAllPost", data);
    }

    @Override
    public int getCntPost(int boardId) {
        return session.selectOne("post.getCntPost", boardId);
    }

    @Override
    public Map getPost(int postId) {
        return session.selectOne("post.getPost", postId);
    }

    @Override
    public List<Map> getPostCom(int postId) {
        return session.selectList("post.getPostCom", postId);
    }

    @Override
    public List<Map> getPostFile(int postId) {
        return session.selectList("post.getPostFile", postId);
    }

    @Override
    public int regCom(Map data) {
        int cnt = session.insert("post.regCom", data);
        return cnt;
    }

    @Override
    public int createForm(Map data) {
        int cnt = session.insert("post.newPost", data);
        return cnt;
    }

    @Override
    public int setFile(Map fileMap) {
        int cnt = session.insert("post.newFile", fileMap);
        return cnt;
    }

    @Override
    public int delPost(Map data) {
        int postDel = session.update("post.delPost", data);
        return postDel;
    }

    @Override
    public int delFile(int fileId) {
        int delCnt = session.delete("post.delFile", fileId);
        return delCnt;
    }

    @Override
    public int updatePost(Map data) {
        int upCnt = session.update("post.updatePost", data);
        return upCnt;
    }

    @Override
    public String getFilePath(int fileId) {
        String filePath = session.selectOne("post.getFilePath", fileId);
        return filePath;
    }

    @Override
    public int delCom(int comId) {
        int update = session.update("post.delCom", comId);
        return update;
    }

}
