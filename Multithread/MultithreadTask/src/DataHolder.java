import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataHolder {
    int num = 0;
    String flag;// = null;

    // lock and condition variables
    private final Lock aLock = new ReentrantLock();
    private final Condition bufferNotFull = aLock.newCondition();
    private final Condition bufferNotEmpty = aLock.newCondition();

    void write() {
        System.out.println("You're in the write function");
        aLock.lock();
        try {
            while (flag != null) {
                System.out.println(Thread.currentThread().getName()
                        + " : Buffer is full, waiting");
                bufferNotEmpty.await();
            }

            while (flag == null) {
                ++num;
                flag = "full";
                //System.out.println("Printing data from writer: " + this.getData());
                bufferNotFull.signalAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            aLock.unlock();
        }
    }

    public String read() {
        System.out.println("You're in the read function");
        aLock.lock();
        try {
            while (flag == null) {
                System.out.println(Thread.currentThread().getName()
                        + " : Buffer is empty, waiting");
                bufferNotFull.await();
            }

            while(flag != null) {
                System.out.println("Printing from reader: " + num);
                flag = null;
                bufferNotEmpty.signalAll();
                return flag;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            aLock.unlock();
        }

        return flag;
    }


}
