import java.io.*;

public class QuickSort {

    public static void main(String[] args) throws IOException{

        System.out.println("How many strings do you want to order?");

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in), 1);

        int i = Integer.parseInt(input.readLine());
        String strArr[] = new String[i];

        for (int j=0; j<= strArr.length-1; j++){
            System.out.println("Enter your string no. "+(j+1));
            String s = input.readLine();
            strArr[j] = s;
        }

        System.out.println("Print the user input array: ");
        for (int x=0; x<=strArr.length-1; x++){
            System.out.println(strArr[x]);
        }

        quickSort(strArr);

        // Print the sorted array 
        System.out.println("Print the alphabetically sorted array: ");

        for(int y=0; y<=strArr.length-1; y++){
            System.out.println(strArr[y]);
        }
    }

    private static void quickSort(String[] inputArr){
        RecursiveQuickSort(inputArr, 0, inputArr.length-1);

    }

    private static void recursiveQuickSort(String[] inputArr, int i, int j){

        int cutIndex = Partition(inputArr, i, j); // get position of index i that divides the whole array

        // Recursively call itself after dividing the array into two parts.
        if (i < cutIndex-1){
            RecursiveQuickSort(inputArr, i, cutIndex-1);
        }
        if (j > cutIndex){
            RecursiveQuickSort(inputArr, cutIndex, j);
        }

    }

    private static int partition(String[] inputArr, int i, int j){

        int pivot = i;

        while(i <= j){

            while(inputArr[i].compareTo(inputArr[pivot]) < 0){
                i++;
            }

            while(inputArr[j].compareTo(inputArr[pivot]) > 0){
                j--;
            }

            // Swap when i and j indexes have not met yet.
            if(i <= j){

                String swap = inputArr[i];
                inputArr[i] = inputArr[j];
                inputArr[j] = swap;

                // If not met yet, move on
                i++;
                j--;

            }

        }

        return i; // get the cut index 

    }


}