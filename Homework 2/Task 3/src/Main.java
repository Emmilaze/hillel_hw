public class Main {
	/**
     * Create an array of the first 20 Fibonacci numbers and display it
     */

    public static void main(String[] args) {

        // 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711

        int number1, number2, number3;
        number1 = number2 = 1;
        System.out.print(number1 + " " + number2 + " ");
        for (int i = 3; i <= 20; i++) {
            number3 = number1 + number2;
            System.out.print(number3 + " ");
            number1 = number2;
            number2 = number3;
        }
    }
}
