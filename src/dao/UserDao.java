package dao;

import bean.UserBean;
import db.MyC3P0;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.sql.DataSource;
import java.sql.SQLException;

public class UserDao {
    private DataSource dataSource;
    private QueryRunner queryRunner;

    public UserDao() {
        this.dataSource = MyC3P0.getDataSource();
        queryRunner = new QueryRunner(this.dataSource);
    }
    public UserBean getUser(String username){
        BeanHandler<UserBean> bean = new BeanHandler<>(UserBean.class);
        String sql = "select u_name as username, u_passwd as password from b_user where u_name=?";
        UserBean query = null;
        try {
            query = queryRunner.query(sql, bean,username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(query);
        return query;
    }
}
