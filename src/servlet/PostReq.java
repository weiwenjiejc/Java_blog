package servlet;

import bean.PostBean;
import dao.PostDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        String p_title = req.getParameter("p_title");
        String p_content = req.getParameter("p_content");
        PostDao postDao = new PostDao();
        PostBean post = new PostBean();
        int rs = postDao.addPost(post);
        PrintWriter writer = resp.getWriter();
        writer.write("success");
    }



}
