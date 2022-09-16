
public class Menu {
    public static void printMenu(String[] options) {
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Izaberi : ");
    }
    public static String[] options = {
            "0 - Prekini izvrsavanje",
            "1 - Izlistaj namirnice u frizideru",
            "2 - Izlistaj recepte",
            "3 - Dodaj namirnicu u frizider",
            "4 - Obrisi namirnicu iz frizidera",
            "5 - Dodaj recept",
            "6 - Obrisi recept",
            "7 - Proveri koja su sva jela X tezine recepata",
            "8 - Omiljeni recepti",
            "9 - Dodaj omiljene recepte",
            "10 - Omiljeni recepti do X dinara",
            "11 - Proveri koja sva jela mogu da se naprave za X dinara",
            "12 - Proveri koja sva jela mogu da se naprave za X dinara, X tezine",
            "13 - Proveri koja sva koje mogu da se naprave",
            "14 - Skaliraj jelo",
//            "11 - Pravljenje jela",
//

    };

}
