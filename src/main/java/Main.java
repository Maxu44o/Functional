import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
// не используем состояние
        final List<String> phrases = new LinkedList<>();
//монада
        printDictionary(makeDictionary(getlexicon(phrases)));
    }

    public static List<String> getlexicon(List<String> phrases) {
        System.out.println("Введите фразу для словаря");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (!input.isEmpty()) {
            phrases.add(input);
            //рекурсия
            getlexicon(phrases);
        }
        return phrases;
    }

    //детерминированная функция, без side-effects
    public static List<String> makeDictionary(List<String> phrases) {
        //монада
        return phrases.stream().
                flatMap(s -> Arrays.stream(s.split(" "))).
                distinct().
                sorted().
                collect(Collectors.toList());
    }

    //детермиированная функция
    public static void printDictionary(List<String> wolds) {
        wolds.stream().forEach(System.out::println);
    }

    ;
}
