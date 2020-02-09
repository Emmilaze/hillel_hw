public class Main {

    public static void main(String[] args) {
        String string = "One, two, two, three, four, five, eight, one, one, one, one, ten, fourteen";

        StringUtils stringUtils = new StringUtils(string);
        System.out.println(stringUtils.getNumberOfDuplicates());
        System.out.println(stringUtils.changeCharacter(3, 'Q'));
        System.out.println(stringUtils.getFirstLast());
        System.out.println(stringUtils.getAmountOfPunctuationMarks());
    }
}
