
public class Array_Tight_vs_Growth_Strategy {

    public static Integer[] tightStrategy(Integer[] arr, int size){

        Integer[] arr_new = new Integer[arr.length+size];
        for (int i=0; i<arr.length; i++){
            arr_new[i] = arr[i];
        }
        return arr_new;
    }

    public static Integer[] growthStrategy(Integer[] arr){

        Integer[] arr_new = new Integer[arr.length*2];
        for (int i=0; i<arr.length; i++){
            arr_new[i] = arr[i];
        }
        return arr_new;
    }

    public static void main (String[] args){
        Integer[] arr1 = {0};
        Integer[] arr2 = {0};
        int target = 9999;

        ///////////////////////////////////////
        // Tight strategy performance analysis
        ///////////////////////////////////////

        long startTime1 = System.nanoTime();

        for (int i=0; arr1[i]<target; i++){

            // if the last element of the array is occupied, then call tightStrategy to add a constant size of 4
            if(arr1[arr1.length-1]!=null){
//                System.out.println("size before: "+arr1.length);
                arr1 = tightStrategy(arr1, 4);
//                System.out.println("size after: "+arr1.length);

            }

            arr1[i+1] = i+1;

//            System.out.println("newly added elements: "+arr1[i+1]);
        }

        long elapsedTime1 = System.nanoTime() - startTime1; // 1 second = 1000000 nanosecond
        System.out.println("\nTotal execution time for tight strategy is: "
                + elapsedTime1/1000000+" milliseconds (ms). ");

        // validate
        System.out.println("updated arr1: ");
        for (int i=0; i<arr1.length; i++){
            System.out.print(" "+arr1[i]);
        }

        ///////////////////////////////////////
        // Growth strategy performance analysis
        ///////////////////////////////////////
        long startTime2 = System.nanoTime();

        System.out.println("original: "+arr2[0]);
        for (int i=0; arr2[i]<9999; i++){

            if(arr2[arr2.length-1]!=null){
//                System.out.println("size before: "+arr2.length);
                arr2 = growthStrategy(arr2);
//                System.out.println("size after: "+arr2.length);
            }

            arr2[i+1] = i+1;

//            System.out.println("newly added elements: "+arr2[i+1]);
        }

        long elapsedTime2 = System.nanoTime() - startTime2;
        System.out.println("\nTotal execution time for growth strategy is: "
                + elapsedTime2/1000000+" milliseconds (ms). ");

        // validate
        System.out.println("\nUpdated arr2: ");
        for (int i=0; i<arr2.length; i++){
            System.out.print(" "+arr2[i]);
        }
    }


}
