package Less_24_ch_18_EndlessStream;
/*
Использование Random.ints() метода
*/

import java.util.Random;

public class Less_24_ES_RandomInts_Step2 {
    public static void main(String[] args) {

        /*
        Java предоставляет класс Random для генерации потока псевдослучайных чисел. Чтобы сгенерировать
        бесконечный поток случайных значений int, мы можем использовать метод ints() класса Random, как
        показано ниже:

        Random random = new Random();
        random.ints().forEach(System.out::println);

        Метод *.ints() класса Random перегружен и имеет реализацию вида ints(start, end),
        где мы можем указать диапазон возвращаемых случайных значений, см. пример ниже:

        Random random = new Random();
            int start = 0;
            int end = 10;
            random.ints(start, end + 1).
                   forEach(System.out::println);

        В данном случае случайные числа бесконечного стрима будут генерироваться в пределах от 0 до 10.
        Поскольку end = 10 не входит в диапазон генерации и фактически генерация шла бы в пределах 0 - 9,
        а нам бы хотелось от 0 до 10, реализуется 'end + 1'.

        Метод *.ints() имеет еще пару перегруженных реализаций:
        - *.ints(limit) - возвращает стрим псевдослучайных чисел ограниченного (значением limit)
                          количества элементов.
        - *.ints(limit, start, end) - возвращает стрим псевдослучайных чисел ограниченного (значением limit)
                          количества элементов, из диапазона start - end.

        Т.е. мы также можем установить ограничение на общее количество случайных значений, возвращаемых ints()
        путем передачи общего количества значений для генерации в качестве аргумента, см. пример ниже:
        */

        Random random = new Random();// Получаем экземпляр класса `Random`

        int limit = 5;
        int start = 0;
        int end = 10;

        random.ints(limit).forEach(rnd -> System.out.print(rnd + " ")); // Генерируем поток из 5 случайных int чисел
        System.out.println("\n ----------------------------------------------- ");
        random.ints(limit, start, end). // Генерируем поток из 5 случайных целых чисел от 0 до 9
                forEach(rnd -> System.out.print(rnd + " "));
    }
}
