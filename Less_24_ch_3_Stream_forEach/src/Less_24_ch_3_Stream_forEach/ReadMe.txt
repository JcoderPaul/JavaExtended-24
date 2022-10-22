*** Cсылки на методы или Method References ***
Если лямбда выражения вызывают только один существующий метод, лучше ссылать на этот метод по его имени.
Ссылки на методы (Method References) – это компактные лямбда выражения для методов у которых уже есть имя.
----------------------------------------------------------------------------------------------------------
Например:

- Consumer<String> consumer = str -> System.out.println(str);

можно переписать с помощью method references:

- Consumer<String> consumer = System.out::println;
----------------------------------------------------------------------------------------------------------
Ссылки на методы бывают четырех видов:

Ссылка на статический метод <-> ContainingClass::staticMethodName
Ссылка на нестатический метод конкретного объекта <-> containingObject::instanceMethodName
Ссылка на нестатический метод любого объекта конкретного типа <-> ContainingType::methodName
Ссылка на конструктор <-> ClassName::new
----------------------------------------------------------------------------------------------------------
*** 2. Ссылка на статический метод ***
Синтаксис: ContainingClass::staticMethodName

Например:
Function<String, Boolean> function = e -> Boolean.valueOf(e);
System.out.println(function.apply("TRUE"));

Перепишем с помощью ссылки:
Function<String, Boolean> function = Boolean::valueOf;
System.out.println(function.apply("TRUE"));

----------------------------------------------------------------------------------------------------------
*** 3. Ссылка на нестатический метод конкретного объекта ***
Синтаксис: containingObject::instanceMethodName
Этот тип используется когда лямбда выражение вызывает метод внешнего уже существующего объекта.

Пример №1:
Consumer<String> consumer = e -> System.out.println(e);
consumer.accept("OCPJP 8");

Перепишем, используя ссылку:
Consumer<String> consumer = System.out::println;
consumer.accept("OCPJP 8");

Пример №2:
Integer integer = 5;
Supplier<String> supplier = () -> integer.toString();
System.out.println(supplier.get());

Перепишем:
Integer integer = 5;
Supplier<String> supplier = integer::toString;
System.out.println(supplier.get());

----------------------------------------------------------------------------------------------------------
*** 4. Ссылка на нестатический метод любого объекта конкретного типа ***
Синтаксис: ContainingType::methodName

Например:
Function<String, String> function = s -> s.toLowerCase();
System.out.println(function.apply("OCPJP 8"));

Перепишем:
Function<String, String> function = String::toLowerCase;
System.out.println(function.apply("OCPJP 8"));

----------------------------------------------------------------------------------------------------------
*** 5. Ссылка на конструктор ***
Синтаксис: ClassName::new
ClassName не может быть абстрактным классом или интерфейсом.

Например:
Function<String, Integer> function = (d) -> new Integer(d);
System.out.println(function.apply("4"));

Перепишем:
Function<String, Integer> function = Integer::new;
System.out.println(function.apply("4"));
----------------------------------------------------------------------------------------------------------