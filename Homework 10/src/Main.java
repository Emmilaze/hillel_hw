import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] array = new int[0];

    public static void main(String[] args) {
        System.out.println("Please, print the first number");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int fistNumber = 0;
        try {
            fistNumber = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("Please enter the integer!");
            System.exit(0);
        }
        if (fistNumber <= 1) {
            fistNumber = 2;
        }
        System.out.println("Please, print the last number");
        int lastNumber = 0;
        try {
            lastNumber = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("Please enter the integer!");
            System.exit(0);
        }
        System.out.println("Please, enter the amount of thread");
        int threads = 0;
        try {
            threads = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("Please enter the integer!");
            System.exit(0);
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Thread[] threadsArray = new Thread[threads];

        for (int i = 0; i < threads; i++) {
            ThreadForInterval thread = new ThreadForInterval(fistNumber + i, lastNumber, threads);
            threadsArray[i] = thread;
            thread.start();
        }
 //       long startTime = System.nanoTime();
        for(int i = 0; i < threadsArray.length; i++){
            try {
                threadsArray[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(int i = 0; i < array.length; i++){
            System.out.println(array[i] + " ");
        }
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime);
//        System.out.println(duration/1000000);
    }

    public static synchronized void putToArray(int number){
        array = increaseMassive(number);
    }

    public static int[] increaseMassive(int number) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = number;
        return newArray;
    }
}
