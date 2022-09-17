import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Application {

    public static void main(String[] args){
        Database.addIngredient(new WeightedIngredient("jaja", 30, 20));
        Database.addIngredient(new WeightedIngredient("brasno", 2.1, 90));
        Database.addIngredient(new WeightedIngredient("zejtin", 1, 200));
        Database.addIngredient(new WeightedIngredient("meso", 3.7, 650));
        Database.addIngredient(new WeightedIngredient("paprika", 1.1, 160));
        Database.addIngredient(new WeightedIngredient("paradajz", 3, 120));
        Database.addIngredient(new WeightedIngredient("slanina", 1.1, 800));
        Database.addIngredient(new WeightedIngredient("krompir", 3, 80));
        Database.addIngredient(new WeightedIngredient("luk", 1.8, 40));
        Database.addIngredient( new WeightedIngredient("mleko", 2.3, 120));
        Database.addIngredient(new WeightedIngredient("sir", 1.3, 400));
        Database.addIngredient(new WeightedIngredient("pasulj", 0.7, 305));
        Database.addIngredient(new WeightedIngredient("projinoBrasno", 1, 90));
        Database.addIngredient(new WeightedIngredient("jogurt", 1.7, 120));
        Database.addIngredient(new WeightedIngredient("nes", 0.25, 600));
        Database.addIngredient(new WeightedIngredient("makarone", 3, 60));


        Recipe recipe1 = new Recipe("Proja", Level.EASY);
        recipe1.addIngredientInRecipe("projinoBrasno", 0.4);
        recipe1.addIngredientInRecipe("brasno",0.4);
        recipe1.addIngredientInRecipe("sir",0.5);
        recipe1.addIngredientInRecipe("zejtin", 0.1);
        Recipe recipe2 = new Recipe("Nes kafa", Level.BEGGINER);
        recipe2.addIngredientInRecipe("nes", 0.02);
        recipe2.addIngredientInRecipe("mleko", 0.2);
        Recipe recipe3 = new Recipe("Omlet", Level.MEDIUM);
        recipe3.addIngredientInRecipe("jaja", 4);
        Recipe recipe4 = new Recipe("Pasulj", Level.MEDIUM);
        recipe4.addIngredientInRecipe("luk",0.5);
        recipe4.addIngredientInRecipe("pasulj", 0.5);
        Recipe recipe5 = new Recipe("Musaka", Level.HARD);
        recipe5.addIngredientInRecipe("meso", 1);
        recipe5.addIngredientInRecipe("luk", 0.2);
        recipe5.addIngredientInRecipe("krompir", 0.5);
        recipe5.addIngredientInRecipe("mleko", 0.1);
        Recipe recipe6 = new Recipe("pica", Level.EASY);
        recipe6.addIngredientInRecipe("brasno", 0.4);
        recipe6.addIngredientInRecipe("jaja",3);
        recipe6.addIngredientInRecipe("paradajz", 0.1);
        recipe6.addIngredientInRecipe("sir", 0.2);
        Recipe recipe7 = new Recipe("makaroneSaSirom");
        recipe7.addIngredientInRecipe("makarone",1);
        recipe7.addIngredientInRecipe("sir", 0.2);
        Recipe recipe8  = new Recipe("przenice");
        recipe8.addIngredientInRecipe("brasno", 0.2);
        recipe8.addIngredientInRecipe("jaja", 4);
        recipe8.addIngredientInRecipe("zejtin", 0.05);
        Recipe recipe9 = new Recipe("palacinke");
        recipe9.addIngredientInRecipe("brasno", 0.5);
        recipe9.addIngredientInRecipe("zejtin", 0.2);
        recipe9.addIngredientInRecipe("mleko", 0.3);
        Recipe recipe10 = new Recipe("punjenePaprike");
        recipe10.addIngredientInRecipe("paprika", 0.5);
        recipe10.addIngredientInRecipe("luk", 0.2);
        recipe10.addIngredientInRecipe("meso", 1);



        Database.addFavoriteRecipe("omlet");
        Database.addFavoriteRecipe("pica");


        Scanner sc = new Scanner(System.in);
        boolean isTrue = false;
        while (!isTrue) {
            System.out.println();
            Menu.printMenu(Menu.options);

            switch (sc.nextInt()) {
                case 0:
                    System.out.println("PROGRAM JE PREKINUT");
                    isTrue = true;
                    return;
                case 1:
                    System.out.println("LISTA NAMIRNICA: ");
                    Database.printIngredientListFromFridge();
                    continue;
                case 2:
                    System.out.println("LISTA RECEPATA: ");
                    Database.printAllRecipes();
                    continue;
                case 3:
                    sc.nextLine();
                    System.out.println("DODAJ NAMIRNICE: ");
                    System.out.println("Unesi 1 za novu namirnicu, 2 za postojecu, 0 za nazad");
                    switch (sc.nextInt()) {
                        case 0 ->{
                            continue;
                        }
                        case 1 -> {
                            sc.nextLine();
                            System.out.print("Unesi ime namirnice:");
                            var ingredientName = sc.nextLine();
                            System.out.print("Unesi kolicinu:");
                            var weight = sc.nextDouble();
                            System.out.print("Unesi cenu: ");
                            var price = sc.nextDouble();
                            Database.addIngredient(new WeightedIngredient(ingredientName, weight, price));
                            continue;
                        }
                        case 2 -> {
                            sc.nextLine();
                            System.out.println("Unesi ime postojece namirnice: ");
                            var ingredientName = sc.nextLine();
                            System.out.print("Unesi kolicinu:");
                            var weight = sc.nextDouble();
                            Database.additionIngredientWeight(Database.getIngredient(ingredientName), weight);
                            continue;
                        }
                        default -> {
                            System.out.println("Nepravilan unos");
                        }
                    }
                    continue;
                case 4:
                    System.out.println("OBRISI NAMIRNICU: ");
                    System.out.print("Unesi 1 za smanjenje kolicine, 2 za potpuno brisanje, 0 za nazad:");
                    switch (sc.nextInt()) {
                        case 0 -> {
                            continue;
                        }
                        case 1 -> {
                            sc.nextLine();
                            System.out.print("Unesi namirnicu: ");
                            var ingredientName = sc.nextLine();
                            System.out.print("Unesi vrednost za smanjenje: ");
                            var weight = sc.nextDouble();
                            Database.subtractIngredientWeight(Database.getIngredient(ingredientName), weight);
                            continue;
                        }
                        case 2 -> {
                            sc.nextLine();
                            System.out.print("Unesi ime namirnice za brisnaje: ");
                            var ingredientName = sc.nextLine();
                            Database.removeIngredient(ingredientName);
                            continue;
                        }
                        default -> {
                            System.out.println("Nepravilan unos");
                        }
                    }
                    continue;
                case 5:
                    sc.nextLine();
                    System.out.println("DODAJ RECEPT");
                    System.out.println("1 za unos, 0 za nazad");
                    switch(sc.nextInt()){
                        case 0 -> {
                            continue;
                        }
                        case 1-> {
                            sc.nextLine();
                            System.out.print("Unesi ime recepta: ");
                            var recipeName = sc.nextLine();
                            System.out.print("Unesi tezinu recepta [");
                            for(var level:Level.values()){
                                System.out.print(level+" ");
                            }
                            System.out.println("]");
                            var level = sc.nextLine().toUpperCase();
                            var recipeNew = new Recipe(recipeName,Level.valueOf(level));
                            System.out.print("Unesi koliko namirnica recept ima: ");
                            var count = sc.nextInt();
                            for(int i=0;i<count;i++){
                                sc.nextLine();
                                System.out.print("Unesi naziv sastojka: [");
                                for(var item: Database.getAllIngredients()){
                                    System.out.print(item.getIngredientName()+", ");
                                }
                                System.out.print("]: ");
                                var ingredientName = sc.nextLine();
                                System.out.print("Unesi kolicinu sastojka: ");
                                var weight = sc.nextDouble();
                                recipeNew.addIngredientInRecipe(ingredientName, weight);
                            }
                        }
                        default -> {
                            System.out.println("NEISPRAVAN UNOS");
                        }
                    }
                    continue;
                case 6:
                    sc.nextLine();
                    System.out.println("OBRISI RECEPT");
                    System.out.print("Unesi ime recepta: ");
                    Database.removeRecipe(sc.nextLine());
                    continue;
                case 7:
                    System.out.println("PROVERI KOJA SU SVA JELA X TEZINE RECEPATA");
                    System.out.print("Unesi tezinu recepat, [");
                    for(var l: Level.values()){
                        System.out.print(l+" ");
                    }
                    System.out.println("]: ");
                    Database.getSortedRecipesByLevel(Level.valueOf(sc.next().toUpperCase()));
                    continue;
                case 8:
                    System.out.println("OMILJENI RECEPTI");
                    for(var recipe: Database.getAllFavoriteRecipe()){
                        System.out.println(recipe.getRecipeName());
                    }
                    continue;
                case 9:
                    System.out.print("DODAJ OMILJENI RECEPT [");
                    for(var recipe:Database.getAllRecipes()){
                        System.out.print(recipe.getRecipeName()+" ");
                    }
                    System.out.println("]");
                    System.out.println("0 za nazad, 1 za unos");
                    switch(sc.nextInt()){
                        case 0:
                            continue;
                        case 1:
                            sc.nextLine();
                            System.out.println("Unesi recept koji je ponudjen: ");
                            var recipeName = sc.nextLine();
                            Database.addFavoriteRecipe(recipeName);
                            continue;
                        default:
                            System.out.println("NEISPRAVAN UNOS");
                    }
                    continue;
                case 10:
                    sc.nextLine();
                    System.out.println("OMILJENI RECEPTI DO X DINARA");
                    System.out.print("Unesi krajnju cenu: ");
                    Database.getFavoriteRecipeUptoPrice(sc.nextDouble());
                    continue;
                case 11:
                    sc.nextLine();
                    System.out.println("PROVERI KOJA SVA JELA MOGU DA SE NAPRAVE ZA X DINARA");
                    System.out.print("Unesi krajnju cenu: ");
                    Database.getAllRecipeUptoPrice(sc.nextDouble());
                    continue;
                case 12:
                    sc.nextLine();
                    System.out.println("PROVERI KOJA SVA JELA MOGU DA SE NAPRAVE ZA X dinara, X tezine");
                    System.out.print("Unesi krajnju cenu: ");
                    var price = sc.nextDouble();
                    System.out.print("Unesi tezinu recepta: ");
                    var level = sc.nextLine();
                    Database.getAllRecipeUpToPriceAndLevel(price, level);
                    continue;
                case 14:
                    sc.nextLine();
                    System.out.println("SKALIRANJE");
                    System.out.print("Unesi ime recepta: ");
                    var recipeName = sc.nextLine();
                    System.out.print("Unesi vrednost skaliranja: ");
                    var value = sc.nextDouble();
                    for(var recipe: Database.getAllRecipes()){
                        if(recipe.getRecipeName().equalsIgnoreCase(recipeName)){
                            recipe.getScaledRecipe(value);
                            if(Fridge.recipeCheck(recipe, (ArrayList<WeightedIngredient>) Fridge.getIngredientListInFridge())){
                                System.out.println("Uspesno skaliranje, pogledajte upis u listi recepata");
                            }
                        }
                    }
                    continue;
                case 15:
                    sc.nextLine();
                    System.out.println("PRAVLJENJE JELA");
                    System.out.println("Moguce je napraviti: ");
                    for (var recipe : Database.getAllRecipes()) {
                        if (Fridge.recipeCheck(recipe, (ArrayList<WeightedIngredient>) Fridge.getIngredientListInFridge())) {
                            System.out.print(recipe.getRecipeName()+ " ");
                        }
                    }
                    System.out.print("Koje jelo zelite napraviti: ");
                    Fridge.makeRecipe(sc.nextLine());
                    System.out.println("Jelo je napravljeno!");
                    continue;
                default:
                    System.out.println("NEISPRAVAN UNOS");
                    continue;
            }
        }
    }
}
