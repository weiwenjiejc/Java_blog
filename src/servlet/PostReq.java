package servlet;

import bean.PostBean;
import dao.PostDao;
import utils.GetTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/req/post")
public class PostReq extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Map<String, String[]> parameterMap = req.getParameterMap();
//        for (Map.Entry<String,String[]> entry:parameterMap.entrySet()){
//            System.out.println("nihao:");
//            System.out.println(entry.getKey());
//            String[] value = entry.getValue();
//            for (String x:value){
//                System.out.println(x);
//            }
//        }
        req.setCharacterEncoding("utf-8");
        String p_title = req.getParameter("p_title");
        String p_content = req.getParameter("p_content");
        PostDao postDao = new PostDao();
        PostBean post = new PostBean();
        post.setTitle(p_title);
        post.setContent(p_content);

        post.setDatetime(GetTime.getDateTime());
        System.out.println(post);
        int rs = postDao.addPost(post);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        String path="/WEB-INF/jsp/post_msg.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        //req.setAttribute("msg","hello");
        requestDispatcher.forward(req,resp);
    }



}
