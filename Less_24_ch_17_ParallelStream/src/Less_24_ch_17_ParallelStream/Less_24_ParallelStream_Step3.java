package Less_24_ch_17_ParallelStream;

import java.util.ArrayList;
import java.util.List;

/*
Параллельная потоковая передача (параллельные стримы) предназначена для разделения содержимого
на несколько блоков данных и использования разных потоков для обработки каждого блока данных
отдельно.

Ассоциативность (сочетательность) — свойство бинарной операции, заключающееся в возможности
осуществлять последовательное применение формулы в произвольном порядке к элементам x, y, z, . . .
Например, действия сложения или умножения.
*/
public class Less_24_ParallelStream_Step3 {
    public static void main(String[] args) {
        // Создадим большую коллекцию и заполним ее значениями int
        List<Integer> arr_for_sum = new ArrayList<>();
        for(int i = 0; i < 7000_000; i++){
            arr_for_sum.add(i);
        }
//************************************************************************************************************
        long m = System.currentTimeMillis(); // Фиксируем стартовое время начала расчета

        int sumResult = arr_for_sum.stream(). // Создаем однопоточный стрим из коллекции
                reduce((acum, elem) -> acum-elem). // Рассчитываем разницу всех элементов коллекции
                get(); // Получаем результат

        System.out.println(sumResult); // Выводим на экран результаты расчетов
        System.out.println("Время затраченное на расчет => " +
                          (double) (System.currentTimeMillis() - m)); // Выводим на экран разницу во времени
        System.out.println("-------------------------------------------------------------------");
//************************************************************************************************************
        /*
        !!! Яркий пример того, когда распараллеливание процессов вычисления приводит к казусу,
        когда расчетная операция не ассоциативная !!!

        Применим вычетание и посмотрим на результат расчетов (при параллельном и последовательном стриме).
        */
        long m_parallel = System.currentTimeMillis(); // Снова фиксируем начало расчета

        int parallelSumResult = arr_for_sum.parallelStream(). // Создаем параллельный стрим
                reduce((acum, elem) -> acum-elem). // Рассчитываем разницу всех элементов, как и в прошлый раз
                get(); // Возвращаем результат
        System.out.println(parallelSumResult); // Выводим результат на экран

        System.out.println("Время затраченное на параллельный расчет => " +
                          (double) (System.currentTimeMillis() - m_parallel)); // Выводим на экран время расчетов
        System.out.println("-------------------------------------------------------------------");
        /*
        !!! Да, в данном примере время параллельного расчета (работы параллельного стрима) суммы
        всех элементов коллекции, как минимум в два раза меньше, чем время последовательного
        (однопоточного) стрима. !!!

        Однако, стоит тщательно подходить к выбору параллельных стримов и методикам работы с ними,
        см. ReadMe.txt
        */


    }
}
