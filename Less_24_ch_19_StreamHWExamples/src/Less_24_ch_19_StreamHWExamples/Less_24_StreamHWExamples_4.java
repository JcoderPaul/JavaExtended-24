package Less_24_ch_19_StreamHWExamples;

import java.util.List;
import java.util.stream.Collectors;

/*
Дан список целых чисел, вывести строку, представляющую
собой конкатенацию строковых представлений этих чисел.
Например: список {5, 2, 4, 2, 1}
Результат строка : "52421"
*/
public class Less_24_StreamHWExamples_4 {
    public static void main(String[] args) {
        List<Integer> myIntTestList = List.of(4, 5, 67, 23, 8, 9, 3);

        String concatStr = myIntTestList
                .stream()
                .map(Integer -> String.valueOf(Integer))
                .collect(Collectors.joining());

        System.out.println(concatStr);
        System.out.println("--------------------------------------------------");
        String concatStrWithPrefAndSuffix = myIntTestList
                .stream()
                // Тот же метод, что и в первом варианте, но с MethodReferences
                .map(String::valueOf)
                // Тот же метод, что и в первом варианте, но с префиксом, суффиксом и разделителем
                .collect(Collectors.joining(" - ","Начало строки - "," - конец строки."));

        System.out.println(concatStrWithPrefAndSuffix);
    }
}
