package Less_24_ch_9_Stream_Count;
/*
- long count(): возвращает количество элементов в потоке. Терминальная операция.
*/
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Less_24_Stream_Count_Step1 {
    public static void main(String[] args) {
        Integer[] arr_for_count_test = {2,4,6,8,3,5,6,78,8,6,2,55,4,3};
        for (Integer prn: arr_for_count_test) {
            System.out.print(prn + " ");
        }
        System.out.println("\nДлина массива = " + arr_for_count_test.length);
        /*
        В данном примере, как и в примере ниже, мы для получения необходимой информации
        каждый раз формировали новый стрим (пусть и без имени), закрывая старый терминальной операцией.
        */
        System.out.println("Количество элементов массива = " +
                Arrays.stream(arr_for_count_test).count());
        System.out.println("Количество оригинальных элементов массива = " +
                Arrays.stream(arr_for_count_test).distinct().count());

        System.out.println("\n----------------------------------------------------");
        List<String> word_list =
                List.of("чем", "больше", "женщину", "мы", "меньше", "тем", "меньше", "больше", "она", "нам");
        word_list.forEach(word -> System.out.print(word + " "));
        System.out.println("\nКоличество слов в листе = " + word_list.size());
        System.out.println("Количество элементов листа = " +
                word_list.stream().count());
        System.out.println("Количество оригинальных элементов в листе = " +
                word_list.stream().distinct().count());
        System.out.println("\n----------------------------------------------------");
        /*
        !!!! ОДИН и ТОТ ЖЕ стрим дважды нельзя запускать !!!!
        */
        Stream<Integer> stream_for_find_error = Stream.of( 22, 34, 56, 23, 5, 22, 56, 23, 3);
        System.out.println(stream_for_find_error.count());
        /* !!!
        При запуске этой строки: System.out.println(stream_for_find_error.distinct().count());
        Сразу после этой: System.out.println(stream_for_find_error.count());
        Или наоборот, когда мы обращаемся к стриму, который уже закрыт терминальной операцией или
        все еще работает выбросится ошибка:
        ' Exception in thread "main" java.lang.IllegalStateException:
        stream has already been operated upon or closed '
        !!! */


    }
}
