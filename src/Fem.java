import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Fem {
    public static int antalForekomster(char[] karTabel, char kar) {
        int antal = 0;

        for (char k : karTabel) {
            if (k == kar) antal++;
        }

        return antal;
    }

    public static void main(String[] args) {
        System.out.println("Printer forekomster af hhv. bogstaverne 'a', 'b' og 'c' i følgende char array: abacb");
        char[] arr = new char[5];
        arr[0] = 'a';
        arr[1] = 'b';
        arr[2] = 'a';
        arr[3] = 'c';
        arr[4] = 'b';
        System.out.printf("Forekomster af 'a': %d%n", antalForekomster(arr, 'a'));
        System.out.printf("Forekomster af 'b': %d%n", antalForekomster(arr, 'b'));
        System.out.printf("Forekomster af 'c': %d%n", antalForekomster(arr, 'c'));
    }
}
