public class Writer implements Runnable {
    private DataHolder data;
    private String threadName;
    private Thread t;

    Writer(String threadName, DataHolder data){
        this.data = data;
        this.threadName = threadName;
        System.out.println("Creating "+this.threadName+"...");
    }

    public void start() throws InterruptedException {

        System.out.println("Starting "+this.threadName+"...");
        if(t==null){
            t = new Thread(this, threadName);
            t.start();
        }
        run();
    }

    @Override
    public void run() {
        while(data.num < 11){
            data.write();
        }
    }
}
