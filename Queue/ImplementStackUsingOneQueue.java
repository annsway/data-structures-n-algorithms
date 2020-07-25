public class StackByOneQueue {
    private Queue<Integer> q;

    public StackByOneQueue() {
        q = new ArrayDeque<>();
    }

    public void push (int x) {
        q.offer(x);
    }

    public Integer pop() {
        if (q.isEmpty()) {
            return null;
        }
        int size = q.size() - 1;
        while (size != 0) { // 将queue最后一个元素推到最前面，所以只循环 q.size() - 1 次
            q.offer(q.poll());
            size--;
        }
        return q.poll();
    }

    public Integer top() {
        if (q.isEmpty()) {
            return null;
        }
        int ret = pop();
        q.offer(ret);
        return ret;
    }

    public boolean isEmpty(){
        return q.isEmpty();
    }

    public static void main(String[] args) {
        StackByOneQueue q = new StackByOneQueue();

        q.push(2);
        q.push(3);
        q.push(0);
        q.push(0);
        q.push(5);

        System.out.println(q.pop());
//        System.out.println(q.pop());
//        System.out.println(q.pop());
//
//        System.out.println(q.top());

    }
}