package kr.or.ddit.board.web;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.user.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RequestMapping("board")
@Controller
public class BoardController {
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Resource(name = "boardService")
    private IBoardService boardService;

    @RequestMapping(path = "main", method = RequestMethod.GET)
    public String boardMain() {
        return "main";
    }

    @RequestMapping(path = "manage", method = RequestMethod.GET)
    public String boardManage() {
        return "board/boardManage";
    }

    @RequestMapping(path = "createBoard", method = RequestMethod.POST)
    public String createBoard(@RequestParam HashMap data, HttpSession session) {
        User user = (User) session.getAttribute("S_USER");
        data.put("userId", user.getUserId());

        boardService.insertBoard(data);

        return "redirect:/board/manage";
    }

    @RequestMapping(path = "modifyBoard", method = RequestMethod.POST)
    public String modifyBoard(@RequestParam HashMap data, HttpSession session) {
        boardService.updateBoard(data);

        return "redirect:/board/manage";
    }
}
