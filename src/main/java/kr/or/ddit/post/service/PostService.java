package kr.or.ddit.post.service;

import kr.or.ddit.post.dao.IPostDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class PostService implements IPostService {
    private static IPostService ourInstance;
    
    @Resource(name = "postDao")
    private IPostDao dao;

    @Override
    public List<Map> getAllPost(Map data) {
        List<Map> map = dao.getAllPost(data);
        return map;
    }

    @Override
    public int getCntPost(int boardId) {
        int cnt = dao.getCntPost(boardId);
        return cnt;
    }

    @Override
    public Map getPost(int postId) {
        Map data = dao.getPost(postId);
        return data;
    }

    @Override
    public List<Map> getPostCom(int postId) {
        List<Map> postCom = dao.getPostCom(postId);
        return postCom;
    }

    @Override
    public List<Map> getPostFile(int postId) {
        List<Map> postFile = dao.getPostFile(postId);
        return postFile;
    }

    @Override
    public int regCom(Map map) {
        int cnt = dao.regCom(map);
        return cnt;
    }

    @Override
    public int createForm(Map data) {
        int cnt = dao.createForm(data);
        return cnt;
    }

    @Override
    public int setFile(Map fileMap) {
        int cnt = dao.setFile(fileMap);
        return cnt;
    }

    @Override
    public int delPost(Map data) {
        int cnt = dao.delPost(data);
        return cnt;
    }

    @Override
    public int delFile(int fileId) {
        int delCnt = dao.delFile(fileId);
        return delCnt;
    }

    @Override
    public int updatePost(Map data) {
        int upCnt = dao.updatePost(data);
        return upCnt;
    }

    @Override
    public String getFilePath(int fileId) {
        String filePath = dao.getFilePath(fileId);
        return filePath;
    }

    @Override
    public int delCom(int comId) {
        int i = dao.delCom(comId);
        return i;
    }
}
