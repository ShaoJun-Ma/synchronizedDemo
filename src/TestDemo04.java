/**
 * synchronized
 * 同步方法
 * 同步方法只影响锁定同一个锁对象的同步方法，不影响其他线程调用非线程，也不影响调用其他资源的同步方法
 */
public class TestDemo04 {
    Object o = new Object();

    public synchronized void m1(){//锁当前对象
        System.out.println("public synchronized void m1() start");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("public synchronized void m1() end");
    }

    public void m2(){
        synchronized (this){
            System.out.println("public void m2 start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("public void m2 end");
        }
    }

    public void m3(){
        System.out.println("public void m3() start");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("public void m3() end");
    }

    public static class MyThread implements Runnable{
        int i;
        TestDemo04 t;
        public MyThread(int i,TestDemo04 t){
            this.i = i;
            this.t = t;
        }
        @Override
        public void run() {
            if(i==0){
                t.m1();
            }else if(i>0){
                t.m2();
            }else{
                t.m3();
            }
        }
    }
    public static void main(String[] args) {
        TestDemo04 t = new TestDemo04();
        TestDemo04 t2 = new TestDemo04();
        new Thread(new MyThread(0,t)).start();
        new Thread(new MyThread(1,t2)).start();
        new Thread(new MyThread(-1,t)).start();
    }
}
