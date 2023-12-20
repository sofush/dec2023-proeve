import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

abstract class Ansat {
    int medarbejderNr;
    String fnavn;
    String enavn;
    String adresse;
    OffsetDateTime ansaettelsesdato;
    String afdelingsNummer;

    public Ansat(int medarbejderNr, String fnavn, String enavn, String adresse, OffsetDateTime ansaettelsesdato, String afdelingsNummer) {
        this.medarbejderNr = medarbejderNr;
        this.fnavn = fnavn;
        this.enavn = enavn;
        this.adresse = adresse;
        this.ansaettelsesdato = ansaettelsesdato;
        this.afdelingsNummer = afdelingsNummer;
    }

    public int getMedarbejderNr() {
        return medarbejderNr;
    }

    public void setMedarbejderNr(int medarbejderNr) {
        this.medarbejderNr = medarbejderNr;
    }

    public String getFnavn() {
        return fnavn;
    }

    public void setFnavn(String fnavn) {
        this.fnavn = fnavn;
    }

    public String getEnavn() {
        return enavn;
    }

    public void setEnavn(String enavn) {
        this.enavn = enavn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public OffsetDateTime getAnsaettelsesdato() {
        return ansaettelsesdato;
    }

    public void setAnsaettelsesdato(OffsetDateTime ansaettelsesdato) {
        this.ansaettelsesdato = ansaettelsesdato;
    }

    public String getAfdelingsNummer() {
        return afdelingsNummer;
    }

    public void setAfdelingsNummer(String afdelingsNummer) {
        this.afdelingsNummer = afdelingsNummer;
    }

    public void print() {
        System.out.printf(
            """
                Medarbejdernummer: %d
                Fornavn: %s
                Efternavn: %s
                Adresse: %s
                Ansættelsesdato: %s
                Afdelingsnummer: %s
            """,
            this.getMedarbejderNr(),
            this.getFnavn(),
            this.getEnavn(),
            this.getAdresse(),
            this.getAnsaettelsesdato(),
            this.getAfdelingsNummer()
        );
    }
}

class Servicemedarbejder extends Ansat {
    enum Speciale {
        ELEKTRIKER,
        VVS,
        TOEMRER,
    }

    Speciale speciale;
    float timeloen;

    Servicemedarbejder(Speciale speciale, float timeloen, int medarbejderNr, String fnavn, String enavn, String adresse, OffsetDateTime ansaettelsesdato, String afdelingsNummer) {
        super(medarbejderNr,
                fnavn,
                enavn,
                adresse,
                ansaettelsesdato,
                afdelingsNummer);

        this.speciale = speciale;
        this.timeloen = timeloen;
    }

    public Speciale getSpeciale() {
        return speciale;
    }

    public void setSpeciale(Speciale speciale) {
        this.speciale = speciale;
    }

    public float getTimeloen() {
        return timeloen;
    }

    public void setTimeloen(float timeloen) {
        this.timeloen = timeloen;
    }

    @Override
    public void print() {
        System.out.printf(
            """
            Information om servicemedarbejder:
                Speciale: %s
                Timeløn: %f
            """,
            this.speciale,
            this.timeloen
        );
        super.print();
    }
}

class Admmedarbejder extends Ansat {
    enum Uddannelse {
        Bogholder,
        Sektretaer,
    }

    Uddannelse udd;
    float timeloen;

    Admmedarbejder(Uddannelse udd, float timeloen, int medarbejderNr, String fnavn, String enavn, String adresse, OffsetDateTime ansaettelsesdato, String afdelingsNummer) {
        super(medarbejderNr,
                fnavn,
                enavn,
                adresse,
                ansaettelsesdato,
                afdelingsNummer);

        this.udd = udd;
        this.timeloen = timeloen;
    }

    public Uddannelse getUdd() {
        return udd;
    }

    public void setUdd(Uddannelse udd) {
        this.udd = udd;
    }

    public float getTimeloen() {
        return timeloen;
    }

    public void setTimeloen(float timeloen) {
        this.timeloen = timeloen;
    }

    @Override
    public void print() {
        System.out.printf(
            """
            Information om administrativ medarbejder:
                Uddannelse: %s
                Timeløn: %f
            """,
            this.udd,
            this.timeloen
        );
        super.print();
    }
}

class Leder extends Ansat {
    enum Niveau {
        ET,
        TO,
        TRE,
    }

    Niveau niveau;
    float maanedsloen;

