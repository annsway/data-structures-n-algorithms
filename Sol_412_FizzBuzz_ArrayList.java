// https://leetcode.com/problems/fizz-buzz/

import java.util.ArrayList;
import java.util.List;

public class Sol_412_FizzBuzz_ArrayList {
    class Solution {
        public List<String> fizzBuzz(int n) {

            List<String> output = new ArrayList<String>();

            for(int i=0; i<n; i++){

                int j = i+1;

                if((j%3==0 && j>=3) && (j%5==0 && j>=5)){
                    output.add("FizzBuzz");
                }
                else if(j%3==0 && j>=3){
                    output.add("Fizz");
                }
                else if(j%5==0 && j>=5){
                    output.add("Buzz");
                }
                else {
                    output.add(Integer.toString(j));
                }

            }

            return output;

        }
    }
}
