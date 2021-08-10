package CodeAnalysis.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @Tile:
 * @Author: 段晓平
 * @Date 2021/8/9
 * @Description:
 */
@Slf4j
@Component
public class ThreadLocalTest {

    static int num = 0;


    Semaphore semaphore = new Semaphore(1);
    private Random random  = new Random();

    public static void main(String[] args) {


    }
}
