import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.registries.ItemRegistry;
import necesse.engine.registries.MobRegistry;
import necesse.engine.registries.RecipeTechRegistry;
import necesse.inventory.item.Item;
import necesse.inventory.recipe.Ingredient;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;


@ModEntry
public class WolfStaff {

//i suck girlcock
    public void init() {
        ItemRegistry.registerItem("wolfstaff", new WolfStaffToolItem(), 200.0F, true);

        MobRegistry.registerMob("wolfsummon", WolfSummon.class, false);
    }

    public void postInit(){
        Recipes.registerModRecipe(new Recipe(
            "wolfstaff",
            1,
            RecipeTechRegistry.NONE,
            new Ingredient[]{
                new Ingredient("oaklog", 1)
            }
        ).showAfter("woodboat"));
    }
}

