package Less_24_ch_16_Stream_MapToInt;

import Less_24_ch_16_Stream_MapToInt.MyFavoriteStudents.GoodStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
- mapToInt(ToIntFunction function) - метод, получив функцию function в качестве параметра,
будет применять её к каждому элементу для генерации нового IntStream.
*/
public class Less_24_Stream_MapToDouble_Step2 {
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

        System.out.println("------------- MAP_TO_DOUBLE BY STREAM -------------");
        /*
        Метод mapToDouble получив на вход стрим, а в параметрах некую функцию преобразования, должна
        на выходе отдать стрим Double, который мы можем применить по собственному усмотрению пример
        см. ниже
        */
        List<Double> list_of_avgGrade = stud_for_sorting.stream(). // Получили стрим
                mapToDouble(stud -> stud.getAvgGrade()). // Из элементов студент извлекли интовые значения course
                // Поскольку мы получили int, а нам нужен Integer, применяем боксинг или метод *.boxed()
                boxed(). // Поскольку у нас double элементы, их нужно упаковать в Double
                collect(Collectors.toList()); // Формируем лист Double
        for (Double prnDoub: list_of_avgGrade) {
            System.out.print(" '" + prnDoub + "' ");
        }
    }
}
