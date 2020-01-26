package servlet;

import bean.PostBean;
import dao.PostDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/req/list")
public class ListPostReq extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String page = req.getParameter("page");
        PostDao postDao = new PostDao();
        Integer start = (Integer.parseInt(page) - 1) * 5;
        Integer count = 5;
        List<PostBean> postBeans = postDao.selectPostByLimit(start, count);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/list_post.jsp");
        req.setAttribute("posts", postBeans);
        HttpSession session = req.getSession();
        session.setAttribute("currentPage", page);
        count = postDao.getPostCount();
        System.out.println(count);
        int pages = 0;
        int temp = count % 5;
        if (temp == 0)
            pages = count / 5;
        else
            pages = count / 5 + 1;
        System.out.println(pages);
        session.setAttribute("pages", pages);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String test = req.getParameter("test");
        System.out.println(test);
        resp.getWriter().write("msg");
    }
}
