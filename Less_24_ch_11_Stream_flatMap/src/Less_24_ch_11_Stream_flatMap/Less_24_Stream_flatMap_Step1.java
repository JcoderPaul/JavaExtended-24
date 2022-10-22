package Less_24_ch_11_Stream_flatMap;
/*
- <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper): позволяет преобразовать
элемент типа <T> в несколько элементов типа <R> и возвращает поток с элементами R. Промежуточная операция.
Т.е. как вариант, когда мы имеем коллекцию, содержащую набор других коллекций и нам необходимо поработать с
элементами элементов, или с содержимым внутренних коллекций.
*/
import Less_24_ch_11_Stream_flatMap.MyOwnUniversity.Faculty;
import Less_24_ch_11_Stream_flatMap.MyOwnUniversity.Student;

import java.util.ArrayList;
import java.util.List;

public class Less_24_Stream_flatMap_Step1 {
    public static void main(String[] args) {
        // Создали объекты класса Student (Студент)
        Student st_1 = new Student("Альтавус",'m',19,2,4.5);
        Student st_2 = new Student("Вектрус",'m',29,3,5.3);
        Student st_3 = new Student("Санара",'f',17,1,9.9);
        Student st_4 = new Student("Тильн",'m',21,2,6.8);
        Student st_5 = new Student("Акация",'f',23,3,8.1);
        Student st_6 = new Student("Дорум",'m',31,5,9.4);
        Student st_7 = new Student("Тайрина",'f',19,3,7.4);
        Student st_8 = new Student("Ульма",'f',24,5,4.4);
        // Создали объекты класса Faculty (Факультет)
        Faculty faculty_economy = new Faculty("Экономический фк.");
        Faculty faculty_physics = new Faculty("Физический фк.");
        /*
        При создании факультета, в конструкторе создается новый лист студентов.
        Заполняем эти листы, по 4-и студента на факультет
        */
        faculty_economy.addStudentsOnFaculty(st_1);
        faculty_economy.addStudentsOnFaculty(st_2);
        faculty_economy.addStudentsOnFaculty(st_3);
        faculty_economy.addStudentsOnFaculty(st_4);

        faculty_physics.addStudentsOnFaculty(st_5);
        faculty_physics.addStudentsOnFaculty(st_6);
        faculty_physics.addStudentsOnFaculty(st_7);
        faculty_physics.addStudentsOnFaculty(st_8);
        // Создадим лист факультетов (Университет) и добавим туда наши факультеты
        List<Faculty> my_university = new ArrayList<>();
        my_university.add(faculty_economy);
        my_university.add(faculty_physics);

        System.out.println("------------- STREAM WORK -------------");
        // Создаем стрим от листа my_university
        my_university.stream().
                /*
                Все делается по шагам и для каждого факультета. Сначала пропускаем в стрим элемент,
                у нас это факультет. Метод peek отражает работу нашей стрим конструкции.
                */
                peek(faculty_name ->
                        System.out.println("\n**** Метод peek -> " + faculty_name.getName_of_faculty() + " ****")).
                /*
                Для каждого факультета запускается метод достающий лист студентов и на этот лист
                студентов создается свой стрим. Далее происходит работа с этим стримом.
                */
                flatMap(faculty -> faculty.getStudents_on_faculty().stream()).
                peek(student -> System.out.println("Метод peek -> " + student.getName())).
                /*
                На экран уходит список всех студентов всех факультетов, но для наглядности, мы
                применили метод peek, чтобы наглядно видеть как и что взаимодействует в стриме-стримов.
                 */
                forEach(student -> System.out.println(student));
    }
}
