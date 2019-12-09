package CodeAnalysis.mybatis.dao;

import CodeAnalysis.mybatis.pojo.User;

public interface UserDao {
    User selectById(long id);
    User selectByName(String name);
}
