/**
 * volatile关键字
 * volatile的可见性
 * 通知OS操作系统底层，在CPU计算过程中，都要检查内存中数据的有效性。
 保证最新的内存数据被使用。
 *
 */
public class TestDemo09 {
    volatile boolean b = true;
    void m(){
        System.out.println("start");
        while (b){

        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        TestDemo09 t = new TestDemo09();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.b = false;
    }
}
