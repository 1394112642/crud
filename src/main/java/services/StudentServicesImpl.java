package services;

import entity.Student;
import mapper.StudentMapper;
import mapper.StudentMapperImpl;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentServicesImpl implements StudentServices {
    private StudentMapper studentMapper = new StudentMapperImpl();
    private Connection c = null;

    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Override
    public void addStudent(Student student) {
        try {
            c = JDBCUtil.getConnection();
            c.setAutoCommit(false);
            studentMapper.addStudent(student);
            c.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                c.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            JDBCUtil.close(c, null);
        }
    }

    @Override
    public void removeStudent(String id) {
        try {
            c = JDBCUtil.getConnection();
            c.setAutoCommit(false);
            studentMapper.removeStudent(id);
            c.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                c.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            JDBCUtil.close(c, null);
        }
    }

    @Override
    public void updateStudent(Student student) {
        try {
            c = JDBCUtil.getConnection();
            c.setAutoCommit(false);
            studentMapper.updateStudent(student);
            c.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                c.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            JDBCUtil.close(c, null);
        }
    }
}
