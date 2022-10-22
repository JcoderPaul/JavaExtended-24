package Less_24_ch_18_EndlessStream;
/*
С помощью интерфейса Supplier получить первое число Фибоначчи, которое больше миллиона.

Числа Фибоначчи - элементы бесконечной числовой последовательности:
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, . . .
в которой первые два числа равны 0 и 1, а каждое последующее число равно сумме двух предыдущих чисел.
 */
import Less_24_ch_18_EndlessStream.MySpecialClasses.SupplierFibonacci;

import java.util.stream.Stream;

public class Less_24_ES_FibonacciFind_step4 {
    public static final int MILLION = 1_000_000;

    public static void main(String[] args) {

        Stream.generate(new SupplierFibonacci()) // Формируем бесконечный стрим генерирующий числа Фибоначчи
                .filter(v -> v > MILLION) // Отбираем из стрима числа больше 1_000_000
                .limit(1) // Берем первое из них
                .forEach(System.out::println);
    }
}
