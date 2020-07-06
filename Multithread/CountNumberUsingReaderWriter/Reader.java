public class Reader extends Thread {
    private DataHolder data;
    private String threadName;
    private Thread t;

    Reader(String threadName, DataHolder data){
        this.data = data;
        this.threadName = threadName;
        System.out.println("Creating "+this.threadName+"...");
        this.start();
    }

    @Override
    public void run() {
        int value;
        for(int i=0; i<10; i++){
            try {
                sleep((int)(Math.random()*1000));
            } catch(InterruptedException e) { }
            value = data.read();
            System.out.println("Reading number: " + value + "\n");
        }
    }

}
