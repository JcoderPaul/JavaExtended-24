package Less_24_ch_8_Stream_Distinct;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
- Stream<T> distinct(): возвращает поток, в котором имеются только уникальные данные с типом T.
т.е. убирает дубликаты
*/
public class Less_24_Stream_Distinct_Step1 {
    public static void main(String[] args) {
        Integer[] arr_for_distinct_test = {2,4,6,8,3,5,6,78,8,6,2,55,4,3};
        for (Integer prn: arr_for_distinct_test) {
            System.out.print(prn + " ");
        }
        System.out.println("\nДлина массива = " + arr_for_distinct_test.length);

        System.out.println("\n---------------- AFTER DISTINCT ------------------");
        Integer[] arr_after_distinct = Arrays.stream(arr_for_distinct_test).distinct().toArray(Integer[]::new);
        for (Integer prn: arr_after_distinct) {
            System.out.print(prn + " ");
        }
        System.out.println("\nДлина массива = " + arr_after_distinct.length);

        System.out.println("\n----------------------------------------------------");
        List<String> word_list =
                List.of("чем", "больше", "женщину", "мы", "меньше", "тем", "меньше", "больше", "она", "нам");
        word_list.forEach(word -> System.out.print(word + " "));
        System.out.println("\nКоличество слов в листе = " + word_list.size());

        System.out.println("\n---------------- AFTER DISTINCT ------------------");
        List<String> short_list = word_list.stream().distinct().collect(Collectors.toList());
        short_list.forEach(word -> System.out.print(word + " "));
        System.out.println("\nКоличество слов в листе = " + short_list.size());


    }
}
