package Less_24_ch_12_Stream_Collect.MyCollector;

public class StringCombiner {
    private String delim;
    private String prefix;
    private String suffix;

    private boolean areAtStart = true;
    private StringBuilder sb = new StringBuilder();

    public StringCombiner(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    /*
    Функция добавления элемента для конкатенации:
    - параметр 'elem' - элемент для добавления;
    - return возвращает текущий объект класса;
     */
    public StringCombiner add(String elem) {
        if (areAtStart) {
            sb.append(prefix);
            areAtStart = false;
        } else {
            sb.append(delim);
        }
        sb.append(elem);

        return this;
    }

    /*
    Функция объединения контейнеров:
    - параметр other - контейнер для объединения с текущим контейнером;
    - return - возвращает текущий объект класса;
     */
    public StringCombiner merge(StringCombiner other) {
        sb.append(other.sb);
        return this;
    }

    /*
    Функция добавления отформатированого вывода контейнера
    - return - возвращает строку
    */
    @Override
    public String toString() {
        sb.append(suffix);
        return sb.toString();
    }
}
