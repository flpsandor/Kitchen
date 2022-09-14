import javax.xml.crypto.Data;
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


        Database.addFavoriteRecipe("omlet");


        Scanner sc = new Scanner(System.in);
        boolean isTrue = false;
        while (!isTrue) {
            System.out.println();
            Menu.printMenu(Menu.options);

            switch (sc.nextInt()) {
                case 0:
                    continue;
                case 1:
                    System.out.println("LISTA NAMIRNICA: ");
                    for(var item:Database.getAllIngredients()){
                        System.out.println(item.getIngredientName()+", "+item.getWeight());
                    }
                    continue;
                case 2:
                    System.out.println("LISTA RECEPATA: ");
                    for(var recipe:Database.getAllRecipes()){
                        System.out.println(recipe.getRecipeName());
                    }
                    continue;
                case 3:
                    sc.nextLine();
                    System.out.println("DODAJ NAMIRNICE: ");
                    System.out.print("Unesi ime namirnice:");
                    var ingredientName = sc.nextLine();
                    System.out.print("Unesi kolicinu:");
                    var weight = sc.nextDouble();
                    System.out.print("Unesi cenu: ");
                    var price = sc.nextDouble();
                    Database.addIngredient(new WeightedIngredient(ingredientName,weight,price));
                    continue;
                case 4:
                    System.out.println("OBRISI NAMIRNICU: ");
                    System.out.print("Unesi 1 za smanjenje kolicine, 2 za potpuno brisanje:");
                    switch (sc.nextInt()){
                        case 1:
                            sc.nextLine();
                            System.out.print("Unesi namirnicu: ");
                            ingredientName = sc.nextLine();
                            System.out.print("Unesi vrednost za smanjenje: ");
                            weight = sc.nextDouble();
                            Database.subtractIngredientWeight(Database.getIngredient(ingredientName), weight);
                            break;
                        case 2:
                            sc.nextLine();
                            System.out.print("Unesi ime namirnice za brisnaje: ");
                            ingredientName = sc.nextLine();
                            Database.removeIngredient(ingredientName);
                            break;
                        default:
                            System.out.println("Nepravilan unos");
                            continue;
                    }
                    continue;
                case 5:
                    sc.nextLine();
                    System.out.println("DODAJ RECEPT");
                    System.out.print("Unesi ime recepta: ");
                    var recipeName = sc.nextLine();
                    System.out.print("Unesi tezinu recepta [");
                    for(var level:Level.values()){
                        System.out.print(level+" ");
                   }
                    System.out.println("]");
                    var level = sc.nextLine();
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
                        ingredientName = sc.nextLine();
                        System.out.print("Unesi kolicinu sastojka: ");
                        weight = sc.nextDouble();
                        recipeNew.addIngredientInRecipe(ingredientName, weight);
                    }
                    continue;
                case 15:
                    System.out.println("OMILJENI RECEPTI");
                    for(var recipe: Database.getAllFavoriteRecipe()){
                        System.out.println(recipe.getRecipeName());
                    }
                    continue;
                case 16:
                    System.out.print("DODAJ OMILJENI RECEPT [");
                    for(var recipe:Database.getAllRecipes()){
                        System.out.print(recipe.getRecipeName()+" ");
                    }
                    System.out.println("]");
                    sc.nextLine();
                    System.out.println("Unesi recept koji je ponudjen: ");
                    recipeName = sc.nextLine();
                    Database.addFavoriteRecipe(recipeName);
                    continue;
                default:
                    isTrue = true;
                    break;
            }
        }
    }
}
