package basetest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class BaseTest {


//    {
//        System.out.println("类代码块"+num);
//        num=3;
//    }

    @Test
    public void coreCountTest(){
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    @Test
    public void finalTest(){
        Obj obj1 = new Obj(5);
        final Obj obj2 = obj1;
        obj1.setVal(8);
        System.out.println(obj2.getVal());
    }
    static {
        num = 2;
        System.out.println("静态代码块");
    }
    public static int num = 1;



    public static void main(String[] args) {

//        int a[] = {1,2,4,7,3,5,6,8};
//        int d[] = {4,7,2,1,5,3,8,6};
//        int b[] = Arrays.copyOfRange(a,3+1,a.length);
//        int c[] = Arrays.copyOfRange(d,3+1,d.length);
//        System.out.println(b.length);
//        System.out.println(c.length);
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));
//        System.out.println(Arrays.toString(c));
//        BaseTest test = new BaseTest();

        ArrayList<Integer> a = new ArrayList<Integer>();
        System.out.println(BaseTest.num);
    }
}

class Obj{
    public Obj(int val) {
        this.val = val;
    }

    private int val;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}