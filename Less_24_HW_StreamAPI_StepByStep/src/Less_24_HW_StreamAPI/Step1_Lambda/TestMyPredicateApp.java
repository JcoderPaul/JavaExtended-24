package Less_24_HW_StreamAPI.Step1_Lambda;

import Less_24_HW_StreamAPI.Step1_Lambda.MyClasses.MyPredicate;

import java.util.ArrayList;
import java.util.List;

public class TestMyPredicateApp {
    public static void main(String[] args) {
        // Шаг 1 - Создаем список и заполняем его 100 случайными элементами
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add((int) (Math.random() * 1000));
        }
        /*
        Шаг 3.1 - Вся подготовка была проделана на шаге 1 и 2,
        теперь осталось отфильтровать нашу исходную коллекцию.
        Условие простое - элемент попадающий в новую коллекцию
        должен быть больше нуля.
        */
        List<Integer> filteredOnlyGreaterThanZero = filter(numbers, (n) -> n > 0);
        for (int i : filteredOnlyGreaterThanZero) {
            System.out.print(i + " ");
        }
        /*
        Шаг 3.2 - Вся подготовка была проделана на шаге 1 и 2,
        теперь осталось отфильтровать нашу исходную коллекцию.
        Условие простое - элемент попадающий в новую коллекцию
        должен быть четным.
        */
        System.out.println("\n--------------------------------------------");
        List<Integer> filteredOnlyEven = filter(numbers, n -> n % 2 == 0);
        for (int i : filteredOnlyEven) {
            System.out.print(i + " ");
        }
        /*
        Шаг 3.3 - Что происходит на шагах 3.1 и 3.2 более менее
        понятно. А теперь отфильтруем уже отфильтрованное,
        например коллекцию, полученную на шаге 3.1.
        Условие простое - элемент попадающий в новую коллекцию
        должен делиться на 5-ть без остатка.
        */
        System.out.println("\n--------------------------------------------");
        List<Integer> divisibleByFiveWithoutRemainder = filter(filteredOnlyGreaterThanZero, n -> n % 5 == 0);
        for (int i : divisibleByFiveWithoutRemainder) {
            System.out.print(i + " ");
        }
        /*
        !!! Развлекаться так можно долго. В итоге
        мы плодим новые коллекции - занимаем машинную
        память. А поскольку фильтрация не единственное
        преобразование которое можно применять к
        коллекциям, массивам и потокам данных, то
        количество коллекций и реализаций разнообразных
        методов преобразования может значительно возрасти.

        Также, нужно помнить, что в принципе задачи
        программиста по большей части однообразны и
        большинство методов можно стандартизировать
        и упростить - превратить в функции. !!!
        */
    }
    /*
    Шаг 2 - Создаем статический метод *.filter(), который принимает
    коллекцию <Integer> и объект подписанный на функциональный интерфейс
    MyPredicate. Возвращает наш метод тоже коллекцию <Integer>
    */
    private static List<Integer> filter(List<Integer> list, MyPredicate predicate) {
        // Создаем коллекцию которую метод вернет
        List<Integer> result = new ArrayList<>();
        // В цикле заполним новую коллекцию, согласно условию
        for (int i : list) {
            /*
            Если элемент первичной коллекции, поступившей
            в качестве аргумента, проходит по условиям метода
            *.test() функционального интерфейса MyPredicate,
            то он попадает в отфильтрованную коллекцию ...
            */
            if (predicate.test(i)) {
                result.add(i);
            }
        }
        // ... и мы получаем результат работы текущего метода
        return result;
    }
}
