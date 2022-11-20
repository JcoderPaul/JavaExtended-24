package Less_24_ch_19_StreamHWExamples;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
Дан список сток. Найти количество уникальных
строк длинной равной или более 8 символов.
*/
public class Less_24_StreamHWExamples_2 {
    public static void main(String[] args) {
        List <String> myVerse = List.of(
                "Река", "времен", "в", "своем", "стремленьи",
                         "Уносит", "все", "дела", "людей",
                         "И", "топит", "в", "пропасти", "забвенья",
                         "Народы", "царства", "и", "царей"
        );

        Set<String> uniqueSet = new HashSet<>(myVerse);
        System.out.println("-------------------------------------------------");
        uniqueSet.forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        System.out.println("Исходный размер : " + myVerse.size());
        System.out.println("Уникальных элементов : " + uniqueSet.size());
        System.out.println("--------------- size of collection ---------------");
        /*
        1. Первый вариант реализации стрима
        */
        int countUniqueWord = uniqueSet
                .stream()
                .filter(str -> str.length() >= 8)
                .collect(Collectors.toList())
                .size();
        System.out.println("Слов равных 8 символам или более : " + countUniqueWord);
        System.out.println("--------------- count of distinct ---------------");
        /*
        2. Второй вариант реализации стрима
        */
        int countUniqueWordTwo = (int) uniqueSet
                .stream()
                .filter(str -> str.length() >= 8)
                /*
                *** Удаление дублирующихся элементов с помощью distinct() ***
                Особенности использования метода distinct():
                - Элементы сравниваются с использованием equals(). Поэтому необходимо,
                чтобы элементы стрима использовали правильную реализацию этого метода.
                - Если стрим упорядочен, порядок нумерации сохраняется.
                - Если стрим не упорядочен, то элементы потока могут иметь любой порядок.
                - Stream distinct() - промежуточная операция с состоянием.
                - Использование Different() с упорядоченным параллельным стримами может
                иметь низкую производительность из-за значительных расходов на буферизацию.
                В этом случае нужно перейти к последовательной обработке потока.

                Пример:
                --------------------------------------------------------------------------
                List<Integer> list = List.of(1, 2, 3, 4, 3, 2, 1);
                List<Integer> distinctInts = list.stream()
                                                 .distinct()
                                                 .collect(Collectors.toList());
                distinctInts ==> [1, 2, 3, 4]
                --------------------------------------------------------------------------
                */
                .distinct()
                /*
                long count() возвращает количество элементов в потоке. Это частный случай
                редукции (операция редукции берет последовательность входных элементов и
                объединяет их в один суммарный результат путем многократного применения
                операции объединения). Это терминальная операция, т. е. она может проходить
                через поток для получения результата или побочного эффекта. После выполнения
                терминальной операции потоковый конвейер считается израсходованным и больше
                не может использоваться.

                Пример:
                --------------------------------------------------------------------------
                 // creating a list of Integers
                 List<Integer> list = Arrays.asList(0, 2, 4, 6, 8, 10, 12);

                 // Using count() to count the number of elements in the stream and
                 // storing the result in a variable.
                 long total = list.stream().count();

                 // Displaying the number of elements => 7
                 System.out.println(total);
                */
                .count();
        System.out.println("Слов равных 8 символам или более : " + countUniqueWordTwo);
        System.out.println("-------------------------------------------------");
        uniqueSet.stream()
                 .filter(str -> str.length() >= 8)
                 .collect(Collectors.toList())
                 .forEach(System.out::println);

    }
}
