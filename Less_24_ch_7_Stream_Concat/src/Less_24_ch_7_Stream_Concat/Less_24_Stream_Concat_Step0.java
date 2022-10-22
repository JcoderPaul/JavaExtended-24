package Less_24_ch_7_Stream_Concat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
Еще раз о методах получения стримов из коллекций и массивов
*/
public class Less_24_Stream_Concat_Step0 {
    public static void main(String[] args) {
        // 1. Коллекция предоставляет два метода stream () и parallelStream ()
        List<String> my_list = new ArrayList<>();
        Stream<String> stream = my_list.stream(); // Получить стрим последовательности
        Stream<String> parallelStream = my_list.parallelStream(); // Получить параллельный стрим

        // 2. Получить стрим массива через stream () в массивах
        Integer[] nums = new Integer[10];
        Stream<Integer> stream1 = Arrays.stream(nums);

        // 3. Через статический метод () в классе Stream
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6);
    }
}
