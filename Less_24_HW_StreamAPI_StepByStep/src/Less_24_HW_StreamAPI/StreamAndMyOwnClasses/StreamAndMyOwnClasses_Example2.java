package Less_24_HW_StreamAPI.StreamAndMyOwnClasses;

import Less_24_HW_StreamAPI.StreamAndMyOwnClasses.MySuperHero.SuperHero;

import java.util.ArrayList;
import java.util.List;

public class StreamAndMyOwnClasses_Example2 {
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
                // Дальше по стриму проходят только те у кого в имени есть буква 'т'
                .filter(user -> user.getNameOfHero().contains("т"))
                /*
                Поскольку у нас может и не быть героев с искомой буквой,
                т.е. в принципе фильтр может отсечь все элементы стрима
                и не пустить дальше (не прошли по условию).

                Отсюда возникает ситуация неопределенности и мы точно не
                знаем есть хоть один элемент в стриме или ничего нет. И
                мы пытаемся получить хоть что-то.
                */
                .findAny()
                /*
                Если до текущего момента добрался хотя бы один элемент
                мы выводим его на экран, если нет, то выходит сообщение
                "User not found"
                */
                .ifPresentOrElse(System.out::println, () -> System.out.println("User not found"));
    }
}
