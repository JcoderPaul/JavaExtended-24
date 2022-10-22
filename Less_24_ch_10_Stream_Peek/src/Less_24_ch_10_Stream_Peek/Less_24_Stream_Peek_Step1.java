package Less_24_ch_10_Stream_Peek;

import java.util.Arrays;
import java.util.stream.Stream;

/*
- peek выполняет действие над каждым входящим элементом, и возвращает стрим
с исходными элементами, что позволяет в ходе выполнения набора (цепочки) методов
получить результаты промежуточных операций. Тоже является промежуточной операцией.
*/
public class Less_24_Stream_Peek_Step1 {
    public static void main(String[] args) {
        Integer[] arr_for_count_test = {2,4,6,8,3,5,6,78,8,6,2,55,4,3};
        Stream<Integer> str_for_peek_view = Arrays.stream(arr_for_count_test);
        int res_of_count = (int) str_for_peek_view.
                distinct(). // Оставляем только оригинальные элементы
                peek(elem -> System.out.println("Первый peek -> " + elem + " ")). // См. промежуточный результат
                filter(elem -> elem%2 == 0). // Фильтруем по четности
                peek(elem -> System.out.println("Второй peek -> '" + elem + "' ")). // См. промежуточный результат
                count(); // Считаем элементы на выходе
        System.out.println("\nИтог работы Stream, количество элементов на выходе = " + res_of_count);
    }
}
