### ******************************* Stream API *******************************

Понятие потока далее - стрим (не Thread).

Поток (стрим) - это ключевая абстрактная концепция для обработки коллекций в Java 8. Он может
указывать операции, которые вы хотите выполнить над коллекцией. Стрим может выполнять очень сложные
операции, такие как поиск, фильтрация и отображение данных.

Использование Stream API для управления данными сбора аналогично использованию SQL для выполнения
запросов к базе данных. Stream API обеспечивает эффективный и простой в использовании способ обработки
данных.
```
Стрим:
- канал данных, используемый для управления последовательностью элементов, сгенерированных
источником данных (коллекция, массив и т. Д.);
- последовательность набора данных;
- поток управляемых расчетов и изменений над входными данными;
```
!!! Стрим НЕ !!!
- стрим не хранит элементы;
- стрим не меняет исходный объект, вместо этого он возвращает новый поток, содержащий требуемый результат;
- промежуточные операции стрима выполняются с задержкой. Это означает, что промежуточные методы стрима
  (ленивые - lazy) и ожидают, соответствующего запроса от терминальной операции (которые в свою очередь
  жадные - eager), т.е. когда результаты будут востребованы.

*** Три шага работы потока ***

- Шаг 1 - Создать поток - из источника данных (например: коллекция, массив), получить поток;
- Шаг 2 - Промежуточная операция - промежуточная цепочка операций для обработки данных из источника данных;
- Шаг 3 - Завершить работу (терминальная операция) - операция завершения стрима, которая активирует выполнение
  промежуточную цепочку операций и выдает результат;

### ******************************* Шаг 1 - Создать поток *******************************

Интерфейс Collection в Java8 был расширен, чтобы обеспечить два метода для получения стримов:

- Поток по умолчанию stream (): возвращает стрим последовательности;
- Поток по умолчанию parallelStream (): возвращает параллельный стрим;

Cоздание стрима из массива и коллекции:

- Статический метод *.stream () для коллекций (List)
  - Пример: Stream<String> myStream = rainbow.stream();
- Cтатический метод для массивов Stream (массив T []): возвращает поток
  - Пример: Arrays.stream(new int[]{2, 4, 5, 1}).forEach(System.out::println);

Создание стрима из набора значений используя статический метод Stream.of (n...):
- Синтаксис: public static Stream of (T… values)
  - Пример #1 : Stream<String> strStream = Stream.of("шла","маша","по", "шоссе","и","сосала","сушку");
  - Пример #2 : Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5, 6, 7);

