public class Main {

    public static void main(String args[]) throws InterruptedException {
        DataHolder data = new DataHolder();
        Writer t1 = new Writer("T1", data);
        Reader t2 = new Reader("T2", data);


        for(int i=0; i<10; i++){
            t1.start();
            t2.start();
        }

    }

}
