package CodeAnalysis.threadpool;
/**
 * 普通线程池:ThreadPoolExecutor
 * 定时线程池:SchedulePoolExecutor
 * <p>
 * newSingle
 * newFixed
 */

import CodeAnalysis.mybatis.dao.UserDao;
import CodeAnalysis.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2019-10-20 10:03
 */
public class ThreadPoolTest {

    @Test
    public void basic(){
        System.out.println(Long.MAX_VALUE);
    }

    public static UserDao test() throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);

//        User user = userDao.selectById(1);
//        System.out.println(user);
        return userDao;
    }

    int c = 0;

    @Test
    public void test1ThreadPool() throws InterruptedException, IOException {
        UserDao userDao = this.test();
        Long start = System.currentTimeMillis();
//        final List<User> list = new ArrayList<>();
        final ConcurrentHashMap<Integer, User> map = new ConcurrentHashMap();
        ExecutorService pool = Executors.newFixedThreadPool(4);
//        ExecutorService pool = Executors.newSingleThreadExecutor();
//        ExecutorService pool = Executors.newCachedThreadPool();
//        ExecutorService pool = Executors.newScheduledThreadPool(10);
        // 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        final Random random = new Random();
        Object obj = new Object();
        for (int i = 1; i <= 10000000; i++) {
            final int j = i;
//            pool.execute(()->{});
            pool.execute(
                    new Runnable() {

                        @Override
                        public void run() {
//                    User user = userDao.selectById(j);
//                    list.add(userDao.selectById(j));
//                    System.out.println(Thread.currentThread().getName()+":"+user);
                            synchronized (obj) {
//                                System.out.println(this);
//                        list.add(user);
//                    map.put(j,user);

                                c++;
//                        System.out.println(c++);
                            }
//                            method();
                        }
                    }
//                    run() ->  {list.add(userDao.selectById(j));}
            );
        }
        // 关闭线程池
        pool.shutdown();
        //阻塞当前线程
        pool.awaitTermination(1, TimeUnit.DAYS);
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
//        for (Integer num:list){
//            System.out.println(num);
//        }
//        for (User user:list){
//            System.out.println(user);
//        }
//        System.out.println(list.size());
        System.out.println(map.size());
        System.out.println("c=" + c);
    }

    public synchronized void method() {
        c++;
    }

    @Test
    public void test2Thread() throws InterruptedException, IOException {
        UserDao userDao = this.test();
        Long start = System.currentTimeMillis();
        final List<User> list = new ArrayList<>();
        // 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        final Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            final int j = i;
            Thread thread = new Thread() {
                @Override
                public void run() {
//                   User user = userDao.selectById(j);
//                   list.add(userDao.selectById(j));
//                   System.out.println(Thread.currentThread().getName()+":"+user);
//                   list.add(user);
                    c++;

                }
            };
            thread.start();
            thread.join();
        }
        //阻塞当前线程
//        Thread.currentThread().join();
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(list.size());
        System.out.println("c=" + c);
    }

    @Test
    public void testSchedulePoolExecutor() throws InterruptedException {

        ScheduledExecutorService pool = Executors.newScheduledThreadPool(4);
        pool.schedule(() -> {
            System.out.println("只执行一次：延迟5秒执行");
        }, 5, TimeUnit.SECONDS);

        pool.scheduleAtFixedRate(() -> {
            System.out.println("每3秒执行一次");
        }, 0, 3, TimeUnit.SECONDS);

//        pool.shutdown();
//        阻塞当前线程
        pool.awaitTermination(1, TimeUnit.DAYS);
    }
}

