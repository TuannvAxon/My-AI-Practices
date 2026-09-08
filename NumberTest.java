public class NumberTest {
	public static int[] sortOddEven(int[] numbers) {
	    int[] result = new int[numbers.length];
	    int index = 0;

	   
	    for (int number : numbers) {
	        if (number % 2 != 0) {
	            result[index++] = number;
	        }
	    }

	  
	    for (int number : numbers) {
	        if (number % 2 == 0) {
	            result[index++] = number;
	        }
	    }

	    return result;
	}
}
