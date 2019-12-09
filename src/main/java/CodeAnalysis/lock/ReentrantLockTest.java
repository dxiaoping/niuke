package CodeAnalysis.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2019-10-24 17:02
 */
public class ReentrantLockTest {
    static int i = 0;
    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest lockTest = new ReentrantLockTest();

        for (int j=0; j < 2; j++){
            new Thread(()->{
                lockTest.add();
            }).start();
            Thread.sleep(200);
            System.out.println(i);
        }


    }

    private void add(){
        try {
//            lock.lock();
            lock.lock();
            System.out.println("当前线程："+Thread.currentThread().getName());
            i++;
        }finally {
            lock.unlock();
//            lock.unlock();
        }
    }
}
