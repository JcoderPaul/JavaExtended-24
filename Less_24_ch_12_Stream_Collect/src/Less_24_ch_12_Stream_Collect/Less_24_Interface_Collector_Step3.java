package Less_24_ch_12_Stream_Collect;

import Less_24_ch_12_Stream_Collect.MyCollector.*;

import java.util.Arrays;
import java.util.List;


public class Less_24_Interface_Collector_Step3 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("1", "2", "3", "4", "5");

        /* Производим конкатенацию значений с помощью функции reduce */
        String joinReduceTest = list.stream().
                reduce(new StringCombiner(" , ", "[ ", " ]"),
                        StringCombiner::add,
                        StringCombiner::merge).
                toString();

        System.out.println("С помощью reduce: " + joinReduceTest);

        /* Производим конкатенацию значений с помощью функции collect */
        String joinCollectTest = list.stream()
                .collect(new StringCollector(" , ", "[ ", " ]"));

        System.out.println("С помощью collect: " + joinCollectTest);
    }
}
