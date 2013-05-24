package org.codeliners.mod.oreliners.api.config;

import net.minecraft.item.ItemStack;

import javax.xml.soap.Node;

public interface IParserAccess {
    void parse(Node node);
    String getVar(String name);
    String getDefine(String name);
    ItemStack getMaterial(String name);

    void setVar(String name, String value);
    void setDefine(String name, String value);
    void addMaterial(String name, ItemStack material);
}
