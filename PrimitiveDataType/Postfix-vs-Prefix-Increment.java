class Solution{

    public static void main(String[] args) {
        //Postfix increment: x++
        int x = 4;
        int y = x++; // y = 4
        System.out.println("y is "+ y); // y = 4
        // equivalent to
        int y1 = x;
        x = x + 1;


        //Prefix increment: ++x
        int a = 4;
        int b = ++a;
        System.out.println("b is "+b); // b = 5
        // equivalent to
        a = a + 1;
        int b1 = a;

    }

}