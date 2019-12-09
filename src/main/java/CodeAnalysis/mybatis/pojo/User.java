package CodeAnalysis.mybatis.pojo;

import CodeAnalysis.spring.service.UserService;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2019-10-19 9:25
 */
public class User {
    private long id;
    private String name;
    private int account;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account=" + account +
                '}';
    }
}
