import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку, например, \"Я хороший разработчик автотестов\"");
        String string = scanner.nextLine();

        int i;
        String word;
        do {
            System.out.println("Введите слово, которое следует заменить");
            word = scanner.nextLine();
            i = string.indexOf(word);
            if (i == -1) {
                System.out.println("Такого слова в предложении нет, попробуйте заново");
            }
        } while (i == -1);

        System.out.println("Введите слово,на которое следует заменить слово " + word);
        String wordTo = scanner.nextLine();
        String string2 = string.replaceAll(word, wordTo);

        int j;
        String stringToFind;
        do {
            System.out.println("Какое слово из предложения вывести?");
            stringToFind = scanner.nextLine();
            j = string2.indexOf(stringToFind);
            if (j == -1) {
                System.out.println("Такого слова в предложении нет, попробуйте заново");
            }
        } while (j == -1);
        System.out.println(string);
        System.out.println(string2);
        String string3 = string2.substring(string2.indexOf(stringToFind), string2.indexOf(stringToFind) + stringToFind.length());
        System.out.println(string3);
    }
}
