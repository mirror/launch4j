/*
 * Created on Jul 19, 2006
 */
package net.sf.launch4j.ant;

import java.util.ArrayList;
import java.util.List;

import net.sf.launch4j.config.ClassPath;

/**
 * @author Copyright (C) 2006 Grzegorz Kowal
 */
public class AntClassPath extends ClassPath {
	private final List wrappedPaths = new ArrayList();

	public void addCp(StringWrapper cp) {
		wrappedPaths.add(cp);
	}

	public void unwrap() {
		setPaths(StringWrapper.unwrap(wrappedPaths));
	}
}
