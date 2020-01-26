package test;

import bean.UserBean;
import dao.UserDao;
import db.MyC3P0;

import javax.sql.DataSource;

public class Test {
    public static void main(String[] args) {
        DataSource dataSource = MyC3P0.getDataSource();
        UserDao dao = new UserDao();
        UserBean wwj = dao.getUser("wwj");
        System.out.println(wwj);
    }
}
