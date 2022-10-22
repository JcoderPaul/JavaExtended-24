package Less_24_ch_5_Stream_Sorted;

import java.util.Arrays;

/*
- Stream<T> sorted(): возвращает отсортированный поток.
*/
public class Less_24_Stream_Sorted_Step1 {
    public static void main(String[] args) {
        // Создали массив с элементами вразнобой
        int[] arr_for_stream_sort = {3,4,7,1,2,9,4,32,41,21,12};
        System.out.println("Было -> " + Arrays.toString(arr_for_stream_sort));
        /*
        На этот раз мы делаем так, чтобы работа проделанная методами стрима упала в тот же массив,
        с которым работал стрим. Т.е. хотя стрим и не изменяет массив (коллекцию) с которым работает,
        но никто не мешает нам провести нужные манипуляции для таковых изменений.

        И так, перезаписываем наш массив результатами работы стрима.
        */
        arr_for_stream_sort = Arrays.stream(arr_for_stream_sort).sorted().toArray();
        // Выводим на печать
        System.out.println("Стало -> " + Arrays.toString(arr_for_stream_sort));

    }
}
