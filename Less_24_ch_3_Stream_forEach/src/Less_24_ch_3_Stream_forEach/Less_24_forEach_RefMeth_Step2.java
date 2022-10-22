package Less_24_ch_3_Stream_forEach;
/*
void forEach(Consumer<? super T> action): для каждого элемента выполняется действие action.
*/
import Less_24_ch_3_Stream_forEach.MyForEachMethods.MyClassWithMethods;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Less_24_forEach_RefMeth_Step2 {
    public static void main(String[] args) {
        int[] arr_int_foreach = {2, 4, 5, 1, 23, 66, 2, 9, 5};
        Iterator<Integer> integerIterator = Arrays.stream(arr_int_foreach).iterator();
        while (integerIterator.hasNext()){
            System.out.print(integerIterator.next() + " ");
        }
        System.out.println("\n--------- Работает Stream API метод *.forEach с Method References ---------");
        Arrays.
                // Шаг 1. Создаем стрим из массива
                stream(arr_int_foreach).
                // Шаг 2. Печать всех элементов массива без изменений при помощи метод-рефренс
                forEach(System.out::println);
        System.out.println("\n-- Stream API метод *.forEach с Method References на 'самописный' класс --");
        /*
        !!! Мы создали собственный класс, в нем статический метод (набор методов) который проводит некие
        операции, но ничего не возвращает. И теперь мы можем использовать ссылку на этот метод (методы)
        при работе со стримами и не только.
        */
        System.out.println("Деление :");
        Arrays.
                // Шаг 1. Создаем стрим из массива
                stream(arr_int_foreach).
                // Шаг 2. Печать всех элементов массива без изменений при помощи метод-рефренс
                forEach(MyClassWithMethods::divisionMeth);
        System.out.println("\n-- Stream API метод *.forEach с Method References на 'самописный' класс --");
        System.out.println("Умножение :");
        Arrays.
                // Шаг 1. Создаем стрим из массива
                stream(arr_int_foreach).
                // Шаг 2. Печать всех элементов массива без изменений при помощи метод-рефренс
                forEach(MyClassWithMethods::multiplicationMeth);
        System.out.println("\n********* Пример работы Method References с обычным листом *********");
        List<Integer> lst_int = List.of(21,14,56,23,9,6,41,81,45,82); // Фиксированный лист
        /*
        1. Создали собственный класс
        2. В этом классе создали собственные статический метод (методы), под некие задачи
        3. Применили к коллекции LIST метод ForEach со ссылкой на самописный метод самописного класса
        */
        System.out.println("------ УМНОЖЕНИЕ ------");
        lst_int.forEach(MyClassWithMethods::multiplicationMeth); // ForEach со ссылкой на метод
        System.out.println("------ ДЕЛЕНИЕ ------");
        lst_int.forEach(MyClassWithMethods::divisionMeth);
        /*
        Происходит следующее (как я это понимаю):
        - каждый элемент массива (листа, коллекции) помещается в метод forEach (он void), у нас это INT;
        - forEach в свою очередь имеет инструкции обратиться к статическому методу класса MyClassWithMethods;
        - статический метод (он void) этого класса принимает на вход значение INT (пока все нормально);
        - над входными параметрами производятся некие манипуляции и на экран уходит результат;
        */
    }
}
