package Less_24_ch_18_EndlessStream.MySpecialClasses;
/*
Класс для получения очередного числа Фибоначчи

!!! Вспомним !!!
Supplier<T> не принимает никаких аргументов, но должен возвращать объект типа <T>:

public interface Supplier<T> {
    T get();
}
*/

import java.util.function.Supplier;

public class SupplierFibonacci implements Supplier<Integer> {
    private int prev = 0;
    private int next = 1;

    @Override
    public Integer get() {
        int current = next;

        next += prev;
        prev = current;

        return current;
    }
}
