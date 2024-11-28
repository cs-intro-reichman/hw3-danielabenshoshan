// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(-25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
		System.out.println(mod(20,6));   // 20 % 6
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// Replace the following statement with your code
		int counter=0;
		while (counter < x2){
			x1++;
			counter++;
		}
		while (counter > x2){
			x1--;
			counter--;
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
		int counter=0;
		while (counter < x2){
			x1--;
			counter++;
		}
		while (counter > x2){
			x1++;
			counter--;
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// Replace the following statement with your code
		int counter=0;
		int times=0;
		while (counter < x2){
			times=plus(times, x1);
			counter++;
		}
		while (counter > x2){
			times=minus(times, x1);
			counter--;
		}
		return times;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Replace the following statement with your code
		int counter=0;
		int pow=1;
		while (counter < n){
			pow=times(pow, x);
			counter++;
		}
		return pow;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// Replace the following statement with your code
		int counter=0;
		int div=x1;
		boolean flag = false;
		if (div < 0){
			div = times(div, -1);
			if(x2>0){
				flag = true;
			}else{
				x2 = times(x2, -1);
			}
		}else{
			if(x2<0){
				x2 = times(x2, -1);
				flag =true;
			}
		}
		while (div >= x2){
			div=minus(div, x2);
			counter++;
		}
		if (flag){
			counter = times(counter,-1);
		}
		return counter;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// Replace the following statement with your code
		int modulo= div(x1, x2);
		int leftFrom = minus(x1, times(x2,modulo));
		return leftFrom;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// Replace the following statement with your code
		int odd=1;
		int counter=0;
		int NumMinusOdd = minus(x, odd);
		while (0 <= NumMinusOdd) {
			odd = plus(odd, 2);
			NumMinusOdd = minus(NumMinusOdd, odd);
			counter++;	
		}
			return counter;
	}	  	  
}