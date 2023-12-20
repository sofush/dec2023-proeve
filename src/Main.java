import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            Fire.main(args);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}