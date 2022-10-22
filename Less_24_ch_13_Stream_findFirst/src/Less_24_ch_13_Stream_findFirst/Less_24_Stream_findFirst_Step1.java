package Less_24_ch_13_Stream_findFirst;
/*
- Optional<T> findFirst(): возвращает первый элемент из потока.
*/
import Less_24_ch_13_Stream_findFirst.MyOwnClasses.Student;

import java.util.ArrayList;
import java.util.List;

public class Less_24_Stream_findFirst_Step1 {
    public static void main(String[] args) {
        List<Student> stud_for_sorting = new ArrayList<>();
        stud_for_sorting.add(new Student("Альтавус",'m',19,2,4.5));
        stud_for_sorting.add(new Student("Вектрус",'m',29,3,5.3));
        stud_for_sorting.add(new Student("Санара",'f',17,1,9.9));
        stud_for_sorting.add(new Student("Тильн",'m',21,2,6.8));
        stud_for_sorting.add(new Student("Акация",'f',23,3,8.1));
        stud_for_sorting.add(new Student("Дорум",'m',31,5,9.4));
        stud_for_sorting.add(new Student("Тайрина",'f',19,3,7.4));
        stud_for_sorting.add(new Student("Ульма",'f',24,5,4.4));
        System.out.println("------------- NOT SORTED -------------");
        for (Student stprn: stud_for_sorting){
            System.out.println(stprn);
        }
        System.out.println("------------- STREAM WORK -------------");
        /*
        1. Все буквы имен сделать заглавными
        2. Отфильтровать по полу, только девушек
        3. Отсортировать по возрасту и вывести на экран результат
        */

        stud_for_sorting.stream(). // Формируем стрим
                /* Промежуточный оператор (на входе стрим и на выходе стрим) */
                        map(stud -> { // Берем поочередно каждого студента
                    stud.setName(stud.getName().toUpperCase()); // Перезаписываем его имя в верхнем регистре
                    return stud;}). // Возвращаем результат работы в стрим
                /* Промежуточный оператор (на входе стрим и на выходе стрим) */
                        filter(stud -> stud.getSex() == 'f'). // Берем только студентов у кого *.getSex() == 'f'
                /* Промежуточный оператор (на входе стрим и на выходе стрим) */
                        sorted((st_1, st_2) -> st_1.getAge() - st_2.getAge()). // Сортируем по возрасту используя Comparator
                /* Терминальный оператор (без него остальные отложенные методы не запустятся) */
                        findFirst(). // Найти (взять) первый элемент в стриме (метод возвращает Optional)
                        ifPresent(System.out::println); // Проверяем есть ли объект, при наличии печатаем
    }
}
