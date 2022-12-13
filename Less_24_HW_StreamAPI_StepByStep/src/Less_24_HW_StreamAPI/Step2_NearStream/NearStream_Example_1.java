package Less_24_HW_StreamAPI.Step2_NearStream;
/*
Немного повторим предыдущий урок с Lambda
и поглядим на то, как плодятся однотипные
методы. Конечно это грубая имитация, но для
понимания происходящего достаточно - коллекция
за коллекцией, метод за методом...
*/
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class NearStream_Example_1 {
    public static void main(String[] args) {
        // Создаем коллекцию и заполняем ее
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add((int) (Math.random() * 1000));
        }
        System.out.println("------------------ Только четные элементы ------------------");
        List<Integer> onlyEven = filterForIntegerCollection(numbers, number -> (int) number % 2 == 0);
        onlyEven.forEach(n -> System.out.print(n + " "));
        System.out.println("\n------------------ int преобразован в String ------------------");
        List<String> strList = mapIntegerToString(onlyEven);
        strList.forEach(System.out::println);
        System.out.println("------------------ Только элементы с нулем на конце ------------------");
        List<String> onlyZeroWithEnd = filterForStringCollection(strList, str -> ((String) str).endsWith("0"));
        onlyZeroWithEnd.forEach(n -> System.out.println(n));
        System.out.println("------------------ Добавим '!' в конце каждого элемента коллекции ------------------");
        List<String> finalCollection = mapStringToString(onlyZeroWithEnd);
        finalCollection.forEach(System.out::println);

    }
    // Метод преобразующий одну коллекцию в другую (в данном случае Integer -> String)
    private static List<String> mapIntegerToString(List<Integer> numbers) {
        List<String> result = new ArrayList<>();
        for (int number : numbers) {
            result.add("Number: " + number);
        }
        return result;
    }
    // Метод фильтрующий полученную коллекцию по условию заданному в Predicate
    private static List<Integer> filterForIntegerCollection(List<Integer> list, Predicate predicate) {
        List<Integer> result = new ArrayList<>();
        for (int i : list) {
            if (predicate.test(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private static List<String> filterForStringCollection(List<String> list, Predicate predicate) {
        List<String> result = new ArrayList<>();
        for (String i : list) {
            if (predicate.test(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private static List<String> mapStringToString(List<String> numbers) {
        List<String> result = new ArrayList<>();
        for (String number : numbers) {
            result.add(number + " !");
        }
        return result;
    }
}

