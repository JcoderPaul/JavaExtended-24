package Less_24_ch_3_Stream_forEach.MyForEachMethods;

public class MyClassWithMethods {
    public static void divisionMeth(int elem){
        System.out.print("Элемент на входе -> '" + elem);
        elem /= 2;
        System.out.println("' Элемент на выходе -> '" + elem + "'");
    }

    public static void multiplicationMeth(int elem){
        System.out.print("Элемент на входе -> '" + elem);
        elem *= 2;
        System.out.println("' Элемент на выходе -> '" + elem + "'");
    }
}
