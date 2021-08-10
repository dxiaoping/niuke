package CodeAnalysis.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2019-10-24 17:02
 */
public class ReentrantLockTest {
    static int i = 0;
    AtomicInteger integer = new AtomicInteger(0);
    Lock lock = new ReentrantLock();
    Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(201);
        ReentrantLockTest lockTest = new ReentrantLockTest();

        for (int j=0; j < 200; j++){
            Thread thread = new Thread(()->{
                lockTest.add();
                latch.countDown();
            });
            thread.start();
        }
//        latch.await();
        latch.await(3, TimeUnit.SECONDS);
        synchronized (lockTest.obj){
            System.out.println("最终结果");
            System.out.println(i);
        }
    }

    private void add() {
         synchronized(obj){
        System.out.println("当前线程："+Thread.currentThread().getName() + "数值："+ ++i);
        }
//        lock.lock();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//            lock.unlock();
        }
    }
}
