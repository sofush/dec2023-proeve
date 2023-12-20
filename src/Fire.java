import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;

public class Fire {
    public static void main(String[] args) throws FileNotFoundException {
        Path sti = Path.of("./input/fire.txt");
        File file = new File(sti.toUri());
        Scanner sc = new Scanner(file);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int n = 0;

        while (true) {
            int indtastning = 0;
            try {
                indtastning = sc.nextInt();
            } catch (Exception e) {
                // Input sluttede sikkert her. Ignorer.
            }
            if (indtastning == 0) break;
            min = Integer.min(indtastning, min);
            max = Integer.max(indtastning, max);
            sum += indtastning;
            n++;
        }

        System.out.printf("Mindste tal: %d%n", min);
        System.out.printf("Største tal: %d%n", max);
        System.out.printf("Gennemsnit: %d%n", sum / n);
    }
}
