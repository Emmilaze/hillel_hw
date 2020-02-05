public class Main {

    public static void main(String[] args) {
        String infix = "20 * (50 * (3 + 6)) / 300 - 2";
        Converter converter = new Converter();
        String postfix = converter.infixToPostFix(infix);
        System.out.println("Postfix: " + postfix);
        System.out.println("Value = " + converter.convert(postfix));
    }
}
