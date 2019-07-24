/**
 * synchronized关键字
 * 同步方法 - 继承
 * 子类同步方法覆盖父类同步方法。可以指定调用父类的同步方法。
 * 相当于锁的重入。
 */
public class TestDemo07 {
    public synchronized void m(){
        System.out.println("父类 start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("父类 end");
    }

    public static void main(String[] args) {
        new Son().m();
    }
}
class Son extends TestDemo07{
    @Override
    public synchronized void m() {
        System.out.println("son start");
        super.m();
        System.out.println("son end");
    }
}