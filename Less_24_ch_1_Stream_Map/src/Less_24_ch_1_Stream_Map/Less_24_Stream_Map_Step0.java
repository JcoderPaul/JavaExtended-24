package Less_24_ch_1_Stream_Map;
/*
Stream - стремнина, течь, ручей, струя. Их еще называют потоками, но это не Thread.
Основные особенности стримов:
- Стримы не хранят элементы. Элементы, используемые в стримах, могут храниться в коллекции, либо
при необходимости могут быть напрямую сгенерированы.
- Операции со стримами не изменяют источника данных. Операции со стримами лишь возвращают новый
стрим с результатами этих операций.
- Для стримов характерно отложенное выполнение. То есть выполнение всех операций со стримами происходит
лишь тогда, когда выполняется терминальная операция и возвращается конкретный результат, а не новый стрим.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
<R> Stream<R> map(Function<? super T,? extends R> mapper): преобразует элементы типа T в элементы типа R и
возвращает поток с элементами R. Промежуточная операция.
*/
public class Less_24_Stream_Map_Step0 {
    public static void main(String[] args) {
        //*************************************************************************************
        List<String> raduga = new ArrayList<>();
        raduga.add("Каждый");
        raduga.add("охотник");
        raduga.add("желает");
        raduga.add("знать");
        raduga.add("где");
        raduga.add("сидит");
        raduga.add("фазан");
        /*
        Формируем стрим (словно в капилярную трубку заливаем воду)
        */
        Stream<String> myStream = raduga.stream();
        System.out.println("--------------------------------------");
        myStream.forEach(System.out::println);
        /*
        Стрим можно создать 'налету' и далее проводит работу с ним.
        */
        Stream<String> strStream = Stream.of("шла","маша","по", "шоссе","и","сосала","сушку");
        System.out.println("--------------------------------------");
        strStream.forEach(System.out::println);
    }
}
