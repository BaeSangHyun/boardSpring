package kr.or.ddit.post.web;

import kr.or.ddit.config.test.PostControllerTestConfig;
import kr.or.ddit.config.test.PostTestConfig;
import kr.or.ddit.post.dao.IPostDao;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.user.model.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;

import javax.annotation.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PostControllerTest extends PostControllerTestConfig {
    private static final Logger logger = LoggerFactory.getLogger(PostControllerTest.class);

    @Test
    public void postList() throws Exception {
        mockMvc.perform(get("/post/postList"))
                .andExpect(status().isOk())
                .andExpect(view().name("post/postList"));
    }

    @Test
    public void postListJson() throws Exception {
        mockMvc.perform(get("/post/postListJson").param("boardId", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("post/postListAjax"));
    }

    @Test
    public void postDetail() throws Exception {
        mockMvc.perform(get("/post/postDetail").param("postId", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("post/postDetail"));
    }

    @Test
    public void postForm() throws Exception {
        mockMvc.perform(get("/post/postForm")
                .param("postId", "1")
                .param("boardId", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("post/postForm"));
    }

    @Test
    public void postFormReg() throws Exception {
//        InputStream is = new FileInputStream(new File("d:\\dev\\upload\\2019\\08\\5aa42820-56b2-466a-8945-0efaa04ba120.png"));

//        InputStream is = getClass().getClassLoader().getResourceAsStream("brown.png");
        File file = new File("D:\\rangers\\ryan.png");

        InputStream is = new FileInputStream(file);

        MockMultipartFile mockMultipartFile = new MockMultipartFile("files", "ryan.png", "multipart/form-data", is);

        mockMvc.perform(fileUpload("/post/postForm").file(mockMultipartFile).session(session)
                .param("postId", "1")
                .param("boardId", "1")
                .param("cont", "cont")
                .param("title", "jUnsitTest"))
                .andExpect(status().is(302))
                .andExpect(redirectedUrl("/post/postDetail?boardId=1&postId=1"));
    }

    @Test
    public void regCom() throws Exception {
        mockMvc.perform(post("/post/regCom")
                .param("postId", "1")
                .param("boardId", "1")
                .param("userId", "bshn123")
                .param("cont", "testSpringJUnit"))
                .andExpect(status().isOk())
                .andExpect(view().name("jsonView"));
    }

    @Test
    public void delCom() throws Exception {
        mockMvc.perform(post("/post/delCom").session(session)
                .param("comId", "69")
                .param("userId", "bshn123"))
                .andExpect(status().isOk())
                .andExpect(view().name("jsonView"));
    }

    @Test
    public void delPost() throws Exception {

        mockMvc.perform(get("/post/delPost").session(session)
                .param("postId", "43")
                .param("userId", "bshn123")
                .param("boardId", "1"))
                .andExpect(status().is(302))
                .andExpect(redirectedUrl("/post/postList?boardId=1"));
    }

    @Test
    public void delFile() throws Exception {
        mockMvc.perform(post("/post/delFile")
                .param("fileId", "73"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("res"))
                .andExpect(view().name("jsonView"));
    }

    @Test
    public void downFile() throws Exception {
        mockMvc.perform(get("/post/download").contentType(MediaType.APPLICATION_OCTET_STREAM)
                .param("fileId", "77")
                .param("fileNm", "ryan.png"))
                .andExpect(status().is(200))
                .andExpect(view().name("fileDownloadView"));
    }
}