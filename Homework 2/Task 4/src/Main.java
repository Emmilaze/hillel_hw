public class Main {
	
    /**
     * Declare an array with the nth number of random numbers
     * (using the array initializer) and select the largest and smallest number from it.
     */

    public static void main(String[] args) {
        int array[] = new int[]{0, 45, 24, 18, 98, 111, 45, 2, 59, 22};
		
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
		
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
		
        System.out.println("The minimum number from the array: " + min);
        System.out.println("The maximum number from the array: " + max);
    }
}
