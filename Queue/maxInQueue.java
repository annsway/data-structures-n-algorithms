import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int maxInQueue(Queue<Integer> queue) {
        int max = queue.poll();
        while(!queue.isEmpty()){
            if(max < queue.peek()){
                max = queue.peek();
            }
            queue.poll();
        }
        return max;
    }
    
    public static void main(String[] args){

        Queue<Integer> q = new LinkedList<>();
        q.add(5);
        q.add(8);
        q.add(3);
        q.add(2);
        q.add(23);
        System.out.println(maxInQueue(q));
    }
}
