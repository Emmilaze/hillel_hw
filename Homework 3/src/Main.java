import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //Task 1
        twoSequences();

        //Task 2
        TheShortestAndTheLongest();

        //Task 3
        differentDigitsInNumber();

        //Task 4
        printSquareMatrix();
    }

    /**
     * ////////////////////////////////////////////////////////////////////////////////////////////////////////////
     * Task 1
     */

    public static void twoSequences() {
        int[] firstArray = new int[]{1, 2, 3, 4, 2, 3, 4, 5, 5};
        int[] secondArray = new int[]{3, 4, 5};
        int numberOfMatches = 0;
        boolean isPreviousNumberMatch = false;
        System.out.println("Task 1");
        for (int i = 0; i < firstArray.length; i++) {
            if (numberOfMatches == secondArray.length) {
                break;
            }
            if (!isPreviousNumberMatch) {
                numberOfMatches = 0;
            }

            for (int j = 0; j < secondArray.length; j++) {
                if (firstArray[i] == secondArray[j]) {
                    numberOfMatches++;
                    isPreviousNumberMatch = true;
                    break;
                } else {
                    isPreviousNumberMatch = false;
                }
            }
        }
        if (numberOfMatches == secondArray.length) {
            System.out.println("The first array has the second array.");
        } else {
            System.out.println("The first array hasn't the second array.");
        }
        System.out.println();
    }

    /**
     * ////////////////////////////////////////////////////////////////////////////////////////////////////////////
     * Task 2
     */

    public static void TheShortestAndTheLongest() {
        int[] array = new int[]{44, 2, 999, 54, 333, 1, 5, 9};

        // Without pain and tears.
        // Arrays.sort(array);

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temporal = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temporal;
                }
            }
        }
        System.out.println("Task 2");
        System.out.print("The shortest number(s) is/are : ");
        for (int i = 0; i < array.length - 1; i++) {
            if (lengthCount(array[i]) == lengthCount(array[i + 1])) {
                System.out.print(array[i] + " ");
            } else {
                System.out.print(array[i]);
                break;
            }
        }

        System.out.println();

        System.out.print("The longest number(s) is/are : ");
        for (int i = array.length - 1; i > 0; i--) {
            if (lengthCount(array[i]) == lengthCount(array[i - 1])) {
                System.out.print(array[i] + " ");
            } else {
                System.out.print(array[i]);
                break;
            }
        }
        System.out.println("\n");
    }

    public static int lengthCount(int number) {
        int count = 0;
        while (number != 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    /**
     * ////////////////////////////////////////////////////////////////////////////////////////////////////////////
     * Task 3
     */

    public static void differentDigitsInNumber() {
        int[] array = new int[]{12344, 23, 12345, 6, 13, 192, 876, 98311};
        System.out.println("Task 3");
        System.out.print("Numbers with all different digits: ");
        for (int i = 0; i < array.length; i++) {
            int[] numbers = new int[10];
            int number = array[i];
            for (int j = 1; j <= lengthCount(array[i]); j++) {
                int lastNumber = number % 10;
                if (numbers[lastNumber] < 1) {
                    numbers[lastNumber]++;
                } else {
                    break;
                }
                if (number / 10 == 0) {
                    System.out.print(array[i] + " ");
                } else {
                    number /= 10;
                }
            }
        }
        System.out.println("\n");
    }

    /**
     * ////////////////////////////////////////////////////////////////////////////////////////////////////////////
     * Task 4
     */

    public static void printSquareMatrix() {
        int matrixSize = 27;
        double numberOfColumns = Math.sqrt(matrixSize);
        if (numberOfColumns % 1 != 0)
            numberOfColumns++;
        int matrixElement = 1;
        System.out.println("Task 4");
        System.out.println("The square matrix:");
        for (int i = 0; i < (int) numberOfColumns; i++) {
            for (int j = 0; j < (int) numberOfColumns; j++) {
                if ((matrixElement <= matrixSize) && matrixElement != 0) {
                    System.out.print(matrixElement + " ");
                    matrixElement++;
                } else {
                    matrixElement = 0;
                    System.out.print(matrixElement + " ");
                }
            }
            System.out.println();
        }
    }
}