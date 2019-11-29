public class Main {

    public static void main(String[] args) {
        int[] array;
        try {
            array = new int[Integer.parseInt(args[0])];
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (Math.random() * 9);
                System.out.println(array[i]);
            }
			
			System.out.println("");
			
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter integer.");
        }
    }
}
