package org.codeliners.mod.oreliners.api.config;

import javax.xml.soap.Node;

public interface ITag {
    /**
     * Returns the name of the section
     * @return the name of the section
     */
    String getName();

    /**
     * What Tags can this tag be used inside of?
     * @return A list of tag classes this can be used in. empty if any.
     */
    Class<?extends ITag>[] getScopes();

    /**
     * tells the statement to parse an xml node
     * @param node The XML node to parse
     * @param parser The parent parser to pass unknown Tags
     */
    void parse(Node node, IParserAccess parser);
}
