package basetest;

import org.junit.Test;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2019-10-25 15:08
 */
public class ThreadTest {
    @Test
    public void test() throws InterruptedException {
        Thread thread = new Thread();
        thread.join();
    }
}