(см. пример [Less_24_ch_7_Stream_Concat](https://github.com/JcoderPaul/JavaExtended-24/tree/master/Less_24_ch_7_Stream_Concat/src/Less_24_ch_7_Stream_Concat))

Существует способ создания бесконечного стрима.
Можно использовать статические методы Stream.iterate () и Stream.generate() для создания бесконечного потока.
 - Синтаксис: public static Stream iterate(final T seed, final UnaryOperator f)
 - Синтаксис: public static Stream generate(Supplier s)

(см. пример [Less_24_ch_18_EndlessStream](https://github.com/JcoderPaul/JavaExtended-24/tree/master/Less_24_ch_18_EndlessStream/src/Less_24_ch_18_EndlessStream))

### *********************** Шаг 2 - Промежуточная операция ***********************

Несколько промежуточных операций могут быть соединены в цепочку через символ '.'
Как уже было сказано выше промежуточные операции не выполняются, до тех пор пока вся цепочка не завершится
терминальной операцией. В момент запуска терминальной операции промежуточные операции обрабатывается
одновременно, что называется «отложенным выполнением».

### *** Скрининг и нарезка ***

- filter (Predicate<? super T> predicate) - получает лямбду на вход, исключает определенные элементы из стрима;
  (см. пример [Less_24_ch_2_Stream_Filter](https://github.com/JcoderPaul/JavaExtended-24/tree/master/Less_24_ch_2_Stream_Filter/src/Less_24_ch_2_Stream_Filter))
- distinct () -	удаляет дублирующиеся элементы из стрима;
  (см. пример [Less_24_ch_2_Stream_Filter](https://github.com/JcoderPaul/JavaExtended-24/tree/master/Less_24_ch_2_Stream_Filter/src/Less_24_ch_2_Stream_Filter))
- limit(long maxSize) - ограничивает стрим сверху, чтобы его элементы не превышали заданное число maxSize;
  (см. пример [Less_24_ch_15_Stream_Limit](https://github.com/JcoderPaul/JavaExtended-24/tree/master/Less_24_ch_15_Stream_Limit/src/Less_24_ch_15_Stream_Limit_Skip) и [Less_24_ch_18_EndlessStream](https://github.com/JcoderPaul/JavaExtended-24/tree/master/Less_24_ch_18_EndlessStream/src/Less_24_ch_18_EndlessStream))
- skip(long n) - ограничивает стрим снизу, пропускает элементы начиная с n-го элемента.
  Если в потоке меньше n элементов, возвращается пустой поток.
  (см. пример [Less_24_ch_15_Stream_Limit](https://github.com/JcoderPaul/JavaExtended-24/tree/master/Less_24_ch_15_Stream_Limit/src/Less_24_ch_15_Stream_Limit_Skip) и [Less_24_ch_18_EndlessStream](https://github.com/JcoderPaul/JavaExtended-24/tree/master/Less_24_ch_18_EndlessStream/src/Less_24_ch_18_EndlessStream))

### *** Картографирование ***

- map(Function f) - получает функцию в качестве параметра, функция будет применена к каждому элементу стрима,
  и преобразовав его, согласно правилам функции, вернет в стрим, как новый (преобразованный)
  элемент.
  (см. пример [Less_24_ch_1_Stream_Map](https://github.com/JcoderPaul/JavaExtended-24/tree/master/Less_24_ch_1_Stream_Map/src/Less_24_ch_1_Stream_Map))
- flatMap(Function f) -	получает функцию в качестве параметра, и заменяет каждое значение в потоке другим
  потоком, а затем соедините все потоки в один поток.
  (см. пример [Less_24_ch_11_Stream_flatMap](https://github.com/JcoderPaul/JavaExtended-24/tree/master/Less_24_ch_11_Stream_flatMap/src/Less_24_ch_11_Stream_flatMap))
- mapToDouble(ToDoubleFunction f) -	получает функцию в качестве параметра, функция будет применена к каждому
  элементу, генерируя новый DoubleStream.
  (см. пример [Less_24_ch_16_Stream_MapToInt](https://github.com/JcoderPaul/JavaExtended-24/tree/master/Less_24_ch_16_Stream_MapToInt/src/Less_24_ch_16_Stream_MapToInt))
- mapToInt(ToIntFunction f)	- получает функцию в качестве параметра, функция будет применена к каждому
  элементу для генерации нового IntStream.
  (см. пример [Less_24_ch_16_Stream_MapToInt](https://github.com/JcoderPaul/JavaExtended-24/tree/master/Less_24_ch_16_Stream_MapToInt/src/Less_24_ch_16_Stream_MapToInt))

### *** Сортировака ***

- sorted() - создает новый стрим, который отсортирован в естественном порядке.
- sorted(Comparator comp) - создать новый стрим, отсортированный по порядку компаратора.
  (см. пример [Less_24_ch_5_Stream_Sorted](https://github.com/JcoderPaul/JavaExtended-24/tree/master/Less_24_ch_5_Stream_Sorted/src/Less_24_ch_5_Stream_Sorted))

### *********************** Шаг 3 - Терминальная операция ***********************

Терминальная операция или операция завершения потока. Терминальные операции призвана получить результат
из стрима (цепочки промежуточных методов). Результатом может быть любое значение, которое не является
стримом, например, List, Integer или даже void.

### *** Найти и сопоставить ***

- allMatch(Predicate p)	- проверяет и возвращает true, если все элементы стрима удовлетворяют
  условию в предикате.
- anyMatch(Predicate p) - проверяет и возвращает true, если хотя бы один элемент стрима удовлетворяет
  условию в предикате.
- noneMatch(Predicate p) - проверяет и возвращает true, если ни один из элементов в стриме не удовлетворяет
  условию в предикате.
- findFirst() -	возвращает первый элемент стрима.
- findAny() - возвращает случайный элемент стрима.
- count() -	возвращает общее количество элементов в стриме.
- max(Comparator c) - возвращает значение максимального элемента в стриме.
- min(Comparator c) - возвращает значение минимального элемента в стриме.
- forEach(Consumer<? super T> action) - для каждого элемента стрима выполняется действие action.

### *** Вернуть коллекцию ***

- <R,A> R collect(Collector<? super T,A,R> collector): добавляет элементы в неизменяемый контейнер с типом 'R'.
Где 'T' представляет тип данных из вызывающего потока, а 'A' - тип данных в контейнере.
- Object[] toArray() - возвращает массив из элементов потока.
