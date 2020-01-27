package path;

import bean.PostBean;
import dao.PostDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/onePost")
public class OnePostJsp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");

        PostDao postDao = new PostDao();
        PostBean postBean = postDao.selectPostById(id);
        System.out.println(postBean);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        req.setAttribute("onePost", postBean);
        String path="/WEB-INF/jsp/post/onePost.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        //req.setAttribute("msg","hello");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
