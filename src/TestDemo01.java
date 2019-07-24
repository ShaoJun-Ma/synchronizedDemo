/**
 * synchronized关键字
 * 锁对象。synchronized(this)和synchronized方法都是锁当前对象。
 */
public class TestDemo01 {
    private int count = 0;
    private Object o = new Object();

    public void testSync1(){
        synchronized (o){
            System.out.println(Thread.currentThread().getName()+"--count:"+count++);
        }
    }
    public void testSync2(){
        synchronized (this){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--count:"+count++);
        }
    }
    public synchronized void testSync3(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"--count:"+count++);
    }
    public static void main(String[] args) {
        final TestDemo01 t = new TestDemo01();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.testSync2();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.testSync1();
            }
        }).start();
    }
}
