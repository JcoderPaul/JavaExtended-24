package Less_24_ch_12_Stream_Collect;

import Less_24_ch_12_Stream_Collect.MyOwnClasses.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/*
- <R,A> R collect(Collector<? super T,A,R> collector): добавляет элементы в неизменяемый контейнер с типом <R>.
<T> представляет тип данных из вызывающего потока, а <A> - тип данных в контейнере. Терминальная операция.
*/
public class Less_24_Collect_partitioningBy_Step2 {
    public static void main(String[] args) {
        List<Student> stud_for_sorting = new ArrayList<>();
        stud_for_sorting.add(new Student("Альтавус",'m',19,2,4.5));
        stud_for_sorting.add(new Student("Вектрус",'m',29,3,5.3));
        stud_for_sorting.add(new Student("Санара",'f',17,1,9.9));
        stud_for_sorting.add(new Student("Тильн",'m',21,2,6.8));
        stud_for_sorting.add(new Student("Акация",'f',23,4,8.1));
        stud_for_sorting.add(new Student("Дорум",'m',31,5,9.4));
        stud_for_sorting.add(new Student("Септиам",'m',19,3,7.4));
        System.out.println("------------- NOT SORTED -------------");
        for (Student stprn: stud_for_sorting){
            System.out.println(stprn);
        }
        System.out.println("------------- After 'Collectors.groupingBy' work -------------");
        /*
        1. Поделим студентов на две группы, те, кто получают оценку выше некого предела и ниже
        2. Поместим результаты работы в MAP
        */
        Map<Boolean, List<Student>> course_map =
                // Формируем стрим из листа
                stud_for_sorting.stream().
                /*
                !!! Разбиваем наших студентов по двум спискам (отличники и двоешники).
                Результатом работы метода будет Map-of-Lists или коллекция Map, где
                ключом будет boolean значение (true/false), а содержимым под двумя
                ключами будут два листа студентов соответственно баллам успеваемости.
                */
                collect(Collectors.partitioningBy(std -> std.getAvgGrade() > 7));

        for(Map.Entry<Boolean, List<Student>> entry: course_map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
