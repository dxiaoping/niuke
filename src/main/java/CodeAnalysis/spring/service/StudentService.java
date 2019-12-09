package CodeAnalysis.spring.service;

import CodeAnalysis.mybatis.pojo.Student;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2019-10-26 11:09
 */
public class StudentService {
    public Student getUser() {
        Student student = new Student();
        student.setSno(10018);
        student.setSname("xiaop");
        return student;
    }
}
