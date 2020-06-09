class Solution{

    // Check Goldbach's conjecture:
    // Every even integer greater than 2 can be expressed as the sum of two primes

    public static void main(String[] args) {
        System.out.println(checkGoldbachConj(99999998));
//        System.out.println(isPrimeNumber(11));
    }

    public static boolean isPrimeNumber(int input){
        if(input < 2){
            return false;
        }
        boolean isPrime = true;
        
        // i<sqrt(input) is enough => otherwise will check for repeated pairs in reverse order 
        for(int i=2; i*i<input; i++){
            if(input%i == 0){
//                System.out.println("%: " + input + "/" + i);
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public static boolean checkGoldbachConj(int input){
        if(input<=4 || input%4 != 0){
            System.out.println("Error: please enter an even number greater than 2.");
            return false;
        }

        int b;

        for(int a=2; a<=input/2; a++){
            b = input - a;
            if(isPrimeNumber(a) && isPrimeNumber(b)){
                System.out.println("a is "+a+", b is "+b);
                return true;
            }
        }

        return false;

    }

}