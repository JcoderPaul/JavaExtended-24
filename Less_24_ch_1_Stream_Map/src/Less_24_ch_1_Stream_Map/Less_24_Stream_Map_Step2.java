package Less_24_ch_1_Stream_Map;

import java.util.Arrays;

/*
Пример работы метода MAP для массива
*/
public class Less_24_Stream_Map_Step2 {
    public static void main(String[] args) {
        /*
        Пусть мы хотим найти в нашем массиве все числа делящиеся на 3 без остатка,
        если этого не происходит, число остается без изменений.
        */
        int [] my_int_arr = {4, 6, 78, 23, 41, 93, 9, 2, 432};
        System.out.println("--------------- Исходный массив ---------------");
        for (int i = 0; i < my_int_arr.length; i++){
            System.out.print(my_int_arr[i] + " ");
        }

        System.out.println("\n--------------- Преобразованный массив ---------------");
        /*
        Стрим на массиве получается немного по-другому, через статический метод класса
        Arrays.stream(args), куда в качестве аргументов поступает наш массив. Я специально
        переношу каждый метод Stream API на новую строку, чтобы було наглядно видно и удобно
        комментировать.
        */
        my_int_arr = Arrays.stream(my_int_arr). // Метод 1. Формируем первый стрим;
                     map(elem -> { // Метод 2. Используем метод MAP для преобразования первого стрима в
                         if(elem%3 == 0){ // набор элементов (фактически стрим другого вида) согласно заданию,
                            elem = elem/3; // т.е. ищем элементы делящиеся на 3-и без остатка, остальные игнорируем.
                            return elem; // Тут явно видно, что лямбда не коротенькое выражение, а
                         } else // набор строк с return-ом;
                            return elem;
                     }).
                     toArray(); // Метод 3. Завершаем терминальной операцией. Преобразуем стрим в массив int-ов;

        for (int i = 0; i < my_int_arr.length; i++){
            System.out.print(my_int_arr[i] + " ");
        }
        // Вывод массива без цикла )))
        System.out.println("\n--- Вывод массива через System.out.println(Arrays.toString(***name_of_array***)) ---");
        System.out.println(Arrays.toString(my_int_arr));
    }
}
