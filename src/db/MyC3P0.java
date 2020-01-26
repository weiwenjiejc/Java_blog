package db;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class MyC3P0 {
    private static ComboPooledDataSource c3p0 = new ComboPooledDataSource();

    static {
//        try {
//            c3p0.setDriverClass("com.mysql.jdbc.Driver"); //loads the jdbc driver
//        } catch (PropertyVetoException e) {
//            e.printStackTrace();
//        }
//        c3p0.setJdbcUrl("jdbc:mysql://47.106.206.150:3306/w_blog?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8");
//        c3p0.setUser("wwj");
//        c3p0.setPassword("toor");
//        c3p0.setInitialPoolSize(5);
//        c3p0.setMinPoolSize(5);
//        c3p0.setAcquireIncrement(5);
//        c3p0.setMaxPoolSize(20);
    }
    public static DataSource getDataSource(){
        return c3p0;
    }
}
