public class Solution {
  public long power(int a, int b) {
    // Write your solution here
    if(a == 0 || b == 0){
      return 1;
    }
    long half = power(a, b/2);
    if(b % 2 == 0){
      return half*half; 
    } else {
      return half*half*a;
    }
  }
}


/**

TC:

b = 1000 = (b/2^0)
|
b = 500 = (b/2^1)
|
b = 250 = (b/2^2)
|
...
|
b = 0 = (b/2^L)

b / 2^L = 1

L (Level of Recursion Tree) = log(2, b)

**/