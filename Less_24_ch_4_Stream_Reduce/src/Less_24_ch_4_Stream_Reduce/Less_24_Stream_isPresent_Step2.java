package Less_24_ch_4_Stream_Reduce;
/*
- Метод reduce выполняет терминальные операции сведения, возвращая некоторое значение -
результат операции.
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Less_24_Stream_isPresent_Step2 {
    public static void main(String[] args) {
        List<Integer> empty_arr_int = new ArrayList<>();
        /* ******************************************************************************
        !!! Если применить метод reduce к пустой коллекции, в том исполнении, как у нас

        int result_of_reduce =
                // Создали стрим из листа
                empty_arr_int.stream().
                // Применили метод reduce к пустому листу
                reduce((accumulator, element) -> accumulator*element).
                // Возвращаем результат операций над стримом, терминальная операция
                get();
        System.out.println(result_of_reduce);

        то вылетит исключение:
        Exception in thread "main" java.util.NoSuchElementException: No value present

        Чтобы избежать этого нужно применять проверку isPresent!!!
        ****************************************************************************** */

        /*
        Класс Optional обладает свойствами 'Кота Шредингера'. Т.е. бывают ситуации когда при написании
        кода разработчик не может точно знать — будет ли существовать нужный объект на момент исполнения
        данного отрезка кода (программы) или нет. В таких случаях приходится делать проверки на null.
        Если такими проверками пренебречь, то рано или поздно (обычно рано) программа выкинет исключение.
        */
        Optional<Integer> my_opt = empty_arr_int.stream().reduce((accumulator, element) -> accumulator*element);
        if(my_opt.isPresent()){
            System.out.println(my_opt.get());
        } else {
            System.out.println("Not present!");
        }



    }
}
