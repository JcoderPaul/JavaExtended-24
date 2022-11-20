package Less_24_ch_19_StreamHWExamples;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Дан Map<String, Integer>. Найти сумму всех
значений, длинна ключей которых меньше 7 символов.
*/
public class Less_24_StreamHWExamples_3 {
    public static void main(String[] args) {
        Map<String, Integer> mapForTest = Map.of(
                "Я", 1,
                "поднялся", 2,
                "на", 3,
                "холм,", 4,
                "Полон грусти - ", 5,
                "и что же:", 6,
                "Там", 7,
                "шиповник", 8,
                "в", 9,
                "цвету!", 10
        );
        System.out.println("----------------- Ключи K < 7 и их int значения V-----------------");
        mapForTest.entrySet()
                .stream()
                .filter(entry -> entry.getKey().length() < 7)
                .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));

        System.out.println("----------------- Сумма значений V у которых ключи K < 7 -----------------");
        int sumOfValue = mapForTest.entrySet()
                             .stream()
                             .filter(entry -> entry.getKey().length() < 7)
                             .mapToInt(entry -> entry.getValue().intValue())
                             .sum();

        System.out.println(sumOfValue);
        System.out.println("--------------------------------------------------------");

    }
}
