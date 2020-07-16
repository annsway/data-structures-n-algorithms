public class Solution {
  public int[] kClosest(int[] array, int target, int k) {
    // Write your solution here
    if(array == null || array.length == 0){
      return array; 
    }
    if(k == 0){
      return new int[0];
    }
    int left = largestSmallerOrEqual(array, target);
    int right = left + 1;
    int[] res = new int[k];
    for(int i=0; i<k; i++){
      if(right >= array.length || left >= 0 
          && target - array[left] <=  array[right] - target){
            res[i] = array[left];
            left--;
      } else {
        res[i] = array[right];
        right++;
      }
    }
    return res; 
  }

  private int largestSmallerOrEqual(int[] array, int target){
    int left = 0; 
    int right = array.length - 1; 
    while(left < right - 1){
      int mid = left + (right - left) / 2;
      if(array[mid] <= target){
        left = mid; 
      } else {
        right = mid; 
      }
    }
    // smaller or equal to target
    if(array[right] <= target){
      return right; // returns if target is greater than the greatest number in the array 
    } else if(array[left] <= target) {
      return left; 
    }
    return -1; // returns if target is less than the smallest number in the array 
  }
}
