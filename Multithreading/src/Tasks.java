import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tasks extends Thread {
    private final double tax = 0.065;
    private List<String> lines;
    private int startIdx;
    private int endIdx;
    private boolean reverse_order;

    public Tasks(List<String> lines, int startIdx, int endIdx, boolean reverse_order){
        this.lines = lines;
        this.reverse_order = reverse_order;
        if(!this.reverse_order) {
            this.startIdx = startIdx;
            this.endIdx = endIdx;
        } else {
            this.startIdx = endIdx-1;
            this.endIdx = startIdx-1;
        }
    }

    private String processLine(String line) {
        List<String> data = new ArrayList<>(Arrays.asList(line.split(",")));

        double RevenueWithTax = Math.round(Double.parseDouble(data.get(11))*tax*100)/100.0;

        String new_line=null;
        for(int i=0; i<14;i++){
            new_line += data.get(i);
            new_line += ",";
        }

        new_line += "0.065";
        new_line += ",";
        new_line += String.valueOf(RevenueWithTax);

        return new_line;
    }

    @Override
    public void run() {

        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " : Started Task...");

        int i = this.startIdx;
        while (true) {
            lines.set(i, processLine(lines.get(i)));

            if(!this.reverse_order) {
                i++;
                if(i>=this.endIdx) break;
            } else {
                i--;
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
