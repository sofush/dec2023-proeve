import java.util.ArrayList;
import java.util.List;

class Karakterer {
    //karakterListe skal indeholde alle elevers karakterer
    private ArrayList<Integer> karakterListe;

    Karakterer() {
        this.karakterListe = new ArrayList<>();
    }

    Karakterer(ArrayList<Integer> karakterListe) {
        this.karakterListe = karakterListe;
    }

    public void setKarakterListe(ArrayList<Integer> karakterListe){
        this.karakterListe = karakterListe;
    }

    public ArrayList<Integer> getKarakterListe(){
        return this.karakterListe;
    }


    //Metoden skal tilføje karakteren kar til karakterListe
    public void tilfoejkarakter(int kar){
        this.karakterListe.add(kar);
    }

    //Metoden skal returnere antallet af karakterer i karakterListe
    public int antalKarakterer() {
        return this.karakterListe.size();
    }

    //Metoden skal returnere den mindste karakter i karakterListe
    public int min() {
        if (this.karakterListe.isEmpty()) return 0;

        int min = 0;
        for (int k : this.karakterListe) {
            min = Integer.min(min, k);
        }
        return min;
    }

    //Metoden skal returnere den største karakter i karakterListe
    public int max() {
        if (this.karakterListe.isEmpty()) return 0;

        int max = 0;
        for (int k : this.karakterListe) {
            max = Integer.max(max, k);
        }
        return max;
    }

    //Metoden skal returnere gennemsnittet af karaktererne i karakterListe
    public double snit() {
        if (this.karakterListe.isEmpty()) return 0;

        int sum = 0;
        for (int k : this.karakterListe) {
            sum += k;
        }
        return sum / this.karakterListe.size();
    }

    //Metoden skal returnere hvor mange der har fået mindst 2 i karakter i karakterListe
    public int antalBestaet() {
        if (this.karakterListe.isEmpty()) return 0;
        return (int) this.karakterListe.stream()
                .filter((karakter) -> karakter >= 2)
                .count();
    }

    //Metoden skal returnere hvor mange der har karakteren k i karakterListe
    public int antalMedKar(int k) {
        if (this.karakterListe.isEmpty()) return 0;
        return (int) this.karakterListe.stream()
                .filter((karakter) -> karakter == k)
                .count();
    }

    //Metoden skal returnere hvor mange der mindst har fået karakteren k i karakterListe
    public int antalMedMindstKar(int k) {
        if (this.karakterListe.isEmpty()) return 0;
        return (int) this.karakterListe.stream()
                .filter((karakter) -> karakter >= k)
                .count();
    }
}

public class Seks {
    public static void main(String[] args) {
        Karakterer klasseA = new Karakterer();

        // b)
        {
            List<Integer> karakterListe = List.of(2, 4, 7, 0, -3, 7, 10, 12, 12, 7, 2, 7, 4, 10, 10, 12, 0, 7, 7, 4);
            for (int karakter : karakterListe) {
                klasseA.tilfoejkarakter(karakter);
            }
        }

        // c)
        {
            System.out.printf("""
                Information om klasse A:
                    Antal karakterer: %d
                    Mindste karakter: %d
                    Største karakter: %d
                    Gennemsnittet for karakterer: %f
                    Antal beståede elever: %d
                    Antal elever med 7 taller: %d
                    Antal elever med mindst et 10 tal: %d
                """,
                    klasseA.antalKarakterer(),
                    klasseA.min(),
                    klasseA.max(),
                    klasseA.snit(),
                    klasseA.antalBestaet(),
                    klasseA.antalMedKar(7),
                    klasseA.antalMedMindstKar(10)
            );
        }
    }
}
