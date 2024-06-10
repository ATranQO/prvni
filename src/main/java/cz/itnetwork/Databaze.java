package cz.itnetwork;

import java.util.ArrayList;
import java.util.List;

public class Databaze {

    // Seznam pojištěnců v databázi
    private List<Pojistenec> seznamPojistencu = new ArrayList<>();

    // Metoda pro přidání záznamu pojištěnce do databáze
    public void pridejZaznam(String jmeno, String prijmeni, String telefon, String vek) {
        seznamPojistencu.add(new Pojistenec(jmeno, prijmeni, validaceCisla(telefon), validaceVeku(vek)));
    }

    // Metoda pro vrácení seznamu všech pojištěnců
    public List<Pojistenec> najdiZaznamy() {
        return seznamPojistencu;
    }

    // Metoda pro validaci telefonního čísla
    public String validaceCisla(String telefon) {
        // Odstranění nečíselných znaků
        StringBuilder validniTelefon = new StringBuilder();
        for (char c : telefon.toCharArray()) {
            if (Character.isDigit(c)) {
                validniTelefon.append(c);
            }
        }
        // Doplnění nulami, pokud číslo není dostatečně dlouhé
        while (validniTelefon.length() < 9) {
            validniTelefon.insert(0, "0");
        }
        // Zkrácení čísla na devět znaků
        return validniTelefon.substring(validniTelefon.length() - 9);
    }

    // Metoda pro validaci věku
    public String validaceVeku(String vek) {
        // Přidání nuly, pokud je věk jednociferný
        return vek.length() < 2 ? "0" + vek : vek;
    }
}
