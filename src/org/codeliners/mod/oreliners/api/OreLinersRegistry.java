package org.codeliners.mod.oreliners.api;

import net.minecraft.item.ItemStack;
import org.codeliners.mod.oreliners.api.config.ICondition;
import org.codeliners.mod.oreliners.api.config.IElement;

import java.util.HashMap;
import java.util.Map;

public final class OreLinersRegistry {
    private static Map<String, ItemStack> materials = new HashMap<String, ItemStack>();
    private static Map<String, IElement> elements = new HashMap<String, IElement>();
    private static Map<String, ICondition> conditions = new HashMap<String, ICondition>();
    private static Map<String, IGenerator> generators = new HashMap<String, IGenerator>();

    private OreLinersRegistry() {}

    //region DefaultMaterial
    public static void addDefaultMaterial(String name, ItemStack material) {
        ItemStack m = material.copy();
        m.stackSize = 1;
        materials.put(name, m);
    }

    public static ItemStack getDefaultMaterial(String name) {
        return materials.get(name);
    }
    //endregion

    //region Element
    public static void registerElement(IElement element) {
        elements.put(element.getName(), element);
    }

    public static IElement getElement(String name) {
        return elements.get(name);
    }
    //endregion

    //region Condition
    public static void registerCondition(ICondition condition) {
        conditions.put(condition.getName(), condition);
    }

    public static ICondition getCondition(String name) {
        return conditions.get(name);
    }
    //endregion

    //region
    public static void registerGenerator(IGenerator generator) {
        generators.put(generator.getName(), generator);
    }

    public static IGenerator getGenerator(String name) {
        return generators.get(name);
    }
    //endregion


}
