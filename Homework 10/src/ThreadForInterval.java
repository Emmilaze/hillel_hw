public class ThreadForInterval extends Thread{
    private int firstNumber;
    private int lastNumber;
    private int amount;

    public ThreadForInterval(int firstNumber, int lastNumber, int amount) {
        this.firstNumber = firstNumber;
        this.lastNumber = lastNumber;
        this.amount = amount;
    }

    @Override
    public void run() {
  //      System.out.println("Thread #" + currentThread().getName() + " starts");
        int currentNumber = firstNumber;
        while (currentNumber <= lastNumber){
            if(isSimple(currentNumber)){
                Main.putToArray(currentNumber);
            }
            currentNumber += amount;
        }
//        System.out.println("Thread #" + currentThread().getName() + " finished");
    }

    public boolean isSimple(int number) {
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
