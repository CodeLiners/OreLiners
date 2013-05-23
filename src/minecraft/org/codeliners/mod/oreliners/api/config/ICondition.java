package org.codeliners.mod.oreliners.api.config;

public interface ICondition {
    String getName();
    boolean isTrue(String value, IParserAccess parser);
}
