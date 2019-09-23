package kr.or.ddit.post.web;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.user.model.User;
import kr.or.ddit.util.FileInfo;
import kr.or.ddit.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("post")
@Controller
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Resource(name = "postService")
    private IPostService postService;

    @RequestMapping("postList")
    public String postList() {
        return "post/postList";
    }

    @RequestMapping(path = "postListJson", method = RequestMethod.GET)
    public String postListJson(@RequestParam(name = "page", defaultValue = "1") int page,
                               @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                               int boardId,
                               Model model) {
        HashMap data = new HashMap();
        data.put("page", page);
        data.put("pageSize", pageSize);
        data.put("boardId", boardId);

        // 리스트 목록
        List<Map> allPost = postService.getAllPost(data);
        model.addAttribute("allPost", allPost);

        // 페이지 정보
        Page pageVo = new Page(page, pageSize);
        model.addAttribute("pageVo", pageVo);

        // 총페이지
        int totalCnt = postService.getCntPost(boardId);
        model.addAttribute("paginationSize", (int)Math.ceil((double) totalCnt / pageSize));

        return "post/postListAjax";
    }

    @RequestMapping(path = "postDetail", method = RequestMethod.GET)
    public String postDetail(@RequestParam Map data, Model model) {
        int postId = Integer.parseInt(String.valueOf(data.get("postId")));

        Map post = postService.getPost(postId);
        model.addAttribute("post", post);

        List<Map> postCom = postService.getPostCom(postId);
        model.addAttribute("postCom", postCom);

        List<Map> postFile = postService.getPostFile(postId);
        model.addAttribute("postFile", postFile);

        return "post/postDetail";
    }

    @RequestMapping(path = "postForm", method = RequestMethod.GET)
    public String postForm(String postId, String boardId, String parentId, Model model) {
        if (postId != null) {
            Map post = postService.getPost(Integer.parseInt(postId));
            List<Map> postFile = postService.getPostFile(Integer.parseInt(postId));

            model.addAttribute("post", post);
            model.addAttribute("postFile", postFile);
        } else {
            model.addAttribute("pa_postId", parentId);
        }

        return "post/postForm";
    }

    @RequestMapping(path = "postForm", method = RequestMethod.POST)
    public String postFormReg(@RequestParam Map data, @RequestPart("files") List<MultipartFile> files, Model model, HttpSession session) {
        logger.debug("data: {}", data);
        User user = (User) session.getAttribute("S_USER");
        data.put("userId", user.getUserId());
        if (data.get("postId") == null || data.get("postId").equals("")) {
            int postNum = postService.createForm(data);
            logger.debug("postId : {}", data.get("postId"));
        } else {
            postService.updatePost(data);
        }

        // 파일 업로드
        for (MultipartFile file : files) {
            logger.debug("file : {}, {}", file.getName(), file.getOriginalFilename());
            if(file.getSize() > 0) {
                FileInfo fileInfo = FileUtil.getFileInfo(file.getOriginalFilename());

                try {
                    file.transferTo(fileInfo.getFile());

                    HashMap fileData = new HashMap();
                    fileData.put("fileName", fileInfo.getOriginalFileName());
                    fileData.put("path", fileInfo.getFile().getPath());
                    fileData.put("postId", data.get("postId"));

                    postService.setFile(fileData);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return "redirect:/post/postDetail?boardId=" + data.get("boardId") + "&postId=" + data.get("postId");
    }

    @RequestMapping(path = "regCom", method = RequestMethod.POST)
    public String regCom(@RequestParam Map data, Model model) {
        int i = postService.regCom(data);
        if (i == 0) return "redirect:/post/postList";

        List<Map> postCom = postService.getPostCom(Integer.parseInt(String.valueOf(data.get("postId"))));
        model.addAllAttributes(postCom);
        return "jsonView";
    }

    @RequestMapping(path = "delCom", method = RequestMethod.POST)
    public String delCom(int comId, String userId, Model model, HttpSession session) {
        if (((User)session.getAttribute("S_USER")).getUserId().equals(userId)) {
            int delCnt = postService.delCom(comId);
            if (delCnt == 1) {
                model.addAttribute("res", "삭제 성공");
            }
        }
        return "jsonView";
    }

    @RequestMapping(path = "delPost", method = RequestMethod.GET)
    public String delPost(@RequestParam Map data, HttpSession session) {
        User user = (User) session.getAttribute("S_USER");
        data.put("userId", user.getUserId());
        int cnt = postService.delPost(data);
        if (cnt == 0)
            return null;
        else
            return "redirect:/post/postList?boardId=" + data.get("boardId");
    }

    @RequestMapping(path = "delFile", method = RequestMethod.POST)
    public String delFile(String fileId, Model model) {
        if (fileId == null) return null;
        else {
            int delCnt = postService.delFile(Integer.parseInt(fileId));
            if( delCnt == 1 ) {
                model.addAttribute("res", "삭제 성공");
            }
        }
        return "jsonView";
    }

    @RequestMapping(path = "download", method = RequestMethod.GET)
    public String downFile(String fileId, String fileNm, Model model) {
        String filePath = postService.getFilePath(Integer.parseInt(fileId));
        model.addAttribute("fileNm", fileNm);
        model.addAttribute("filePath", filePath);
        return "fileDownloadView";
    }
}
