package CodeAnalysis.spring.service;

import CodeAnalysis.mybatis.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2019-10-26 10:03
 */
//@Service
public class UserService {

    public User getUser() {
        User user = new User();
        user.setId(9);
        user.setName("ccsu");
        user.setAccount(10065);
        return user;
    }
}
