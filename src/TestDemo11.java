import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicXxx
 * 同步类型
 * AtomicXxx原子操作类型。 其中的每个方法都是原子操作。可以保证线程安全。
 */
public class TestDemo11 {
    AtomicInteger count = new AtomicInteger(0);
    /*synchronized*/ void m(){
        for (int i = 0; i <1000 ; i++) {
            count.incrementAndGet();//相当于count++
        }
    }
    public static void main(String[] args) {
        TestDemo11 t = new TestDemo11();
        List<Thread> threads = new ArrayList<>();
        for(int i = 0;i<10;i++){
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    t.m();
                }
            }));
        }
        for (Thread thread:threads){
            thread.start();
        }
//        for(Thread thread:threads){
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.count.intValue());
    }
}
