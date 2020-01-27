package dao;

import bean.PostBean;
import bean.UserBean;
import db.MyC3P0;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class PostDao {
    private DataSource dataSource;
    private QueryRunner queryRunner;
private BeanHandler<PostBean> bean = new BeanHandler<PostBean>(PostBean.class);
    public PostDao() {
        this.dataSource = MyC3P0.getDataSource();
        queryRunner = new QueryRunner(this.dataSource);
    }
    public int addPost(PostBean post) {
        String sql = "insert into b_post(p_title,p_content,p_datetime)values(?,?,?)";
        int update = 0;
        try {
            update = queryRunner.update(sql, new Object[]{post.getTitle(),post.getContent(),post.getDatetime()});
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(update);
        return update;
    }

    public List<PostBean> selectPostByLimit(Integer start, Integer count) {
        BeanListHandler<PostBean> listHandler = new BeanListHandler<>(PostBean.class);
        String sql = "select p_id as id, p_title as title,p_content as content ,p_datetime as datetime from b_post limit ?, ?";
        List<PostBean> query = null;
        try {
            query = queryRunner.query(sql, listHandler, new Object[]{start, count});
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(query);
        return query;
    }
    public PostBean selectPostById(String id) {
        BeanListHandler<PostBean> listHandler = new BeanListHandler<>(PostBean.class);
        String sql = "select p_id as id, p_title as title,p_content as content ,p_datetime as datetime from b_post where p_id=?";
        PostBean query = null;
        try {
            query = queryRunner.query(sql, bean, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(query);
        return query;
    }

    public int getPostCount() {
        String sql = "select count(*) from b_post";
        int query;
        Object query1 = null;
        try {
             query1= queryRunner.query(sql, new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        query = Integer.parseInt(String.valueOf(query1));
        System.out.println(query);
        return query;
    }
}
