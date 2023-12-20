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
    public static void printKarakterer(Karakterer k, String navn) {
        System.out.printf("""
                Information om %s:
                    Antal karakterer: %d
                    Mindste karakter: %d
                    Største karakter: %d
                    Gennemsnittet for karakterer: %f
                    Antal beståede elever: %d
                    Antal elever med 7 taller: %d
                    Antal elever med mindst et 10 tal: %d
                """,
                navn,
                k.antalKarakterer(),
                k.min(),
                k.max(),
                k.snit(),
                k.antalBestaet(),
                k.antalMedKar(7),
                k.antalMedMindstKar(10)
        );

    }

    public static Karakterer skabKlasse(Integer... karakterer) {
        Karakterer klasse = new Karakterer();
        for (int karakter : karakterer) {
            klasse.tilfoejkarakter(karakter);
        }
        return klasse;
    }

    public static void main(String[] args) {
        Karakterer klasseA = new Karakterer();
        Karakterer klasseB;
        Karakterer klasseC;

        // b)
        {
            List<Integer> karakterListe = List.of(2, 4, 7, 0, -3, 7, 10, 12, 12, 7, 2, 7, 4, 10, 10, 12, 0, 7, 7, 4);
            for (int karakter : karakterListe) {
                klasseA.tilfoejkarakter(karakter);
            }
        }

        // c)
        {
            printKarakterer(klasseA, "klasse A");
        }

        // d)
        {
            klasseB = skabKlasse(12,2,-3,2,2,4,4,7,7,10,12,4,4,7,7,2,2,10,2,7);
            printKarakterer(klasseB, "klasse B");
            klasseC = skabKlasse(10,12,7,7,10,2,4,10,12,10,7,7,2,2,4,7,4,2,12,12);
            printKarakterer(klasseC, "klasse C");
        }

        // e)
        {
            int hoejesteGennemsnit = Integer.max(Integer.max(
                            (int) klasseA.snit(),
                            (int) klasseB.snit()
                    ),
                    (int) klasseC.snit()
            );
            int lavesteGennemsnit = Integer.min(Integer.min(
                            (int) klasseA.snit(),
                            (int) klasseB.snit()
                    ),
                    (int) klasseC.snit()
            );
            int flestTolvTaller = Integer.max(Integer.max(
                            klasseA.antalMedMindstKar(12),
                            klasseB.antalMedMindstKar(12)
                    ),
                    klasseC.antalMedMindstKar(12)
            );
            int flestDumpede = Integer.max(Integer.max(
                            klasseA.antalKarakterer() - klasseA.antalBestaet(),
                            klasseB.antalKarakterer() - klasseB.antalBestaet()
                    ),
                    klasseC.antalKarakterer() - klasseC.antalBestaet()
            );
            int faerrestMinusTre = Integer.min(Integer.min(
                            klasseA.antalMedKar(-3),
                            klasseB.antalMedKar(-3)
                    ),
                    klasseC.antalMedKar(-3)
            );

            {
                if (klasseA.snit() == hoejesteGennemsnit) {
                    System.out.println("Klasse A har det højeste gennemsnit.");
                } else if (klasseB.snit() == hoejesteGennemsnit) {
                    System.out.println("Klasse B har det højeste gennemsnit.");
                } else if (klasseC.snit() == hoejesteGennemsnit) {
                    System.out.println("Klasse C har det højeste gennemsnit.");
                }
            }

            {
                if (klasseA.snit() == lavesteGennemsnit) {
                    System.out.println("Klasse A har det laveste gennemsnit.");
                } else if (klasseB.snit() == lavesteGennemsnit) {
                    System.out.println("Klasse B har det laveste gennemsnit.");
                } else if (klasseC.snit() == lavesteGennemsnit) {
                    System.out.println("Klasse C har det laveste gennemsnit.");
                }
            }

            {
                if (klasseA.antalMedKar(12) == flestTolvTaller) {
                    System.out.println("Klasse A har det højeste antal tolv taller.");
                } else if (klasseB.antalMedKar(12) == flestTolvTaller) {
                    System.out.println("Klasse B har det højeste antal tolv taller.");
                } else if (klasseC.antalMedKar(12) == flestTolvTaller) {
                    System.out.println("Klasse C har det højeste antal tolv taller.");
                }
            }

            {
                if (klasseA.antalKarakterer() - klasseA.antalBestaet() == flestDumpede) {
                    System.out.println("Klasse A har det har højeste antal ikke-beståede elever.");
                } else if (klasseB.antalKarakterer() - klasseB.antalBestaet() == flestDumpede) {
                    System.out.println("Klasse B har det har højeste antal ikke-beståede elever.");
                } else if (klasseC.antalKarakterer() - klasseC.antalBestaet() == flestDumpede) {
                    System.out.println("Klasse C har det har højeste antal ikke-beståede elever.");
                }
            }

            {
                if (klasseA.antalMedKar(-3) == faerrestMinusTre) {
                    System.out.println("Klasse A har det laveste antal -3 karakterer.");
                } else if (klasseB.antalMedKar(-3) == faerrestMinusTre) {
                    System.out.println("Klasse B har det laveste antal -3 karakterer.");
                } else if (klasseC.antalMedKar(-3) == faerrestMinusTre) {
                    System.out.println("Klasse C har det laveste antal -3 karakterer.");
                }
            }
        }
    }
}
