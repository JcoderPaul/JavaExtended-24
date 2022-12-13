package Less_24_HW_StreamAPI.Step3_Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI_Methods_Example_2 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add((int) (Math.random() * 100 + 100));
        }
        // Присваиваем новой коллекции результаты работы стрима
        List<String> result =
                // Создаем стрим
                numbers.stream()
                        // Дальше проходят только четные и делящиеся на 5 без остатка
                       .filter((integer -> integer % 2 == 0 && integer % 5 == 0))
                        // Integer превратился в Double, из дошедших сюда элементов извлекли корень
                       .map(a -> Math.sqrt(a))
                        // Результаты превратили в строки
                       .map(str -> "Sqrt: " + str)
                        // Все элемента стрима, что добрались досюда превращаем в коллекцию
                       .collect(Collectors.toList());

        result.forEach(System.out::println);
    }
}
