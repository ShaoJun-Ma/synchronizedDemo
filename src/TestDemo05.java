/**
 * synchronized关键字
 * 同步方法 - 多方法调用原子性问题（业务）
 * 同步方法只能保证当前方法的原子性，不能保证多个业务方法之间的互相访问的原子性。
 * 注意在商业开发中，多方法要求结果访问原子操作，需要多个方法都加锁，且锁定统一个资源。
 * <p>
 * 一般来说，商业项目中，不考虑业务逻辑上的脏读问题。
 */
public class TestDemo05 {
    private double d = 0.0;

    public synchronized void m1(double d) {
        try {
            //相当于复杂的业务了逻辑代码
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.d = d;//set
    }

    public double m2() {
        return this.d;//get
    }

    public static void main(String[] args) {
        TestDemo05 t = new TestDemo05();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m1(100);
            }
        }).start();
        System.out.println(t.m2());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.m2());
    }
}
