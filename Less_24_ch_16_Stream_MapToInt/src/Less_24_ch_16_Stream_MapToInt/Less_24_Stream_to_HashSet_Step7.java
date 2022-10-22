package Less_24_ch_16_Stream_MapToInt;

import java.util.*;
import java.util.stream.Collectors;

public class Less_24_Stream_to_HashSet_Step7 {
    public static void main(String[] args) {

        List<String> phones = new ArrayList<>();
        Collections.addAll(phones, "iPhone 13", "REALME C30", "Huawei Y5PP",
                "Samsung Galaxy A51", "Lenovo i750", "Xiaomi Redmi 9A", "INFINIX Note 10 Pro 8",
                "Honor X8", "Motorola Defy 4", "HTC Wildfire E2");

        /*
        Выражение 'HashSet::new' представляет функцию создания коллекции. Аналогичным образом
        можно получать другие коллекции, например, ArrayList (это ссылки на методы или
        Method References):

        ArrayList<String> result = phones.collect(Collectors.toCollection(ArrayList::new));

        (см. прим Less_24_ch_3_Stream_forEach\ReadMe.txt)
        */
        HashSet<String> filteredPhones = phones.stream().
                filter(s->s.length()<13).
                collect(Collectors.toCollection(HashSet::new));

        filteredPhones.forEach(s->System.out.println(s));
    }
}
