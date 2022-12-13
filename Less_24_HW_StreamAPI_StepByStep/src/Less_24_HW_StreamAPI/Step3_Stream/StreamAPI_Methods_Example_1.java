package Less_24_HW_StreamAPI.Step3_Stream;
/*
Все что приведено в качестве примеров в:
- Less_24_HW_Step1_Lambda
- Less_24_HW_Step2_NearStream
медленно подводило нас к объяснению, что
такое StreamAPI и для чего нужно.

Задача реализованная в Less_24_HW_Step2_NearStream
за счет создания множества коллекций и методов
решается быстрее и короче.
*/
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI_Methods_Example_1 {
    public static void main(String[] args) {
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                numbers.add((int) (Math.random() * 1000));
            }
                    // Создаем стрим из коллекции
            List<String> list = numbers.stream()
                    // Фильтруем на четность, т.е. дальше по стриму летят только четные элемент
                    .filter((n) -> n % 2 == 0)
                    // Преобразуем в строки нужного формата и пропускаем дальше по стриму
                    .map((integer -> "Number: " + integer))
                    // Фильтруем и дальше по стриму проходят строки с '0' на конце
                    .filter((string) -> string.endsWith("0"))
                    // Преобразуем нужный формат (добавляем ! в конце) и пропускаем дальше по стриму
                    .map((string) -> string + "!")
                    /*
                    Терминальная операция - преобразуем в
                    коллекцию (List) результат работы всех
                    методов стрима.
                    */
                    .collect(Collectors.toList());

            list.forEach(s -> System.out.println(s));
    }
}