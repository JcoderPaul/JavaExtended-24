package Less_24_ch_16_Stream_MapToInt;

import Less_24_ch_16_Stream_MapToInt.MyFavoriteStudents.GoodStudent;

import java.util.ArrayList;
import java.util.List;

public class Less_24_MapToInt_Math_Op_Step3 {
    public static void main(String[] args) {
        List<GoodStudent> stud_for_sorting = new ArrayList<>();
        stud_for_sorting.add(new GoodStudent("Фрам",'m',19,5,4.5));
        stud_for_sorting.add(new GoodStudent("Эфель",'m',17,3,5.3));
        stud_for_sorting.add(new GoodStudent("Санара",'f',17,1,9.9));
        stud_for_sorting.add(new GoodStudent("Тикан",'m',26,2,6.8));
        stud_for_sorting.add(new GoodStudent("Аманет",'f',23,3,8.1));
        stud_for_sorting.add(new GoodStudent("Абраксас",'m',32,5,9.4));
        stud_for_sorting.add(new GoodStudent("Ритан",'m',21,6,7.4));
//********************************************************************************************************
        int sum_age_of_student = stud_for_sorting.stream().
                mapToInt(st -> st.getAge()).
                sum();
        System.out.println("Сумма возрастов всех студентов -> " + sum_age_of_student);

        double avg_of_course = stud_for_sorting.stream().
                mapToInt(st -> st.getCourse()).
                average().
                getAsDouble();
        System.out.println("Среднее значение всех курсов -> " + avg_of_course);

        int min_of_course = stud_for_sorting.stream().
                mapToInt(st -> st.getCourse()).
                min().
                getAsInt();
        System.out.println("Минимальное значение курса -> " + min_of_course);

        double max_of_avgGrade = stud_for_sorting.stream().
                mapToDouble(st -> st.getAvgGrade()).
                max().
                getAsDouble();
        System.out.println("Максимальная средняя оценка -> " + max_of_avgGrade);

    }
}
