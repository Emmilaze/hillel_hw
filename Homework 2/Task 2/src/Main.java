public class Main {
	
	/**
	* Declare an array with the nth number of random numbers 
	* (using the array initializer) and select primes from it.
	*/

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 17, 19, 23, 29, 37, 41, 153, 133, 122, 188, 26, 88, 77, 121, 93};
        System.out.println("Simple numbers: ");
        for (int i = 0; i < array.length; i++) {
            if (isSimple(array[i])) {
                System.out.print(array[i] + " ");
            }
        }
    }

    public static boolean isSimple(int number) {
        boolean check = true;
        if (number == 1)
            check = false;
        for (int j = 2; j <= (number / j); j++) {
            if ((number % j) == 0) {
                check = false;
            }
        }
        return check;
    }
}
