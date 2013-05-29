package org.codeliners.mod.oreliners.config.tag;

import net.minecraft.item.ItemStack;
import org.codeliners.mod.oreliners.api.IGenerator;
import org.codeliners.mod.oreliners.api.OreLinersRegistry;
import org.codeliners.mod.oreliners.api.config.IElement;
import org.codeliners.mod.oreliners.api.config.IParserAccess;
import org.w3c.dom.Node;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TagGenerator implements IElement {
    @Override
    public String getName() {
        return "generator";
    }

    @Override
    public Class<? extends IElement>[] getScopes() {
        return new Class[0];
    }

    @Override
    public void parse(Node node, final IParserAccess parser) {
        final Map<String, Map<String, String>> settings = new HashMap<String, Map<String, String>>();
        IParserAccess p = new IParserAccess() {
            @Override
            public void parse(Node node) {
                if (node.getLocalName().equalsIgnoreCase("setting")) {
                    settings.put(node.getAttributes().getNamedItem("name").getNodeValue(), new NodeMap(node));
                } else {
                    parser.parse(node);
                }
            }

            @Override
            public String getVar(String name) {
                return parser.getVar(name);
            }

            @Override
            public String getDefine(String name) {
                return parser.getDefine(name);
            }

            @Override
            public ItemStack getMaterial(String name) {
                return parser.getMaterial(name);
            }

            @Override
            public void setVar(String name, String value) {
                parser.setVar(name, value);
            }

            @Override
            public void setDefine(String name, String value) {
                parser.setDefine(name, value);
            }

            @Override
            public void addMaterial(String name, ItemStack material) {
                parser.addMaterial(name, material);
            }
        };
        String name = node.getAttributes().getNamedItem("type").getNodeValue();
        String itemname = node.getAttributes().getNamedItem("material").getNodeValue();
        IGenerator gen = OreLinersRegistry.getGenerator(name);
        if (gen == null)
            throw new RuntimeException("Unknown Generator: " + name);
        //TODO: Register gen for current parse cycle
    }

    private class NodeMap implements Map<String, String> {
        private Node node;

        private NodeMap(Node node) {
            this.node = node;
        }

        @Override
        public int size() {
            return node.getAttributes().getLength();
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object o) {
            if (!(o instanceof String)) return false;
            return node.getAttributes().getNamedItem((String) o) != null;
        }

        @Override
        public boolean containsValue(Object o) {
            return false;
        }

        @Override
        public String get(Object o) {
            if (!containsKey(o)) return null;
            return node.getAttributes().getNamedItem((String) o).getNodeValue();
        }

        @Override
        public String put(String s, String s2) {
            return null;
        }

        @Override
        public String remove(Object o) {
            return null;
        }

        @Override
        public void putAll(Map<? extends String, ? extends String> map) {
        }

        @Override
        public void clear() {
        }

        @Override
        public Set<String> keySet() {
            return null;
        }

        @Override
        public Collection<String> values() {
            return null;
        }

        @Override
        public Set<Entry<String, String>> entrySet() {
            return null;
        }
    }
}
