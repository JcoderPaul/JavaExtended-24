package Less_24_ch_5_Stream_Sorted;
/*
Сортировка если класс имплементировал Comparable и переопределил compareTo
*/
import Less_24_ch_5_Stream_Sorted.MyFavoriteStudents.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
- Stream<T> sorted(): возвращает отсортированный поток.
*/
public class Less_24_Stream_Sorted_Step2 {
    public static void main(String[] args) {
        List<GoodStudent> stud_for_sorting = new ArrayList<>();
        stud_for_sorting.add(new GoodStudent("Альтавус",'m',19,2,4.5));
        stud_for_sorting.add(new GoodStudent("Вектрус",'m',29,3,5.3));
        stud_for_sorting.add(new GoodStudent("Санара",'f',17,1,9.9));
        stud_for_sorting.add(new GoodStudent("Тильн",'m',21,2,6.8));
        stud_for_sorting.add(new GoodStudent("Акация",'f',23,3,8.1));
        stud_for_sorting.add(new GoodStudent("Дорум",'m',31,5,9.4));
        stud_for_sorting.add(new GoodStudent("Септиам",'m',19,3,7.4));
        System.out.println("------------- NOT SORTED -------------");
        for (GoodStudent stprn: stud_for_sorting){
            System.out.println(stprn);
        }
        System.out.println("------------- SORTED BY STREAM SORTED-------------");
        // Создали ссылку на стрим
        Stream<GoodStudent> stream_for_sorted_student = stud_for_sorting.stream();
        // Теперь присвоим нашему НЕотсортированному листу его ОТсортированную версию
        stud_for_sorting =
                // Берем стрим
                stream_for_sorted_student.
                // Сортируем. !!! ВАЖНО чтобы наш класс имплементировал Comparable и переписал compareTo !!!
                sorted().
                /*
                <R,A> R collect(Collector<? super T,A,R> collector): добавляет элементы в
                неизменяемый контейнер с типом <R>. <T> представляет тип данных из вызывающего
                потока, а <A> - тип данных в контейнере.
                */
                collect(Collectors.toList());
        for (GoodStudent stprn: stud_for_sorting){
            System.out.println(stprn);
        }

    }
}
