// ref: https://leetcode.com/problems/pascals-triangle/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 

        // row: it's actually the element of the outer list 
        for(int rowNum=0; rowNum<numRows; rowNum++){
            
            List<Integer> row = new ArrayList<>(); 
             
            // column: it's actually the element of the inner list 
            for(int colNum=0; colNum<rowNum+1; colNum++){       
                if(colNum==0 || colNum==rowNum){
                    row.add(1); // assign 1 to the first and last columns 
                } else {
                    // sum up the two columns in the previous row
                    row.add(res.get(rowNum-1).get(colNum-1)+res.get(rowNum-1).get(colNum));
                }    
            }
            res.add(row);
        }
        return res; 
    }
}