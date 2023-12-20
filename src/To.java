import java.util.Scanner;

public class To {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int min = Integer.MAX_VALUE;

        while (true) {
            System.out.println("Indtast heltal:");
            System.out.print("> ");
            int indtastning = sc.nextInt();
            if (indtastning == 0) break;
            min = Integer.min(indtastning, min);
        }

        System.out.printf("Mindste tal: %d", min);
    }
}