    Leder(Niveau niveau, float maanedsloen, int medarbejderNr, String fnavn, String enavn, String adresse, OffsetDateTime ansaettelsesdato, String afdelingsNummer) {
        super(medarbejderNr,
                fnavn,
                enavn,
                adresse,
                ansaettelsesdato,
                afdelingsNummer);

        this.niveau = niveau;
        this.maanedsloen = maanedsloen;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public float getMaanedsloen() {
        return maanedsloen;
    }

    public void setMaanedsloen(float maanedsloen) {
        this.maanedsloen = maanedsloen;
    }

    @Override
    public void print() {
        System.out.printf(
            """
            Information om leder:
                Niveau: %s
                Månedsløn: %f
            """,
            this.niveau,
            this.maanedsloen
        );
        super.print();
    }
}

public class Syv {
    public static void main(String[] args) {
        // a)
        List<Leder> ledere = List.of(
            new Leder(
                Leder.Niveau.ET,
                50561.50F,
                1,
                "John",
                "Jensen",
                "Femøvej",
                OffsetDateTime.of(
                        2023,
                        1,
                        20,
                        15,
                        30,
                        21,
                        0,
                        ZoneOffset.UTC
                ),
                "Afdeling-12"
            ),
            new Leder(
                Leder.Niveau.TO,
                44501.88F,
                2,
                "Jens",
                "Petersen",
                "Gallemarksvej",
                OffsetDateTime.of(
                        2016,
                        6,
                        12,
                        9,
                        36,
                        11,
                        0,
                        ZoneOffset.UTC
                ),
                "Afdeling-12"
            ),
            new Leder(
                Leder.Niveau.TRE,
                38124.12F,
                3,
                "Birgit",
                "Andersen",
                "Norgesvej",
                OffsetDateTime.of(
                        2018,
                        2,
                        28,
                        8,
                        56,
                        11,
                        0,
                        ZoneOffset.UTC
                ),
                "Afdeling-13"
            )
        );

        List<Admmedarbejder> adm = List.of(
            new Admmedarbejder(
                Admmedarbejder.Uddannelse.Bogholder,
                33561.33F,
                4,
                "William",
                "Larsen",
                "Fyrreparken",
                OffsetDateTime.of(
                        2021,
                        8,
                        28,
                        12,
                        19,
                        11,
                        0,
                        ZoneOffset.UTC
                ),
                "Afdeling-21"
            ),
            new Admmedarbejder(
                Admmedarbejder.Uddannelse.Sektretaer,
                36581.57F,
                5,
                "Noah",
                "Christensen",
                "Mariedalsvej",
                OffsetDateTime.of(
                        2010,
                        2,
                        2,
                        14,
                        11,
                        45,
                        0,
                        ZoneOffset.UTC
                ),
                "Afdeling-21"
            )
        );

        List<Servicemedarbejder> service = List.of(
            new Servicemedarbejder(
                Servicemedarbejder.Speciale.ELEKTRIKER,
                40123.45F,
                6,
                "Julia",
                "Larsen",
                "Kuhlaus Vej",
                OffsetDateTime.of(
                        2014,
                        5,
                        5,
                        16,
                        11,
                        45,
                        0,
                        ZoneOffset.UTC
                ),
                "Afdeling-36"
            ),
            new Servicemedarbejder(
                Servicemedarbejder.Speciale.VVS,
                42329.48F,
                7,
                "Ida",
                "Petersen",
                "Galaksevej",
                OffsetDateTime.of(
                        2012,
                        8,
                        7,
                        12,
                        34,
                        59,
                        0,
                        ZoneOffset.UTC
                ),
                "Afdeling-37"
            ),
            new Servicemedarbejder(
                Servicemedarbejder.Speciale.TOEMRER,
                41098.37F,
                8,
                "Malthe",
                "Nielsen",
                "H C Andersens Vej",
                OffsetDateTime.of(
                        2018,
                        3,
                        21,
                        11,
                        22,
                        58,
                        0,
                        ZoneOffset.UTC
                ),
                "Afdeling-38"
            )
        );

        // b & c)
        {
            // OBS: Jeg benytter `List` typen som er interfacet som `ArrayList` implementerer,
            // da `ArrayList` ikke har nogen fordele over den uforanderlige type som `List.of()`
            // returnerer i dette scenarie.

            for (Ansat ansat : ledere) {
                ansat.print();
            }

            for (Ansat ansat : adm) {
                ansat.print();
            }

            for (Ansat ansat : service) {
                ansat.print();
            }
        }
    }
}
