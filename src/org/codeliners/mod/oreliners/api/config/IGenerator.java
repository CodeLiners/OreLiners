package org.codeliners.mod.oreliners.api.config;

import org.w3c.dom.Element;

public interface IGenerator {
	String getName();
	Element getElement();
	void generate();
}
