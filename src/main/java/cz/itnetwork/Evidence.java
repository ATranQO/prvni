package cz.itnetwork;

import java.util.List;
import java.util.Scanner;

public class Evidence {

    // Inicializace instance třídy Databaze pro manipulaci se záznamy
    private Databaze databaze = new Databaze();

    // Inicializace scanneru pro čtení vstupu z klávesnice
    private Scanner sc = new Scanner(System.in, "Windows-1250");

    // Metoda pro vypsání úvodní obrazovky nabídky
    public void vypisUvodniObrazovku() {
        System.out.println("\n\n----------------------------------------------------");
        System.out.println("Evidence pojištěných");
        System.out.println("----------------------------------------------------\n");
        System.out.println("Vyberte si akci:");
        System.out.println("1 - Přidat nového pojištěného");
        System.out.println("2 - Vypsat všechny pojištěné");
        System.out.println("3 - Vyhledat pojištěného");
        System.out.println("4 - Konec");
    }

    // Metoda pro přidání záznamu pojištěného
    public void pridejZaznam() {
        // Načtení informací o pojištěném
        System.out.println("Zadejte jméno pojištěného:");
        String jmeno = sc.nextLine().trim().toLowerCase();
        System.out.println("Zadejte příjmení:");
        String prijmeni = sc.nextLine().trim().toLowerCase();
        System.out.println("Zadejte telefonní číslo:");
        String telefon = sc.nextLine().trim();
        System.out.println("Zadejte věk:");
        String vek = sc.nextLine().trim();

        // Přidání záznamu do databáze
        databaze.pridejZaznam(jmeno, prijmeni, telefon, vek);

        // Čekání na stisknutí libovolné klávesy
        System.out.print("\nData byla uložena. Pokračujte libovolnou klávesou...");
        sc.nextLine();
    }

    // Metoda pro vypsání všech záznamů pojištěných
    public void vypisZaznamy() {
        // Získání seznamu všech pojištěných z databáze
        List<Pojistenec> seznamPojistencu = databaze.najdiZaznamy();

        // Vypsání seznamu pojištěných
        if (!seznamPojistencu.isEmpty()) {
            for (Pojistenec p : seznamPojistencu) {
                System.out.print(p);
            }
        } else {
            System.out.println("Nebyly nalezeny žádné záznamy.");
        }

        // Čekání na stisknutí libovolné klávesy
        System.out.print("\nPokračujte libovolnou klávesou...");
        sc.nextLine();
    }

    // Metoda pro vyhledání záznamů pojištěných
    public void vyhledejZaznamy() {
        // Načtení kritérií pro vyhledání
        System.out.println("Zadejte jméno pojištěného:");
        String hledatJmeno = sc.nextLine().trim().toLowerCase();
        System.out.println("Zadejte příjmení:");
        String hledatPrijmeni = sc.nextLine().trim().toLowerCase();

        // Získání seznamu všech pojištěných z databáze
        List<Pojistenec> seznamPojistencu = databaze.najdiZaznamy();
        System.out.println(" ");

        // Vyhledání pojištěného podle zadaných kritérií
        StringBuilder vysledekHledani = new StringBuilder();
        for (Pojistenec p : seznamPojistencu) {
            if (p.getJmeno().equals(hledatJmeno) && p.getPrijmeni().equals(hledatPrijmeni)) {
                vysledekHledani.append(p).append("\n");
            }
        }

        // Vypsání výsledku hledání
        System.out.print(vysledekHledani);
        if (vysledekHledani.length() == 0) {
            System.out.println("Nebyly nalezeny žádné záznamy.\n");
        }

        // Čekání na stisknutí libovolné klávesy
        System.out.print("Pokračujte libovolnou klávesou...");
        sc.nextLine();
    }
}
