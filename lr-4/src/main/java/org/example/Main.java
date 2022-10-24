import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;


public class Main {

    private static void findWords(String string) {
        // ділимо стрінг "сплітом" через " " та зберігаємо у "words"
        String[] words = string.split(" ");
        System.out.println("Знайдені слова:");
        for (int i = 0; i < words.length; i++) {
            //виводимо слова поки вони є через Enter;
            if (words[i].length() == 4) {
                System.out.println(words[i]);
            }
        }
    }

    private static void LatinToCyr() {
        
        System.out.println("Введіть ваше слово:");
        Scanner in = new Scanner(System.in);
        String slovo = in.nextLine();

        slovo = slovo.replaceAll("a", "а");
        slovo = slovo.replaceAll("b", "б");
        slovo = slovo.replaceAll("c", "(ц|с)");
        slovo = slovo.replaceAll("d", "д");

        if (slovo.endsWith("e")) {
            slovo = slovo.replace("e", "");
        }
        else slovo = slovo.replaceAll("e", "(и|э)");

        slovo = slovo.replaceAll("f", "ф");
        slovo = slovo.replaceAll("g", "г");
        slovo = slovo.replaceAll("h", "х");
        slovo = slovo.replaceAll("i", "(и|ай)");
        slovo = slovo.replaceAll("j", "дж");
        slovo = slovo.replaceAll("k", "к");
        slovo = slovo.replaceAll("l", "л");
        slovo = slovo.replaceAll("m", "м");
        slovo = slovo.replaceAll("n", "н");
        slovo = slovo.replaceAll("o", "о");
        slovo = slovo.replaceAll("p", "п");
        slovo = slovo.replaceAll("q", "кв");
        slovo = slovo.replaceAll("r", "р");
        slovo = slovo.replaceAll("s", "с");
        slovo = slovo.replaceAll("t", "т");
        slovo = slovo.replaceAll("u", "(у|ю)");
        slovo = slovo.replaceAll("v|w", "в");
        slovo = slovo.replaceAll("x", "кс");
        slovo = slovo.replaceAll("y", "(ай|й)");
        slovo = slovo.replaceAll("z", "з");

        System.out.println(slovo);
    }

    private static void LatinWords() {


        System.out.println("Введіть ваші слова:");
        Scanner in = new Scanner(System.in);
        String words = in.nextLine();

        // compile(String) метод класу Pattern'у використовується,
        // щоб створити патерн звичайного виразу, який передається як параметр у метод;
        Matcher matcher = Pattern.compile("[A-Za-z]+").matcher(words);

        int counter = 0;
        // коли матчер знаходить слово латиною,
        while (matcher.find() ) {
            counter++; // збільшуємо каунтер;
            words = matcher.group();
        }
        if (counter == 0) {
            System.out.println("Нема слів латиною!");
        } else {
            System.out.println("Знайдено слів латиною: " + counter);
        }
    }

    private static void OnlyNumbers() {


        System.out.println("Введіть ваші слова:");
        Scanner in = new Scanner(System.in);
        String words = in.nextLine();

        // compile(String) метод класу Pattern'у використовується,
        // щоб створити патерн звичайного виразу, який передається як параметр у метод;
        Matcher matcher = Pattern.compile("\\b\\d+\\b").matcher(words);

        int counter = 0;
        // коли матчер знаходить слово із цифр,
        while (matcher.find() ) {
            counter++; // збільшуємо каунтер;

        }
        if (counter == 0) {
            System.out.println("Нема слів із цифр!");
        } else {
            System.out.println("Знайдено слів із цифр: " + counter);
        }
    }

    private static void OnlyPalyndromeNumbers() {
        System.out.println("Введіть ваші слова:");
        Scanner in = new Scanner(System.in);
        String words = in.nextLine();
        String[] sliced = words.split("\s");

        int counter = 0;

        for (int i = 0; i < sliced.length;i++) {
            // compile(String) метод класу Pattern'у використовується,
            // щоб створити патерн звичайного виразу, який передається як параметр у метод;
            Matcher matcher = Pattern.compile("\\b\\d+\\b").matcher(sliced[i]);
            // коли матчер знаходить слово із цифр,
            while (matcher.find() ) {
                // якщо наше слово - паліндром,
                if (WordIsPalindrome(sliced[i]))
                counter++; // збільшуємо каунтер;
            }
        }
        if (counter == 0) {
            System.out.println("Нема слів паліндромів із цифр!");
        } else {
            System.out.println("Знайдено слів паліндромів із цифр: " + counter);
        }
    }

    public static boolean WordIsPalindrome(String string) {
        int left = 0, right = string.length() - 1;

        while(left < right)
        {
            if(string.charAt(left) != string.charAt(right))
            {return false;}

            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println("№1 Введіть слова:");
        String userPhrase1 = new Scanner(System.in).nextLine();
        findWords(userPhrase1);

        System.out.println('\n' + "№2:");
        LatinToCyr();

        System.out.println('\n' + "№3:");
        LatinWords ();

        System.out.println('\n' + "№4:");
        OnlyNumbers();

        System.out.println('\n' + "№5:");
        OnlyPalyndromeNumbers();
    }
}


