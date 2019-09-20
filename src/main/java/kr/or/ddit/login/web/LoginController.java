package kr.or.ddit.login.web;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource(name = "userService")
    private IUserService userService;

    @Resource(name = "boardService")
    private IBoardService boardService;

    @RequestMapping(path = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login/login";
    }

    @RequestMapping(path = "login", method = RequestMethod.POST)
    public String login(@RequestParam HashMap param, HttpServletRequest request, Model model) {

        User user = userService.getUser(param);

        if( user == null )
            return "login/login";
        else {
            HttpSession session = request.getSession();
            session.setAttribute("S_USER", user);

            List<Map> boardList = boardService.allBoard();

        }

        return "redirect:/board/main";
    }

    @RequestMapping(path = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        if (session.getAttribute("S_USER") != null)
            session.removeAttribute("S_USER");
        return "redirect:/login";
    }
}
