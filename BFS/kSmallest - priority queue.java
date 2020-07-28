public class Solution {
  public int[] kSmallest(int[] array, int k) {
    // Write your solution here
    if (array == null || k == 0) {
      return new int[0]; // return [], instead of null
    }
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>( // maxHeap
      k, new Comparator<Integer>() { // anonymous class 
        @Override
        public int compare(Integer o1, Integer o2) {
          if (o1.equals(o2)) { // .equals() to compare values 
            return 0; 
          }
          return o1 > o2 ? -1 : 1;
        }
      }
    );
    int[] res = new int[k];
    int i = 0; 

    while (i < array.length) {
      if (i < k) { // i 为index，k为个数，此时随便往heap里面加东西
        maxHeap.offer(array[i]);
      } else if (array[i] < maxHeap.peek()) {
        maxHeap.poll();
        maxHeap.offer(array[i]);
      }
      i++;
    }

    for (int j = k - 1; j >= 0; j--) { // 给res排序
      res[j] = maxHeap.poll();
    }

    return res; 
  }
}
