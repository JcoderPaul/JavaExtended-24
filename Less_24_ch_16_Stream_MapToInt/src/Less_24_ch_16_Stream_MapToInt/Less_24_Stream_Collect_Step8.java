package Less_24_ch_16_Stream_MapToInt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Less_24_Stream_Collect_Step8 {
    public static void main(String[] args) {

        List<String> phones = new ArrayList<>();
        Collections.addAll(phones, "iPhone 13", "REALME C30", "Huawei Y5PP",
                "Samsung Galaxy A51", "Lenovo i750", "Xiaomi Redmi 9A", "INFINIX Note 10 Pro 8",
                "Honor X8", "Motorola Defy 4", "HTC Wildfire E2");

        ArrayList<String> filteredPhones = phones.stream().
                filter(s->s.length()<17)
                .collect(()->new ArrayList<String>(), // Cоздаем ArrayList
                         (list, item)->list.add(item), // Добавляем в список элемент
                         (list1, list2)-> list1.addAll(list2)); // Добавляем в список другой список

        filteredPhones.forEach(System.out::println);
    }
}
