public class Main {

    public static void main(String[] args) {
        int firstNumber = 7;
        print(firstNumber);

        int secondNumber = 123456789;
        System.out.println("\n" + calculateSum(secondNumber));
    }

    public static void print(int number) {
        if (number > 0) {
            print(number - 1);
            System.out.println(number);
        }
    }

    public static int calculateSum(int number) {
        return number < 10 ? number : ((number % 10) + calculateSum(number / 10));
    }
}
