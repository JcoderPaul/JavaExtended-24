package Less_24_ch_7_Stream_Concat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

/*
- Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b): объединяет два стрима.
*/
public class Less_24_Stream_Concat_Step1 {
    public static void main(String[] args) {
        List<Integer> arr_int_first = List.of(1, 2, 3, 4, 5);
        List<Integer> arr_int_two = List.of(6, 7, 8, 9, 10);

        Stream<Integer> str_of_arr_int_first = arr_int_first.stream();
        Stream<Integer> str_of_arr_int_two = arr_int_two.stream();
        Stream<Integer> concat_str = Stream.concat(str_of_arr_int_first, str_of_arr_int_two);
        concat_str.forEach(str -> System.out.print(str + " "));

        System.out.println("\n----------------------------------------------------------");
        int[] int_arr_for_concat_first = {11, 12, 13, 14, 15};
        int[] int_arr_for_concat_second = {16, 17, 18, 19, 20};
        Stream<Integer> str_of_int_arr_for_concat_first = stream(int_arr_for_concat_first).boxed();
        Stream<Integer> str_of_int_arr_for_concat_second = stream(int_arr_for_concat_second).boxed();
        Stream<Integer> concat_str_of_arr =
                Stream.concat(str_of_int_arr_for_concat_first, str_of_int_arr_for_concat_second);
        concat_str_of_arr.forEach(str -> System.out.print(str + " "));

        System.out.println("\n----------------------------------------------------------");
        String[] arr_for_concat_first = {"Каждый", "охотник", "желает", "знать"};
        String[] arr_for_concat_second = {"где", "сидит", "фазан", "!"};
        Stream<String> str_for_concat_first = Arrays.stream(arr_for_concat_first);
        Stream<String> str_for_concat_second = Arrays.stream(arr_for_concat_second);
        Stream<String> concat_rainbow =
                Stream.concat(str_for_concat_first, str_for_concat_second);
        concat_rainbow.forEach(str -> System.out.print(str + " "));


    }
}
