package mapper;

import entity.Student;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class StudentMapperImpl implements StudentMapper {
    private Connection c = null;
    private PreparedStatement p = null;
    private ResultSet r = null;
    private String sql = null;
    List<Student> list = new ArrayList<Student>();

    @Override
    public List<Student> findAll() {
        try {
            c = JDBCUtil.getConnection();
            sql = "select * from student";
            p = c.prepareStatement(sql);
            r = p.executeQuery();
            while (r.next()) {
                Student student = new Student(r.getString(1), r.getString(2), r.getInt(3), r.getDate(4));
                list.add(student);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            JDBCUtil.close(c, p, r);
        }
    }

    @Override
    public void addStudent(Student student) {
        try {
            c = JDBCUtil.getConnection();
            sql = "insert into student(id,name,age,bir) values(?,?,?,?)";
            p = c.prepareStatement(sql);
            p.setString(1, UUID.randomUUID().toString());
            p.setString(2, student.getName());
            p.setInt(3, student.getAge());
            Date bir = student.getBir();
            p.setDate(4, new java.sql.Date(bir.getTime()));
            p.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("添加时异常");
        } finally {
            JDBCUtil.close(null, p);
        }

    }

    @Override
    public void removeStudent(String id) {
        try {
            c = JDBCUtil.getConnection();
            sql = "DELETE from student where id=?";
            p = c.prepareStatement(sql);
            p.setString(1, id);
            p.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("删除时异常");
        } finally {
            JDBCUtil.close(null, p);
        }
    }

    @Override
    public void updateStudent(Student student) {
        try {
            c = JDBCUtil.getConnection();
            sql = "update student set name=?,age=?,bir=? where id=?";
            p = c.prepareStatement(sql);
            p.setString(1, student.getName());
            p.setInt(2, student.getAge());
            p.setDate(3, new java.sql.Date(student.getBir().getTime()));
            p.setString(4, student.getId());
            p.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("修改时异常");
        } finally {
            JDBCUtil.close(null, p);
        }
    }
}
