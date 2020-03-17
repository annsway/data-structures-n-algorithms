import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class QueueLinkedList {

    public static void main(String[] args) {

        Queue<String> q = new LinkedList<>();
        ArrayList<String> result = new ArrayList<>();

        // Rule:
        // 1) Take the first element out to a new ArrayList
        // 2) Move the next element to the end of the queue
        // 3) Repeat till the queue becomes empty 
        q.add("Will ");
        q.add("Tonight? ");
        q.add("You ");
        q.add("Dinner ");
        q.add("Go ");
        q.add("Me ");
        q.add("Out ");
        q.add("With ");
        q.add("For ");

        System.out.println("Elements of the queue: "+q);

        while (!q.isEmpty()){
            result.add(q.element());
            q.remove();
            if(!q.isEmpty()){
                q.add(q.element());
                q.remove();
            }
        }

        System.out.println(q);

        System.out.println(result);


    }

}
