import java.io.*;
import java.util.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        // read file to lines
        String path_name = "1000000 Sales Records.csv";
        List<String> lines = new ArrayList<>();
        try
        {
            Path filePath = new File(path_name).toPath();
            lines = Files.readAllLines(filePath, Charset.defaultCharset());
        } catch(Exception e){
            System.out.println(e);
        }

        // create two threads
        int sz = lines.size();
        int md = sz/2;

        System.out.println("Do you want to proceed with single-threading (S) or multi-threading (M) task? Enter S or M.");
        Scanner scan = new Scanner(System.in);
        String input = scan.next().toLowerCase();

        long startTime, endTime;
        startTime = System.nanoTime();


        if(input.equals("s")){
            Thread t = new Thread( new Tasks(lines,1, sz, false), "T1" );
            t.start();
            t.join();
            endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            System.out.println("Execution time for single-threading in milliseconds: "+timeElapsed/1000000);
            System.out.println("Execution time for single-threading in seconds: "+timeElapsed/1000000000);

        } else if(input.equals("m")){
            Thread t1 = new Thread( new Tasks(lines,1, md, false), "T1" );
            Thread t2 = new Thread( new Tasks(lines, md, sz, true), "T2" );
            t1.start();
            t2.start();

            t1.join();
            t2.join();

            endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            System.out.println("Execution time for multi-threading in milliseconds: "+timeElapsed/1000000);
            System.out.println("Execution time for multi-threading in seconds: "+timeElapsed/1000000000);
        }


        // write data from memory into a file
        FileOutputStream output = new FileOutputStream("1000000 Sales Records.csv", false);
        for (int i=0; i<sz; i++) {
            String line = lines.get(i)+"\n";
            byte line_i_b[]=line.getBytes();
            output.write(line_i_b);
        }
    }



}
