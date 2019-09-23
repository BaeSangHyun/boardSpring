package kr.or.ddit.post.service;

import kr.or.ddit.config.test.PostTestConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

import java.util.*;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PostServiceTest extends PostTestConfig {
    private static final Logger logger = LoggerFactory.getLogger(PostServiceTest.class);

    @Resource(name = "postService")
    private IPostService postService;

    @Test
    public void getAllPost() {
        /***Given***/
        HashMap map = new HashMap();
        map.put("boardId", 1);
        map.put("pageSize", 10);
        map.put("page", 1);

        /***When***/
        List<Map> allPost = postService.getAllPost(map);

        /***Then***/
        assertEquals(10, allPost.size());
        for(Map data : allPost) {
            Set keySet = data.keySet();
            Iterator iterator = keySet.iterator();
            System.out.println("key " + keySet + " : ");
            while (iterator.hasNext()) {
                System.out.print(data.get(iterator.next().toString()) + " ");
            }
            System.out.println();
        }

    }

    @Test
    public void getCntPost() {
        /***Given***/
        int boardId = 1;

        /***When***/
        int cnt = postService.getCntPost(boardId);

        /***Then***/
        assertEquals(42, cnt);
    }

    @Test
    public void getPost() {
        /***Given***/
        int postId = 3;

        /***When***/
        Map data = postService.getPost(postId);

        /***Then***/
        logger.debug("data : {}, {}",data.get("POSTID"), data.get("TITLE"));
    }

    @Test
    public void getPostCom() {
        /***Given***/
        int postId = 1;

        /***When***/
        List<Map> postCom = postService.getPostCom(postId);

        /***Then***/
        assertEquals(9, postCom.size());

    }

    @Test
    public void getPostFile() {
        /***Given***/
        int postId = 1;

        /***When***/
        List<Map> postFile = postService.getPostFile(postId);


        /***Then***/
        assertEquals(3, postFile.size());

    }

    @Test
    public void regCom() {
        /***Given***/
        HashMap data = new HashMap();
        data.put("postId", 1);
        data.put("userId", "bshn123");
        data.put("cont", "테스트댓글입니다");

        /***When***/
        int i = postService.regCom(data);

        /***Then***/
        assertEquals(1, i);

    }

    @Test
    public void createForm() {
        /***Given***/
        Map map = new HashMap();
        map.put("boardId", 1);
        map.put("title", "Testtitle");
        map.put("userId", "bshn123" );
        map.put("cont", "testCont");

        /***When***/
        int form = postService.createForm(map);

        /***Then***/
        assertEquals(1, form);
    }

    @Test
    public void setFile() {
        /***Given***/
        Map map = new HashMap();
        map.put("postId", 1);
        map.put("fileName", "ryan.png");
        map.put("path", "d:\\dev\\upload\\2019\\08\\9427ed80-3894-480a-939e-defww325e9ff78.png");

        /***When***/
        int i = postService.setFile(map);

        /***Then***/
        assertEquals(1, i);
    }

    @Test
    public void delPost() {
        /***Given***/
        Map map = new HashMap();
        map.put("postId", 50);
        map.put("userId", "bshn123");

        /***When***/
        int i = postService.delPost(map);

        /***Then***/
        assertEquals(1, i);
    }

    @Test
    public void delFile() {
        /***Given***/
        int fileId = 42;

        /***When***/
        int i = postService.delFile(fileId);

        /***Then***/
        assertEquals(1, i);
    }

    @Test
    public void updatePost() {
        /***Given***/
        Map map = new HashMap();
        map.put("title", "제목테스트");
        map.put("cont", "내용테스트");
        map.put("postId", 40);

        /***When***/
        int i = postService.updatePost(map);

        /***Then***/
        assertEquals(1, i);
    }

    @Test
    public void getFilePath() {
        /***Given***/
        int fileId = 1;

        /***When***/
        String filePath = postService.getFilePath(fileId);

        /***Then***/
        System.out.println(filePath);
        assertEquals("d:\\dev\\upload\\2019\\08\\2b38b216-c1b3-424b-93db-186cdb62810c.png", filePath);
    }

    @Test
    public void delCom() {
        /***Given***/
        int comId = 8;

        /***When***/
        int i = postService.delCom(comId);

        /***Then***/
        assertEquals(1, i);
    }
}