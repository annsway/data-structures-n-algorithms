// swap without a third variable

public class SwapWithoutTemp {
	public static void main(String[] args) {
		int a = 2; 
		int b = 5; 
		System.out.println("a = " + a);
		System.out.println("b = " + b + "\n");

		// swap without a third variable 
		a = a ^ b; // ~ serve as a temp 

		// XOR
		b = a ^ b; 
		a = a ^ b; 

		System.out.println("a = " + a);
		System.out.println("b = " + b + "\n");
		
		/**
		 * Q: Swap a and b without a third variable. a = 2, b = 5.
		 *
		 *         a = 0 1 0 
		 *         b = 1 0 1 
		 *         
		 * a = a ^ b = 1 1 1 // ~ temp 
		 *
		 * b = a ^ b = 0 1 0
		 * a = a ^ b = 1 0 1
		 * */
	}
}