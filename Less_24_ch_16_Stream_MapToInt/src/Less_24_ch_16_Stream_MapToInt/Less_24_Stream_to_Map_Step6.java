package Less_24_ch_16_Stream_MapToInt;

import Less_24_ch_16_Stream_MapToInt.MyPhones.Phone;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Less_24_Stream_to_Map_Step6 {
    public static void main(String[] args) {

        Stream<Phone> phoneStream = Stream.of(
                new Phone("iPhone 13", 54000),
                new Phone("REALME C30", 15000),
                new Phone("Huawei Y5P", 23000),
                new Phone("Samsung Galaxy A51", 28000),
                new Phone("Xiaomi Redmi 9A", 12000),
                new Phone("INFINIX Note 10 Pro 8", 11500),
                new Phone("Honor X8", 9900),
                new Phone("Motorola Defy 4", 17600),
                new Phone("HTC Wildfire E2", 14300));
        /*
        Формируем мапу, лямбда-выражение p->p.getName() получает значение для ключа элемента,
        а t->t.getPrice() - извлекает данные для значения элемента под ключом.
        */
        Map<String, Integer> phones = phoneStream
                .collect(Collectors.toMap(p->p.getName(), t->t.getPrice()));

        phones.forEach((k,v)->System.out.println("Ключ - > " + k + " , значение под ключом -> " + v));
    }
}
