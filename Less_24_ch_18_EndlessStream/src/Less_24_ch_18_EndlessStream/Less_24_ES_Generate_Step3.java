package Less_24_ch_18_EndlessStream;
/*
Использование IntStream.generate() метода
*/
import java.util.PrimitiveIterator;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Less_24_ES_Generate_Step3 {
    public static void main(String[] args) {

        /*
        Интерфейс IntStream имеет еще одну возможность для создания бесконечного стрима
        через метод *.generate(). Этот метод использует интерфейс Supplier<T> для создания
        новых значений.

        Есть много вариантов использования Supplier, которые мы можем использовать.

        Первые два способа генерируют стрим случайных элементов, а последние два генерируют стрим
        последовательных целых чисел, которые увеличиваются.

        Вариант 1.  IntStream.generate(ThreadLocalRandom.current()::nextInt)
                    .forEach(System.out::println);

        Вариант 2.  Random random = new Random();
                    IntStream.generate(random::nextInt)
                    .forEach(System.out::println);

        Вариант 3.  AtomicInteger counter = new AtomicInteger();
                    IntStream.generate(counter::incrementAndGet)
                    .forEach(System.out::println);

        Вариант 4.  см.ниже рабочий код.
        */

        PrimitiveIterator.OfInt itr = new PrimitiveIterator.OfInt(){
            private int counter = 1;

            @Override
            public int nextInt() {
                return counter++;
            }

            @Override
            public boolean hasNext() {
                return (counter == Integer.MAX_VALUE);
            }
        };

        IntStream.generate(itr::nextInt)
                .forEach(System.out::println);

    }
}
