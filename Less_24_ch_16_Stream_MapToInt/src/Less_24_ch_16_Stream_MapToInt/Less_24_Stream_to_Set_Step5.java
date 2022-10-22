package Less_24_ch_16_Stream_MapToInt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Less_24_Stream_to_Set_Step5 {
    public static void main(String[] args) {

        List<String> phones = new ArrayList<>();
        Collections.addAll(phones, "iPhone 13", "REALME C30", "Huawei Y5PP",
                "Samsung Galaxy A51", "Lenovo i750", "Xiaomi Redmi 9A", "INFINIX Note 10 Pro 8",
                "Honor X8", "Motorola Defy 4", "HTC Wildfire E2");

        Set<String> filteredPhones = phones.stream()
                .filter(s->s.length()<13)
                .collect(Collectors.toSet());

        for(String s : filteredPhones){
            System.out.println(s);
        }
    }
}
