package Less_24_ch_3_Stream_forEach;
/*
void forEach(Consumer<? super T> action): для каждого элемента выполняется действие action.
*/
import java.util.Arrays;
import java.util.Iterator;

public class Less_24_Stream_forEach_Step1 {
    public static void main(String[] args) {
        int[] arr_int_foreach = {2, 4, 5, 1, 23, 66, 2, 9, 5};
        Iterator<Integer> integerIterator = Arrays.stream(arr_int_foreach).iterator();
        while (integerIterator.hasNext()){
            System.out.print(integerIterator.next() + " ");
        }
        System.out.println("\n---------------- Работает Stream API метод *.forEach ----------------");
        Arrays.
                // Шаг 1. Создаем стрим из массива
                stream(arr_int_foreach).
                // Шаг 2. (терминальная операция) Изменяем элементы масива и выводим на печать
                forEach(arr_elem -> {arr_elem *= 2; System.out.print(arr_elem + " ");});
        System.out.println("\n----------- Работает *.forEach с метод референс (ссылка на метод) -----------");
        /*
        !!! Помним, что если мы сами не захотим внести изменения в исходный массив (коллекцию), то вся работа
        методов стрим не изменяет коллекцию, а выдает некий требуемый результат, который мы можем использовать
        для дальнейшей работы.

        Пример ниже, выводим на печать нашу старую коллекцию, с которой уже поработал стрим.
        */
        Arrays.
                // Шаг 1. Создаем стрим из массива
                stream(arr_int_foreach).
                // Шаг 2. Печать всех элементов массива без изменений при помощи метод-рефренс ()
                forEach(System.out::println);
    }
}
