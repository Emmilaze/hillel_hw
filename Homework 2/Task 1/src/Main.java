public class Main {
	
	 /**
     * Declare an array with the nth number of random numbers
     * (using the array initializer) and select even and odd numbers from it.
     */

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println("Even numbers: ");
        for (int i = 0; i < array.length; i++) {
            if ((array[i] % 2) == 0) {
                System.out.print(array[i] + " ");
            }
        }

        System.out.println();
        System.out.println("Odd numbers: ");
        for (int i = 0; i < array.length; i++) {
            if ((array[i] % 2) != 0) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
