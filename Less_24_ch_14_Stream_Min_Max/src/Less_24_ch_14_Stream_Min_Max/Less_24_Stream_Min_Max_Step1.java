package Less_24_ch_14_Stream_Min_Max;
/*
- Optional<T> min(Comparator<? super T> comparator): возвращает минимальный элемент из потока.
  Для сравнения элементов применяется компаратор comparator. Терминальная операция.
*/
import Less_24_ch_14_Stream_Min_Max.MyFavoriteStudents.GoodStudent;

import java.util.ArrayList;
import java.util.List;

public class Less_24_Stream_Min_Max_Step1 {
    public static void main(String[] args) {
        List<GoodStudent> stud_for_sorting = new ArrayList<>();
        stud_for_sorting.add(new GoodStudent("Альтавус",'m',19,5,4.5));
        stud_for_sorting.add(new GoodStudent("Вектрус",'m',17,3,5.3));
        stud_for_sorting.add(new GoodStudent("Санара",'f',17,4,9.9));
        stud_for_sorting.add(new GoodStudent("Тильн",'m',21,2,6.8));
        stud_for_sorting.add(new GoodStudent("Акация",'f',23,3,8.1));
        stud_for_sorting.add(new GoodStudent("Абраксас",'m',32,5,9.4));
        stud_for_sorting.add(new GoodStudent("Септиам",'m',19,3,7.4));
        System.out.println("------------- NOT SORTED -------------");
        for (GoodStudent stprn: stud_for_sorting){
            System.out.println(stprn);
        }
        System.out.println("------------- MIN BY STREAM -------------");
        /*
        Для элементов с большим количеством параметров мы определяем, как
        (по какому параметру искать) MIN. Метод *.min() требует компаратор на вход.
        Метод возвращает Optional и значит его рекомендуется проверить на наличие,
        перед окончанием стрима.

        Выберем самый минимальный возраст (в нашем листе таких 1-н).
         */
        stud_for_sorting.stream(). // Формируем стрим
                min((std_1,std_2) -> std_1.getAge() - std_2.getAge()). // Выбираем самого юного
                ifPresent(System.out::println); // Если таковой есть печатаем
        System.out.println("------------- MAX BY STREAM -------------");
        /*
        Для элементов с большим количеством параметров мы определяем, как
        (по какому параметру искать) MAX. Метод *.max() требует компаратор на вход.
        Метод возвращает Optional и значит его рекомендуется проверить на наличие,
        перед окончанием стрима.

        Выберем самый максимальный курс (в нашем листе таких 2-е), при совпадении курсов
        выберем студента с максимальной успеваемостью
         */
        stud_for_sorting.stream().
                max((std_1,std_2) -> {
                    int res = (int) (std_1.getAvgGrade() - std_2.getAvgGrade());
                    if(std_1.getCourse() - std_2.getCourse() == 0){
                        return res;
                    } else if (std_1.getCourse() - std_2.getCourse() > 0) {
                        return +1;
                    } else
                        return -1;
                }).
                ifPresent(System.out::println);
    }
}
