package path;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/jsp/post")
public class PostJsp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object loginUser = session.getAttribute("LoginUser");
        String path = null;
        if (loginUser==null){
            path = "/WEB-INF/jsp/msg/nologin.jsp";
        }else {
            path = "/WEB-INF/jsp/post.jsp";
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        req.setAttribute("msg","hello");
        requestDispatcher.forward(req,resp);
        System.out.println("nihao");
    }
}
