package cz.itnetwork;

public class Pojistenec {

    // Informace o pojištěnci
    private String jmeno;
    private String prijmeni;
    private String telefon;
    private String vek;

    // Konstruktor třídy Pojistenec
    public Pojistenec(String jmeno, String prijmeni, String telefon, String vek) {
        this.jmeno = capitalizeFirstLetter(jmeno);
        this.prijmeni = capitalizeFirstLetter(prijmeni);
        this.telefon = telefon;
        this.vek = vek;
    }

    // Metoda pro získání jména
    public String getJmeno() {
        return jmeno;
    }

    // Metoda pro získání příjmení
    public String getPrijmeni() {
        return prijmeni;
    }

    // Pomocná metoda pro kapitalizaci prvního písmena
    private String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    // Přepisuje metodu toString() třídy Object pro získání textové reprezentace instance
    @Override
    public String toString() {
        // Zarovnání textu
        return String.format("%-13s %-16s %-18s %s%n", jmeno, prijmeni, telefon, vek);
    }
}
