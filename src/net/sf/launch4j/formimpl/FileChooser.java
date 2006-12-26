/*
 * Created on Jul 19, 2006
 */
package net.sf.launch4j.formimpl;

import java.io.File;
import java.util.prefs.Preferences;

import javax.swing.JFileChooser;

/**
 * @author Copyright (C) 2006 Grzegorz Kowal
 */
public class FileChooser extends JFileChooser {
	private final Preferences _prefs;
	private final String _key;

	public FileChooser(Class clazz) {
		_prefs = Preferences.userNodeForPackage(clazz);
		_key = "currentDir-"
			+ clazz.getName().substring(clazz.getName().lastIndexOf('.') + 1);
		String path = _prefs.get(_key, null);
		if (path != null) {
			setCurrentDirectory(new File(path));
		}
	}

	public void approveSelection() {
		_prefs.put(_key, getCurrentDirectory().getPath());
		super.approveSelection();
	}
}
