public class Writer extends Thread {
    private DataHolder data;
    private String threadName;
    private Thread t;

    Writer(String threadName, DataHolder data){
        this.data = data;
        this.threadName = threadName;
        System.out.println("Creating "+this.threadName+"...");
        this.start();

    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            try {
                sleep((int)(Math.random()*1000));
            } catch(InterruptedException e) { }

            System.out.println("Updating number to: " + (i+1));
            data.write(i+1);

        }
    }
}
