import java.util.Arrays;
import java.util.Scanner;

public class Et {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;

        for (int i = 0; i < 8; i++) {
            System.out.println("Indtast heltal:");
            System.out.print("> ");
            sum += sc.nextInt();
        }

        System.out.printf("Gennemsnit: %d", sum / 8);
    }
}
