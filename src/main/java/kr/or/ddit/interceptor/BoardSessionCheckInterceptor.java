package kr.or.ddit.interceptor;

import kr.or.ddit.board.service.IBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public class BoardSessionCheckInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(BoardSessionCheckInterceptor.class);

    @Resource(name = "boardService")
    private IBoardService boardService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        List<Map> boardList = boardService.allBoard();
        session.setAttribute("boardList", boardList);

        return super.preHandle(request, response, handler);
    }

}
