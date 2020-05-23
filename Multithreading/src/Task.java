import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task extends Thread {
    private final double tax = 0.065;
    private List<String> lines;
    private int startIdx;
    private int endIdx;
    private boolean reverse_order;

    public Task(List<String> lines, int startIdx, int endIdx, boolean reverse_order){
        this.lines = lines;
        this.reverse_order = reverse_order;
        if(!this.reverse_order) {
            this.startIdx = startIdx;
            this.endIdx = endIdx;
        } else {
            // to read from end of the file to the middle
            this.startIdx = endIdx-1; // endIdx is the size of lines; to read the last element of an array: size - 1
            this.endIdx = startIdx-1;
        }
    }

    private String processLine(String line) {
        List<String> data = new ArrayList<>(Arrays.asList(line.split(",")));

        double revenueTax = Math.round(Double.parseDouble(data.get(11))*tax*100)/100.0;

        String new_line=null;
        for(int i=0; i<14;i++){
            new_line += data.get(i);
            new_line += ",";
        }

        new_line += "0.065";
        new_line += ",";
        new_line += String.valueOf(revenueTax);

        return new_line;
    }

    @Override
    public void run() {

        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " : Started Task...");

        int i = this.startIdx;
        while (true) {
            // override the ith line in memory
            lines.set(i, processLine(lines.get(i)));

            if(!this.reverse_order) {
                i++;
                if(i>=this.endIdx) break; // keep processing lines till i reached endIdx
            } else {
                i--; // when reading from the end of the file
                if(i<=this.endIdx) break;
            }
            try {
                Thread.currentThread().sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threadName + " : Completed Task");
    }
}
