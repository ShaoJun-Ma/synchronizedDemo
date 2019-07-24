/**
 * synchronized关键字
 * 同步方法 - 锁与异常
 * 当同步方法中发生异常的时候，自动释放锁资源。不会影响其他线程的执行。
 * 注意，同步业务逻辑中，如果发生异常如何处理。
 */
public class TestDemo08 {
    int i = 0;
    synchronized void m(){
        System.out.println(Thread.currentThread().getName()+"--start");
        while(true){
            i++;
            System.out.println(Thread.currentThread().getName()+"-"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i==5){
                    i = i/0;
            }
        }
    }
    public static void main(String[] args) {
        TestDemo08 t = new TestDemo08();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        },"t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        },"t2").start();
    }
}
