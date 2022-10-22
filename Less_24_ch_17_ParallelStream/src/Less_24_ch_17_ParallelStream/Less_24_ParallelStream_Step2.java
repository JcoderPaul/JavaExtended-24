package Less_24_ch_17_ParallelStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Параллельная потоковая передача (параллельные стримы) предназначена для разделения содержимого
на несколько блоков данных и использования разных потоков для обработки каждого блока данных
отдельно.
*/
public class Less_24_ParallelStream_Step2 {
    public static void main(String[] args) {

        List<String> people = Arrays.asList("Tom","Bob", "Sam", "Kate", "Tim");

        System.out.println("Последовательный поток");
        people.stream().
                filter(p -> p.length() == 3).
                forEach(System.out::println);

        System.out.println("\nПараллельный поток");
        people.parallelStream().
                filter(p -> p.length() == 3).
                forEach(System.out::println);
    }
}
