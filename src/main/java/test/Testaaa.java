package test;


import entity.Student;
import mapper.StudentMapper;
import mapper.StudentMapperImpl;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class Testaaa {
    private StudentMapper studentMapper = new StudentMapperImpl();

    @Test
    public void aa() {
        List<Student> all = studentMapper.findAll();
        System.out.println(all);
    }

    @Test
    public void add() {
        Student student = new Student("1", "pig", 22, new Date());
        studentMapper.addStudent(student);
    }

    @Test
    public void update() {
        Student student = new Student("1", "pig", 99, new Date());
        studentMapper.updateStudent(student);
    }

    @Test
    public void del() {
        studentMapper.removeStudent("1");
    }
}
