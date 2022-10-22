package Less_24_ch_4_Stream_Reduce;
/*
- Метод reduce выполняет терминальные операции сведения, возвращая некоторое значение -
результат операции.
*/
import java.util.List;

public class Less_24_Stream_Reduce_Step4 {
    public static void main(String[] args) {
        // Соединим элементы листа в одну строку
        List<String> rainbow = List.of("Каждый","охотник","желает","знать","где","сидит","фазан.");
        String whole_sentence = rainbow.stream().
                                reduce((firs_word,elem_of_list) -> firs_word + " " + elem_of_list).
                                get();
        System.out.println(whole_sentence);

        System.out.println("-------------------------------------------------");
        // Наш лист не изменился
        rainbow.forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        // Вариант reduce с параметром identity
        String negative_whole_sentence = rainbow.stream().
                reduce("НЕ",(firs_word,elem_of_list) -> firs_word + " " + elem_of_list);
        System.out.println(negative_whole_sentence.replace(".","!"));

    }
}
