package Less_24_ch_5_Stream_Sorted;
/*
Сортировка если класс НЕ имплементировал Comparable и НЕ переопределил compareTo
*/
import Less_24_ch_5_Stream_Sorted.MyFavoriteStudents.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
- Stream<T> sorted(): возвращает отсортированный поток.
*/
public class Less_24_Stream_Sorted_Step3 {
    public static void main(String[] args) {
        List<BadStudent> bad_stud_for_sorting = new ArrayList<>();
        bad_stud_for_sorting.add(new BadStudent("Халькис",'m',29,2,4.5));
        bad_stud_for_sorting.add(new BadStudent("Корн",'m',18,3,1.3));
        bad_stud_for_sorting.add(new BadStudent("Антала",'f',27,1,3.9));
        bad_stud_for_sorting.add(new BadStudent("Рамус",'m',21,2,2.8));
        bad_stud_for_sorting.add(new BadStudent("Аквиана",'f',23,3,5.1));
        bad_stud_for_sorting.add(new BadStudent("Ашампа",'f',29,5,2.4));
        bad_stud_for_sorting.add(new BadStudent("Дантиам",'m',19,3,4.4));
        System.out.println("------------- NOT SORTED -------------");
        for (BadStudent stprn: bad_stud_for_sorting){
            System.out.println(stprn);
        }
        System.out.println("------------- SORTED BY STREAM SORTED-------------");
        // Создали ссылку на стрим
        Stream<BadStudent> stream_for_sorted_student = bad_stud_for_sorting.stream();
        // Теперь присвоим нашему НЕотсортированному листу его ОТсортированную версию
        bad_stud_for_sorting =
                // Берем стрим
                stream_for_sorted_student.
                /*
                !!! Поскольку наш класс BadStudent не подписан на интерфейс Comparable приходится
                применять Comparator внутри метода *.sorted(...)!!! Например сортировать по имени.
                Естественно можно применить более сложное лямбда выражение для сортировки.
                */
                sorted((st_1, st_2) -> st_1.getName().compareTo(st_2.getName())).
                /*
                <R,A> R collect(Collector<? super T,A,R> collector): добавляет элементы в
                неизменяемый контейнер с типом <R>. <T> представляет тип данных из вызывающего
                потока, а <A> - тип данных в контейнере.
                */
                collect(Collectors.toList());
        for (BadStudent stprn: bad_stud_for_sorting){
            System.out.println(stprn);
        }

    }
}
