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
import java.util.List;


@WebServlet("/")
public class WelJsp extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostDao postDao = new PostDao();
        String path="/WEB-INF/jsp/index.jsp";
        Integer start = 0;
        Integer count = 8;
        List<PostBean> postBeans = postDao.selectPostByLimit(start,count);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        req.setAttribute("posts",postBeans);
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
