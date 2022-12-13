package Less_24_HW_StreamAPI.Step1_Lambda;

import Less_24_HW_StreamAPI.Step1_Lambda.MyClasses.Sauron;
import Less_24_HW_StreamAPI.Step1_Lambda.MyClasses.Slave;

public class TestFirstLambdaApp {
    public static void main(String[] args) {
        // Создаем объект Sauron
        Sauron sauronGreatAndTerrible = new Sauron();
        /*
        Создаем объект Slave через анонимный класс,
        'первый вариант' обращения к функциональному
        интерфейсу.
        */
        Slave orcOne = new Slave() {
            // Наш орк должен реализовать волю хозяина count - раз
            @Override
            public String obeyTheMastersOrders(int count) {
                for (int i = 0; i < count; i++){
                    System.out.println("Подпрыгнул на месте " + (i + 1) + " раз!");
                }
                return "Приказ выполнен мой владыка!";
            }
        };
        /*
        Теперь объект Slave создается при помощи
        Lambda выражения, 'второй способ' обращения
        к функциональному интерфейсу и код стал чуть
        короче.
        */
        Slave orcTwo = (n) -> {
            for (int i = 0; i < n; i++) {
                System.out.println("Срубил " + (i + 1) + " дерево!");
            }
            return "Роща вырублена мой повелитель!";
        };
        String resultOne = sauronGreatAndTerrible.subjugate(orcOne, 5);
        System.out.println(resultOne);
        System.out.println("-----------------------------------------------------");
        String resultTwo = sauronGreatAndTerrible.subjugate(orcTwo, 5);
        System.out.println(resultTwo);
        System.out.println("-----------------------------------------------------");
        /*
        Мы точно знаем, что метод *.subjugate() принимает два параметра,
        объект реализующий метод функционального интерфейса и некое int.
        Поэтому мы можем сразу в методе создать или анонимный класс, или
        Lambda выражение.
        */
        String resultThree = sauronGreatAndTerrible.subjugate(
                count -> {
                    while (!(count < 1)){
                        System.out.println("Поймал " + (6 - count) + " эльфа.");
                        count--;
                    }
                return "Воля господина выполнена!";}, 5);
        System.out.println(resultThree);
        /*
        Не сложно заметить, что имея единственный
        метод мы получаем на его выходе различные
        результаты. Это простой пример для
        наглядности. Естественно реализация метода
        может быть сложнее.
        */
    }
}
