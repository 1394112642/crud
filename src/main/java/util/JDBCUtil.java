package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBCUtil {
    //����л�ȡֵ
    //������
    private static Properties p = new Properties();
    //�����߳�
    private static ThreadLocal<Connection> t = new ThreadLocal<Connection>();

    static {
        //ͨ�������getResourceAsStream������ȡ��
        InputStream is = JDBCUtil.class.getResourceAsStream("/sql/mysql.properties");
        try {
            p.load(is);//��ȡ����
            is.close();//����
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        if (t.get() == null) {
            //��������
            Class.forName(p.getProperty("driver"));
            //��ȡ���Ӷ���
            Connection c = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
            t.set(c);
        }
        return t.get();
    }

    //����
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
