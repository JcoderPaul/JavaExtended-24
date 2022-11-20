package Less_24_ch_19_StreamHWExamples;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

/*
Дан список целых чисел. Найти среднее
значение всех нечетных чисел, делящихся
на 5.

Решить задачу методами Stream API.
*/
public class Less_24_StreamHWExamples_1 {
    public static void main(String[] args) {
        /*
        В принципе, мы могли бы создать наш стрим 'на лету':
        Stream.of(1, 3, 4, 6, 8, 5, 15, 20, 25, 10);

        Либо, не 'на лету', но, как еще вариант создания
        стрима, помимо классического и это: Stream.of(myTestList);
         */
        List<Integer> myTestList = List.of(1, 3, 4, 6, 8, 5, 15, 20, 25, 10);
        // Создаем стрим
        OptionalDouble myAnswer = myTestList.stream()
                  /*
                  Создаем фильтр для отсеивания четных значений
                  (дальше по стриму проходят только нечетные)
                  */
                  .filter(integer -> integer % 2 != 0)
                  /*
                  Создаем фильтр для отсеивания чисел делящихся
                  на 5 - ть без остатка (дальше по стриму проходят
                  только те, что делятся на 5 без остатка)
                  */
                  .filter(integer -> integer % 5 == 0)
                  /*
                  Преобразуем стрим объектов в стрим примитивов,
                  для тог, чтобы использовать их крутые методы,
                  например *.average()
                  (и многие др. см.
                  IntSummaryStatistics.txt
                  и
                  CreatingPrimitivesStream.txt
                  в основном курсе они рассматриваются скудно)
                  */
                  .mapToInt(Integer::intValue)
                  .average();

        myAnswer.ifPresent(System.out::println);
    }
}
