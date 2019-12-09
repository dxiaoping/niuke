package CodeAnalysis.mybatis.pojo;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2019-10-22 10:28
 */
public class Student {
    private int sno;
    private String sname;

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", sname='" + sname + '\'' +
                '}';
    }
}
