class BubbleSortNMoveZeros {
    public static int[] moveZeroes(int[] nums) {

        for(int i=0; i<nums.length-1; i++){

            for(int j=0; j<nums.length-i-1; j++){

                if( nums[j] == 0){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                } else if (nums[j+1] != 0 && nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }

            }

        }

        return nums;

    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};

        int[] res = moveZeroes(arr);

        System.out.println("Sorted array with zeros moved to the end: ");
        for(int i=0; i<res.length;i++){
            System.out.print(res[i] + " ");
        }

    }
}