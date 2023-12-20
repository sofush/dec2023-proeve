import java.util.Scanner;

public class Tre {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int n = 0;

        while (true) {
            System.out.println("Indtast heltal:");
            System.out.print("> ");
            int indtastning = sc.nextInt();
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
