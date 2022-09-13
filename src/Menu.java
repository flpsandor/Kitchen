
public class Menu {
    public static void printMenu(String[] options) {
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Izaberi : ");
    }
    public static String[] options = {
            "0 - Vrati se nazad",
            "1 - Izlistaj namirnice u frizideru",
            "2 - Izlistaj recepte",
            "3 - Dodaj namirnicu u frizider",
            "4 - Obrisi namirnicu iz frizidera",
//            "5 - Dodaj recept",
//            "6 - Obrisi recept",
            "7 - Sortiraj recepte po tezini (od manje ka vecoj)",
            "8 - Sortiraj recepte po ceni (od manje ka vecoj)",
//            "9 - Proveri koja sva koje mogu da se naprave",
//            "10 - Proveri koja sva jela mogu da se naprave (skaliranje)",
//            "11 - Pravljenje jela",
//            "12 - Proveri koja sva jela mogu da se naprave za X dinara",
//            "13 - Proveri koja su sva jela X tezine recepata",
//            "14 - Proveri koja sva jela mogu da se naprave za X dinara, X tezine",
            "15 - Omiljeni recepti",
            "16 - Dodaj omiljene recepte"
    };

}
