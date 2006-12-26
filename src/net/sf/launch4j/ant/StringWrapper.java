/*
 * Created on Jul 18, 2006
 */
package net.sf.launch4j.ant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Copyright (C) 2006 Grzegorz Kowal
 */
public class StringWrapper {
	private String text;

	public static List unwrap(List wrappers) {
		if (wrappers.isEmpty()) {
			return null;
		}
		List strings = new ArrayList(wrappers.size());
		for (Iterator iter = wrappers.iterator(); iter.hasNext();) {
			strings.add(iter.next().toString());
		}
		return strings;
	}

	public void addText(String text) {
		this.text = text;
	}

	public String toString() {
		return text;
	}
}
