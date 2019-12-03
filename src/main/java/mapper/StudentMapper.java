package mapper;

import entity.Student;

import java.util.List;

public interface StudentMapper {
    public List<Student> findAll();//查

    public void addStudent(Student student); //增

    public void removeStudent(String id);//删

    public void updateStudent(Student student);//改
}
