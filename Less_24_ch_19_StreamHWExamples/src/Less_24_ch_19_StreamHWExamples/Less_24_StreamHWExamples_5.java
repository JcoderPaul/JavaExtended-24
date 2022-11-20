package Less_24_ch_19_StreamHWExamples;

import Less_24_ch_19_StreamHWExamples.MyClassesForTask.Person;

import java.util.Comparator;
import java.util.List;

/*
Дан класс с полями: firstName, lastName, age.
Вывести полное имя самого старого человека,
у которого длина полного имени не превышает
15 символов.
*/
public class Less_24_StreamHWExamples_5 {
    public static void main(String[] args) {
        List<Person> myHeroForTest = List.of(
                new Person("Санара", "Куэста", 17),
                new Person("Малкольм", "Стоун", 19),
                new Person("Дуглас", "Линд", 18),
                new Person("Вэй", "Лин", 17),
                new Person("Иоланта", "Висинска", 20),
                new Person("Говард", "Аддингтон", 118)
        );

        myHeroForTest.stream()
                .filter(person -> person.getFullName().length() < 15)
                .max(Comparator.comparing(person -> person.getAge()))
                .map(person -> person.getFullName())
                .ifPresent(System.out::println);

    }
}
