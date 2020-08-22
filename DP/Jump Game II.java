/*
Given an array A of non-negative integers, you are initially positioned at index 0 of the array. A[i] means the maximum jump distance from index i (you can only jump towards the end of the array). Determine the minimum number of jumps you need to reach the end of array. If you can not reach the end of the array, return -1.

Assumptions

The given array is not null and has length of at least 1.
Examples

{3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array)

{2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in this case.
*/
public class Solution {

//    M[i] 的意义: 从index 0 跳到 index i最小需要多少步。
//    induction rule: 看 i 之前的能一步跳到 i的所有index j，取 min(M[j] + 1)作为 M[i]
    public int minJump1(int[] array) {
        int length = array.length;
        int[] M = new int[length];
        M[0] = 0;
        for (int i = 1; i < length; i++) {
            M[i] = -1; // initialize M[i] = -1: unreachable
            for (int j = 0; j < i; j++) { // 对每一个i之前的index j
                if (j + array[j] >= i && M[j] != -1) { 
             // if index j 能一步跳到或跳过 index i &&
             // 从index 0 能跳到 index j, 即index j之前的都不是unreachable
                    if (M[i] == -1 || M[i] > M[j] + 1) { 
                 // if M[i]是第一次被reach || 
                 // 通过 M[j] + 1 有比之前更小的步数
                        M[i] = M[j] + 1; // 则更新 M[i]
                    }
                }
            }
        }
        return M[length - 1];
    }

  // method 2 
  public int minJump2(int[] array) {
    // Write your solution here
    int n = array.length; 
    int[] M = new int[array.length];
    M[n - 1] = 0; 
    // i represents the beginning of a jump 
    for (int i = n - 2; i >= 0; i--) {
      int min_step = -2;
      // j represents the length of a jump
      // i + j represents the end of a jump 
      for (int j = 1; j <= array[i] && (i + j) < n; j++) {
        if(M[i + j] >= 0) {
            min_step = (min_step < 0 ? M[i + j] : Math.min(min_step, M[i + j]));
        }
      }
      M[i] = min_step + 1;
    }
    return M[0];
  }
}
