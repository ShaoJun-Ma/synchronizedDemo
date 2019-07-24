/**
 * synchronized关键字
 * 同步方法 - 调用其他同步方法
 * 锁可重入。
 */
public class TestDemo06 {
    public synchronized void m1(){//锁this
        System.out.println("m1 start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
        System.out.println("m1 end");
    }
    public synchronized void m2(){//锁this
        System.out.println("m2 start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2 end");
    }
    public static void main(String[] args) {
        TestDemo06 t = new TestDemo06();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m1();
            }
        }).start();
    }
}
