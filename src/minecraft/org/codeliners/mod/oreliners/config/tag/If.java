package org.codeliners.mod.oreliners.config.tag;

import org.codeliners.mod.oreliners.api.config.IParserAccess;
import org.codeliners.mod.oreliners.api.config.ITag;
import org.w3c.dom.NamedNodeMap;
import javax.xml.soap.Node;

public class If implements ITag {
    @Override
    public String getName() {
        return "if";
    }

    @Override
    public Class<? extends ITag>[] getScopes() {
        return new Class[0];
    }

    @Override
    public void parse(Node node, IParserAccess parser) {
        NamedNodeMap map = node.getAttributes();

    }
}
