import java.io.*;
import java.util.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        // read file to lines
        String path_name = "9 Sales Records.csv";
        List<String> lines = new ArrayList<>();
        try
        {
            Path filePath = new File(path_name).toPath();
            // store all the lines of a file into an arraylist
            lines = Files.readAllLines(filePath, Charset.defaultCharset());
        } catch(Exception e){
            System.out.println(e);
        }

        // get the start and end indexes when processing lines
        int size = lines.size();
        int mid = size/2;

        System.out.println("Do you want to proceed with single-threading (S) or multi-threading (M) task? Enter S or M.");
        Scanner scan = new Scanner(System.in);
        String input = scan.next().toLowerCase();

        // set up the timer
        long startTime, endTime;
        startTime = System.nanoTime();

        if(input.equals("s")){
            Thread t = new Thread( new Task(lines,1, size, false), "T1" );
            t.start();
            t.join();

            // calculate the time elapsed for processing single-threading task
            endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            System.out.println("Execution time for single-threading task in milliseconds: "+timeElapsed/1000000);
            System.out.println("Execution time for single-threading task in seconds: "+timeElapsed/1000000000);

        } else if(input.equals("m")){
            Thread t1 = new Thread( new Task(lines,1, mid, false), "T1" );
            Thread t2 = new Thread( new Task(lines, mid, size, true), "T2" );
            t1.start();
            t2.start();

            t1.join();
            t2.join();

            // calculate the time elapsed for processing multi-threading task
            endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            System.out.println("Execution time for multi-threading task in milliseconds: "+timeElapsed/1000000);
            System.out.println("Execution time for multi-threading task in seconds: "+timeElapsed/1000000000);
        }

        // write data from memory into a file
        FileOutputStream output = new FileOutputStream("9 Sales Records.csv", false);
        for (int i=0; i<size; i++) {
            String line = lines.get(i)+"\n";
            byte line_i_b[]=line.getBytes();
            output.write(line_i_b);
        }
    }
}
