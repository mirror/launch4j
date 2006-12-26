/*
 * Created on Jul 18, 2006
 */
package net.sf.launch4j.ant;

import java.util.ArrayList;
import java.util.List;

import net.sf.launch4j.config.Jre;

/**
 * @author Copyright (C) 2006 Grzegorz Kowal
 */
public class AntJre extends Jre {
	private final List wrappedOptions = new ArrayList();

	public void addOpt(StringWrapper opt) {
		wrappedOptions.add(opt);
	}

	public void unwrap() {
		setOptions(StringWrapper.unwrap(wrappedOptions));
	}
}
