
public class DataHolder {
    int num = 0;
    boolean dataUpdated = false;

    public synchronized void write(int num) {
        while(dataUpdated){
//            System.out.println("You're in the write function");
            try{
                wait();
            } catch(InterruptedException e){}
            notify();
        }

        this.num = num; // update the num
        dataUpdated = true;
        notify();
//        System.out.println("end of write function\n");
    }

    public synchronized int read() {
        while(!dataUpdated){
            notify();
            try{
                wait();
            } catch(InterruptedException e) {}
        }
        int temp = this.num;
        dataUpdated = false;
        notify();
//        System.out.println("end of read function\n");

        return temp;
    }


}
