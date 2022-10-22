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
public class Less_24_Collect_groupingBy_Step1 {
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
        1. Переведем имена в верхний регистр
        2. Отсортируем по курсам (каждый лист будет иметь свой список студентов)
        3. Поместим результаты работы в MAP
        */
        Map<Integer, List<Student>> course_map =
                // Формируем стрим из листа
                stud_for_sorting.stream().
                // Преобразуем все буквы имен в верхний регистр
                map(std -> {std.setName(std.getName().toUpperCase()); return std;}).
                /*
                !!! Группируем наших студентов по курсам. Результатом работы метода будет
                Map-of-Lists или коллекция Map, где ключом будет Integer значение курса, а
                содержимым под ключом будет лист студентов соответствующего курса.
                */
                collect(Collectors.groupingBy(std -> std.getCourse()));

        for(Map.Entry<Integer, List<Student>> entry: course_map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
