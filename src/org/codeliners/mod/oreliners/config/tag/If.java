package org.codeliners.mod.oreliners.config.tag;

import org.codeliners.mod.oreliners.api.OreLinersRegistry;
import org.codeliners.mod.oreliners.api.config.IParserAccess;
import org.codeliners.mod.oreliners.api.config.IElement;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class If implements IElement {
    @Override
    public String getName() {
        return "if";
    }

    @Override
    public Class<? extends IElement>[] getScopes() {
        return new Class[0];
    }

    @Override
    public void parse(Node node, IParserAccess parser) {
        NodeList childs = node.getChildNodes();
        for(int i = 0; i < childs.getLength(); i++) {
            Node n = childs.item(i);
            if (n.getLocalName().equals("condition")) {

            }
        }
        //OreLinersRegistry.getCondition()
    }
}
