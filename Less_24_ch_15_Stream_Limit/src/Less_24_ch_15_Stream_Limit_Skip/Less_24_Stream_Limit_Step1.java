package Less_24_ch_15_Stream_Limit_Skip;

import Less_24_ch_15_Stream_Limit_Skip.MyFavoriteStudents.GoodStudent;

import java.util.ArrayList;
import java.util.List;

/*
- Stream<T> limit(long maxSize): оставляет в потоке только maxSize элементов.
Промежуточная операция.
В отличие от skip, которая тормозит первые n - элементов стрима, limit пропускает первых,
что-то вроде предела сверху.
*/
public class Less_24_Stream_Limit_Step1 {
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
        System.out.println("------------- LIMIT BY STREAM -------------");
        /*
        Метод limit оставляет в стриме первые n-элементов заданных в параметрах, как maxSize,
        остальные игнорируются (не проходят дальше)
         */
        stud_for_sorting.stream(). // Формируем стрим
                filter(std -> std.getAge() > 20). // Отбираем всех кому больше 20 (таких 4-и)
                limit(2). // Пропускаем дальше по стриму только 2-их первых
                forEach(st -> System.out.println(st)); // Печатаем результат
    }
}
