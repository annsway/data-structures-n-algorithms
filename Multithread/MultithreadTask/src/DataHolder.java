import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataHolder {
    int num = 0;
    String flag = null;

    // lock and condition variables
    private final Lock aLock = new ReentrantLock();
    private final Condition bufferNotFull = aLock.newCondition();
    private final Condition bufferNotEmpty = aLock.newCondition();

    void write() {
        System.out.println("You're in the write function");
        aLock.lock();
        try {
            while (flag != null) {
                System.out.println("there: "+num+" flag: "+flag);

                System.out.println(Thread.currentThread().getName()
                        + " : Buffer is full, waiting");
                bufferNotEmpty.await();
            }

            while (flag == null) {
                ++num;
                flag = "full";
                System.out.println("here: "+num+" flag: "+flag);
                bufferNotFull.signalAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            aLock.unlock();
        }
        System.out.println("end of write function\n");

    }

    public void read() {
        System.out.println("You're in the read function");
        aLock.lock();
        try {
            while (flag == null) {
                System.out.println(Thread.currentThread().getName()
                        + " : Buffer is empty, waiting");
                bufferNotFull.await();
            }

            while(flag != null) {
                System.out.println("Printing from reader: " + num+"\n");
                flag = null;
                bufferNotEmpty.signalAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            aLock.unlock();
        }

    }


}
