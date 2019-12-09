package CodeAnalysis.mybatis.dao;

import CodeAnalysis.mybatis.pojo.Student;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2019-10-22 10:29
 */
public interface StudentDao {
    Student selectBySno(int sno);
    Student selectBySname(String sname);
}
