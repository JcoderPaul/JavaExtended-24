package Less_24_ch_2_Stream_Filter;
/*
Stream<T> filter(Predicate<? super T> predicate): фильтрует элементы в соответствии с условием в предикате.
*/
import Less_24_ch_2_Stream_Filter.MyOwnClasses.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Less_24_Stream_Filter_Step1 {
    public static void main(String[] args) {
        List<Student> stud_for_sorting = new ArrayList<>();
        stud_for_sorting.add(new Student("Альтавус",'m',19,2,4.5));
        stud_for_sorting.add(new Student("Вектрус",'m',29,3,5.3));
        stud_for_sorting.add(new Student("Санара",'f',17,1,9.9));
        stud_for_sorting.add(new Student("Тильн",'m',21,2,6.8));
        stud_for_sorting.add(new Student("Акация",'f',23,3,8.1));
        stud_for_sorting.add(new Student("Дорум",'m',31,5,9.4));
        stud_for_sorting.add(new Student("Септиам",'m',19,3,7.4));
        Collections.sort(stud_for_sorting);
        for (Student stprn: stud_for_sorting){
            System.out.println(stprn);
        }
        System.out.println("------------------ Работает стрим с *.filter ------------------");

        List<Student> filtered_list = new ArrayList<>();
        // Шаг 0. Отдаем будущие результаты работы методов стрима новому листу
        filtered_list = stud_for_sorting.
                // Шаг 1. Формируем стрим из листа
                stream().
                // Шаг 2. (промежуточная операция) Фильтруем каждого студента согласно условиям лямбды
                filter(student -> {return  (student.getAge() > 20 && student.getAvgGrade() < 8);}).
                // Шаг 3. (терминальная операция) Теперь возвращаем стрим в новый лист
                collect(Collectors.toList());

        Iterator<Student> filter_std_iter = filtered_list.listIterator();
        while (filter_std_iter.hasNext()){
            System.out.println(filter_std_iter.next());
        }
    }
}
