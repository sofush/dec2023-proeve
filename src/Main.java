import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vælg et tal fra 1-7 for at køre det respektive program:");

        int valg = 0;
        while (true) {
            try {
                System.out.print("> ");
                String input = sc.nextLine();
                valg = Integer.parseInt(input);

                if (valg < 1 || valg > 7) {
                    System.out.println("Skal være et tal mellem 1-7. Prøv igen:");
                    continue;
                }

                break;
            } catch (Exception e) {
                System.out.println("Fejl. Prøv igen:");
            }
        }

        switch (valg) {
            case 1 -> Et.main(args);
            case 2 -> To.main(args);
            case 3 -> Tre.main(args);
            case 4 -> Fire.main(args);
            case 5 -> Fem.main(args);
            case 6 -> Seks.main(args);
            case 7 -> Syv.main(args);
        }
    }
}