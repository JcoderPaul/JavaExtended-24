package Less_24_HW_StreamAPI.StreamAndMyOwnClasses;

import Less_24_HW_StreamAPI.StreamAndMyOwnClasses.MySuperHero.SuperHero;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamAndMyOwnClasses_Example1 {
    public static void main(String[] args) {
        // Создаем список наших супер-героев
        List<SuperHero> superHeroList = new ArrayList<>();
        superHeroList.add(new SuperHero("Малкольм Стоун", 19));
        superHeroList.add(new SuperHero("Санара Куэста", 17));
        superHeroList.add(new SuperHero("Дуглас Линд", 18));
        superHeroList.add(new SuperHero("Александр Сиддиг", 54));
        superHeroList.add(new SuperHero("Таймус Роддерик", 97));
        superHeroList.add(new SuperHero("Вэй Су По", 16));
        superHeroList.add(new SuperHero("Говард Аддингтон", 146));
        superHeroList.add(new SuperHero("Аэрдол", 654));
        // Создаем стрим из коллекции
        superHeroList.stream()
                // Сортируем при помощи компаратора
                .sorted(Comparator.comparing(SuperHero::getNameOfHero))
                // Пропускаем дальше, по стриму тех, кому меньше 40
                .filter(SuperHero -> SuperHero.getAgeOfHero() < 40)
                // Пропускаем дальше первых 3-х
                .limit(3)
                // Пропускаем дальше только имя героя
                .map(superHero -> superHero.getNameOfHero())
                // Терминальная операция - вывод на экран
                .forEach(System.out::println);
    }
}
