package Less_24_ch_1_Stream_Map;

import java.util.*;
import java.util.stream.Collectors;

/*
Пример работы методов Stream API с TreeSet
*/
public class Less_24_Stream_Map_Step3 {
    public static void main(String[] args) {
        // Помним, что TreeSet отсортирован
        Set<String> padezji = new TreeSet<>();
        padezji.add("иван");
        padezji.add("родил");
        padezji.add("девчонку");
        padezji.add("велел");
        padezji.add("тащить");
        padezji.add("пеленку");
        // Естественная сортировка
        Iterator<String> padezj_iter = padezji.iterator();
        while (padezj_iter.hasNext()){
            System.out.print(padezj_iter.next() + " ");
        };
        System.out.println("\n----------- Работает набор Stream API методов -----------");
        Set<String> set_big_char =
                padezji.stream(). // Шаг 1. Получаем стрим из сета STREAM
                map(word -> word.toUpperCase()). // Шаг 2. Применяем MAP, и преобразуем каждый элемент стрима
                collect(Collectors.toSet()); // Шаг 3. Преобразуем стрим в коллекцию сет COLLECT
        TreeSet<String> sorted_set_big_char = new TreeSet<>(set_big_char);
        for (String str_big: sorted_set_big_char) {
            System.out.print(str_big + " ");
        }
        System.out.println("\n----------- Стрим не меняет исходной коллекции -----------");
        System.out.println(padezji);



    }
}
