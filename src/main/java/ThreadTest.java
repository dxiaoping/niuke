public class ThreadTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {

            public void run() {
                System.out.println("线程正在执行");
            }
        });
        Object object = new Object();

    }
}
