package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBCUtil {
    //冲表中获取值
    //创建表
    private static Properties p = new Properties();
    //创建线程
    private static ThreadLocal<Connection> t = new ThreadLocal<Connection>();

    static {
        //通过反射的getResourceAsStream（）获取表
        InputStream is = JDBCUtil.class.getResourceAsStream("/sql/mysql.properties");
        try {
            p.load(is);//读取数据
            is.close();//关流
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        if (t.get() == null) {
            //加载驱动
            Class.forName(p.getProperty("driver"));
            //获取连接对象
            Connection c = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
            t.set(c);
        }
        return t.get();
    }

    //关流
    public static void close(Connection c, PreparedStatement p) {
        try {
            if (p != null) p.close();
            if (c != null) c.close();
            t.remove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection c, PreparedStatement p, ResultSet r) {
        try {
            if (r != null) r.close();
            if (p != null) p.close();
            if (c != null) c.close();
            t.remove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
