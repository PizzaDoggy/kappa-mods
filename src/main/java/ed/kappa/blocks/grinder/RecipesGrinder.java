package ed.kappa.blocks.grinder;

import com.google.common.collect.Maps;
import ed.kappa.items.KappaItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLLog;

import java.util.Iterator;
import java.util.Map;

public class RecipesGrinder {
    private static final RecipesGrinder GRINDER_BASE = new RecipesGrinder();
    private final Map<ItemStack, ItemStack> grinderList = Maps.newHashMap();
    private final Map<ItemStack, Float> experienceList = Maps.newHashMap();

    public static RecipesGrinder instance() {
        return GRINDER_BASE ;
    }

    private RecipesGrinder() {
        this.addGrinderRecipeForBlock(Blocks.COBBLESTONE, new ItemStack(KappaItems.rock), 0.5F);
        this.addGrinderRecipeForBlock(Blocks.STONE, new ItemStack(Blocks.COBBLESTONE), 0.5F);
        this.addGrinder(KappaItems.hemp, new ItemStack(KappaItems.rope), .5F);
        this.addGrinder(Items.WHEAT, new ItemStack(KappaItems.flour), .5F);
    }

    public void addGrinderRecipeForBlock(Block input, ItemStack stack, float experience) {
        this.addGrinder(Item.getItemFromBlock(input), stack, experience);
    }

    public void addGrinder(Item input, ItemStack stack, float experience) {
        this.addGrinderRecipe(new ItemStack(input, 1, 32767), stack, experience);
    }

    public void addGrinderRecipe(ItemStack input, ItemStack stack, float experience) {
        if (this.getGrinderResult(input) != ItemStack.EMPTY) {
            FMLLog.log.info("Ignored smelting recipe with conflicting input: {} = {}", input, stack);
        } else {
            this.grinderList.put(input, stack);
            this.experienceList.put(stack, experience);
        }
    }

    public ItemStack getGrinderResult(ItemStack stack) {
        Iterator var2 = this.grinderList.entrySet().iterator();

        Map.Entry entry;
        do {
            if (!var2.hasNext()) {
                return ItemStack.EMPTY;
            }

            entry = (Map.Entry)var2.next();
        } while(!this.compareItemStacks(stack, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map<ItemStack, ItemStack> getGrinderList() {
        return this.grinderList;
    }

    public float getGrinderExperience(ItemStack stack) {
        float ret = stack.getItem().getSmeltingExperience(stack);
        return ret;
    }
}
