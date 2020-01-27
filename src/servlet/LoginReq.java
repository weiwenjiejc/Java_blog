package servlet;

import bean.UserBean;
import dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/req/login")
public class LoginReq extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserDao userDao = new UserDao();
        UserBean user = userDao.getUser(username);
        String path=null;
        if (user!=null){
            if (user.getPassword().equals(password)){
                System.out.println("登录成功");
                HttpSession session = req.getSession();
                session.setAttribute("LoginUser",user);
                path="/WEB-INF/index";
            }else {
                System.out.println("用户密码错误");
                req.setAttribute("msg","用户密码错误");
                path="/WEB-INF/jsp/login.jsp";
            }
        }else{
            System.out.println("用户不存在");
            req.setAttribute("msg","用户不存在");
            path="/WEB-INF/jsp/login.jsp";
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        //req.setAttribute("msg","hello");
        requestDispatcher.forward(req,resp);
        System.out.println("nihao");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
