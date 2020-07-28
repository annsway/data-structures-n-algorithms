/**
Given a matrix of size N x M. For each row the elements are sorted in ascending order, and for each column the elements are also sorted in ascending order. Find the Kth smallest number in it.

Assumptions

the matrix is not null, N > 0 and M > 0
K > 0 and K <= N * M
Examples

{ {1,  3,   5,  7},

  {2,  4,   8,   9},

  {3,  5, 11, 15},

  {6,  8, 13, 18} }

the 5th smallest number is 4
the 8th smallest number is 6
**/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SolBFS {
    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here
        if (matrix == null || k == 0) {
            return 0;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new
                Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if (o1.equals(o2)) {
                            return 0;
                        }
                        return o1 > o2 ? -1 : 1;
                    }
                });

        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;
        int res = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (count < k) {
                    maxHeap.offer(matrix[row][col]);
                    count++;
                } else if (matrix[row][col] < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.offer(matrix[row][col]);
                }
            }
        }

        res = maxHeap.poll();

        return res;
    }

    public static void main(String[] args) {
        SolBFS sol = new SolBFS();
        int[][] arr = {{5,2,1}, {6,3,4}};
        System.out.println(sol.kthSmallest(arr, 2)); // expected: 2
    }
}
