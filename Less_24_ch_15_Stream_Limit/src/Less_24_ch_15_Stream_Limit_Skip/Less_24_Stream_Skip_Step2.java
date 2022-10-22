package Less_24_ch_15_Stream_Limit_Skip;

import Less_24_ch_15_Stream_Limit_Skip.MyFavoriteStudents.GoodStudent;

import java.util.ArrayList;
import java.util.List;

/*
- Stream<T> skip(long n): возвращает стрим, в котором отсутствуют первые n элементов.
Промежуточная операция.
В отличие от limit, который наоборот пропускал первые n-элементов, skip их тормозит,
что-то вроде предела снизу.
*/
public class Less_24_Stream_Skip_Step2 {
    public static void main(String[] args) {
        List<GoodStudent> stud_for_sorting = new ArrayList<>();
        stud_for_sorting.add(new GoodStudent("Фрам",'m',19,5,4.5));
        stud_for_sorting.add(new GoodStudent("Эфель",'m',17,3,5.3));
        stud_for_sorting.add(new GoodStudent("Санара",'f',17,4,9.9));
        stud_for_sorting.add(new GoodStudent("Тикан",'m',26,2,6.8));
        stud_for_sorting.add(new GoodStudent("Аманет",'f',23,3,8.1));
        stud_for_sorting.add(new GoodStudent("Абраксас",'m',32,5,9.4));
        stud_for_sorting.add(new GoodStudent("Ритан",'m',21,3,7.4));
        System.out.println("------------- NOT SORTED -------------");
        for (GoodStudent stprn: stud_for_sorting){
            System.out.println(stprn);
        }
        System.out.println("\n------------- FILTER > 20 without SKIP и LIMIT BY STREAM -------------");
        /*
        Просто фильтруем студентов по возрасту и выводим на экран
         */
        stud_for_sorting.stream(). // Формируем стрим
                filter(std -> std.getAge() > 20). // Отбираем всех кому больше 20 (таких 4-и)
                forEach(st -> System.out.println(st)); // Печатаем результат

        System.out.println("------------- LIMIT * 1 * BY STREAM -------------");
        /*
        Метод limit оставляет в стриме первые n-элементов заданных в параметрах, как maxSize,
        остальные игнорируются (не проходят дальше)
         */
        stud_for_sorting.stream(). // Формируем стрим
                filter(std -> std.getAge() > 20). // Отбираем всех кому больше 20 (таких 4-и)
                // Пропускаем дальше по стриму только 1-ый элемент (или всех, кто идет до n-го) предел сверху
                limit(1).
                forEach(st -> System.out.println(st)); // Печатаем результат

        System.out.println("------------- SKIP * 3 * BY STREAM -------------");
        /*
        Метод skip не пускает в стрим первые n-элементов заданных в параметрах, как n,
        остальные пролетают в следующий метод (проходят дальше) до терминального метода.
         */
        stud_for_sorting.stream(). // Формируем стрим
                filter(std -> std.getAge() > 20). // Отбираем всех кому больше 20 (таких 4-и)
                // Пропускаем дальше по стриму только тех, кто идет после 3-го элемента (или скипает n первых)
                skip(3).
                forEach(st -> System.out.println(st)); // Печатаем результат
    }
}
