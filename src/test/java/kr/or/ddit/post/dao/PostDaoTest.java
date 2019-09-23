package kr.or.ddit.post.dao;

import kr.or.ddit.config.test.PostTestConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PostDaoTest extends PostTestConfig {
    private static final Logger logger = LoggerFactory.getLogger(PostDaoTest.class);

    @Resource(name = "postDao")
    private IPostDao postDao;

    @Test
    public void getAllPost() {
        /***Given***/
        HashMap map = new HashMap();
        map.put("boardId", 1);
        map.put("pageSize", 10);
        map.put("page", 1);

        /***When***/
        List<Map> allPost = postDao.getAllPost(map);

        /***Then***/
        assertEquals(10, allPost.size());
    }

    @Test
    public void getCntPost() {
        /***Given***/
        int boardId = 1;

        /***When***/
        int cnt = postDao.getCntPost(boardId);

        /***Then***/
        assertEquals(42, cnt);
    }

    @Test
    public void getPost() {
        /***Given***/
        int postId = 1;

        /***When***/
        Map post = postDao.getPost(postId);

        /***Then***/
        logger.debug("data : {}, {}",post.get("POSTID"), post.get("TITLE"));
    }

    @Test
    public void getPostCom() {
        /***Given***/
        int postId = 1;

        /***When***/
        List<Map> postCom = postDao.getPostCom(postId);

        /***Then***/
        assertEquals(9, postCom.size());
    }

    @Test
    public void getPostFile() {
        /***Given***/
        int postId = 1;

        /***When***/
        List<Map> postFile = postDao.getPostFile(postId);

        /***Then***/
        assertEquals(3, postFile.size());

    }

    @Test
    public void regCom() {
        /***Given***/
        HashMap data = new HashMap();
        data.put("postId", 40);
        data.put("userId", "bshn123");
        data.put("cont", "테스트댓글입니다");

        /***When***/
        int i = postDao.regCom(data);

        /***Then***/
        assertEquals(1, i);
    }

    @Test
    public void createForm() {
        /***Given***/
        Map map = new HashMap();
        map.put("boardId", 2);
        map.put("title", "Testtitle");
        map.put("userId", "bshn123" );
        map.put("cont", "testCont");

        /***When***/
        int form = postDao.createForm(map);

        /***Then***/
        assertEquals(1, form);
    }

    @Test
    public void setFile() {
        /***Given***/
        Map map = new HashMap();
        map.put("postId", 46);
        map.put("fileName", "ryan.png");
        map.put("path", "d:\\dev\\upload\\2019\\08\\9427ed80-3894-480a-939e-defww325e9ff78.png");

        /***When***/
        int i = postDao.setFile(map);

        /***Then***/
        assertEquals(1, i);
    }

    @Test
    public void delPost() {
        /***Given***/
        Map map = new HashMap();
        map.put("postId", 40);
        map.put("userId", "bshn123");

        /***When***/
        int i = postDao.delPost(map);

        /***Then***/
        assertEquals(1, i);
    }

    @Test
    public void delFile() {
        /***Given***/
        int fileId = 42;

        /***When***/
        int i = postDao.delFile(fileId);

        /***Then***/
        assertEquals(1, i);
    }

    @Test
    public void updatePost() {
        /***Given***/
        Map map = new HashMap();
        map.put("title", "다오제목테스트");
        map.put("cont", "다오내용테스트");
        map.put("postId", 40);

        /***When***/
        int i = postDao.updatePost(map);

        /***Then***/
        assertEquals(1, i);
    }

    @Test
    public void getFilePath() {
        /***Given***/
        int fileId = 1;

        /***When***/
        String filePath = postDao.getFilePath(fileId);

        /***Then***/
        logger.debug("filePath : {}", filePath);
        assertEquals("d:\\dev\\upload\\2019\\08\\2b38b216-c1b3-424b-93db-186cdb62810c.png", filePath);
    }

    @Test
    public void delCom() {
        /***Given***/
        int comId = 8;

        /***When***/
        int i = postDao.delCom(comId);

        /***Then***/
        assertEquals(1, i);
    }
}