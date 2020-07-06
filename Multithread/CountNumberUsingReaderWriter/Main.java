public class Main {

    public static void main(String args[]) throws InterruptedException {
        DataHolder data = new DataHolder();
        Writer t1 = new Writer("WRITER Thread", data);
        Reader t2 = new Reader("READER Thread", data);

    }

}
