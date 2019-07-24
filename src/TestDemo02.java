/**
 * synchronized
 * 同步方法-static
 * 静态同步方法，锁的是当前类型的类对象。在本代码中就是TestDemo02.class
 */

public class TestDemo02 {
    private static int staticCount = 0;


    public static synchronized void testSy4(){//锁的是TestDemo02这个类对象
        System.out.println(Thread.currentThread().getName()+"--staticCount:"+staticCount++);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testSy5(){
        synchronized (TestDemo02.class){
            System.out.println(Thread.currentThread().getName()+"--staticCount:"+staticCount++);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestDemo02 t = new TestDemo02();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.testSy4();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                t.testSy5();
            }
        }).start();
    }

}
