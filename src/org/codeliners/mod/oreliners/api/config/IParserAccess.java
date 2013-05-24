package org.codeliners.mod.oreliners.api.config;

import javax.xml.soap.Node;

public interface IParserAccess {
    void parse(Node node);
    String getVar(String name);
    String getDefine(String name);
}
