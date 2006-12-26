/*
	Launch4j (http://launch4j.sourceforge.net/)
	Cross-platform Java application wrapper for creating Windows native executables.

	Copyright (C) 2004, 2006 Grzegorz Kowal

	This program is free software; you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation; either version 2 of the License, or
	(at your option) any later version.

	This program is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with this program; if not, write to the Free Software
	Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
*/

/*
 * Created on May 10, 2005
 */
package net.sf.launch4j.formimpl;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

import net.sf.launch4j.binding.Binding;
import net.sf.launch4j.binding.Bindings;
import net.sf.launch4j.binding.IValidatable;
import net.sf.launch4j.form.ConfigForm;

/**
 * @author Copyright (C) 2005 Grzegorz Kowal
 */
public class ConfigFormImpl extends ConfigForm {
	private final Bindings _bindings = new Bindings();
	private final JFileChooser _fileChooser = new FileChooser(ConfigFormImpl.class);

	public ConfigFormImpl() {
		_tab.setBorder(BorderFactory.createMatteBorder(0, -1, -1, -1, getBackground()));
		_tab.addTab(Messages.getString("tab.basic"),
				new BasicFormImpl(_bindings, _fileChooser));
		_tab.addTab(Messages.getString("tab.classpath"),
				new ClassPathFormImpl(_bindings, _fileChooser));
		_tab.addTab(Messages.getString("tab.header"),
				new HeaderFormImpl(_bindings));
		_tab.addTab(Messages.getString("tab.jre"),
				new JreFormImpl(_bindings, _fileChooser));
		_tab.addTab(Messages.getString("tab.envVars"),
				new EnvironmentVarsFormImpl(_bindings));
		_tab.addTab(Messages.getString("tab.splash"),
				new SplashFormImpl(_bindings, _fileChooser));
		_tab.addTab(Messages.getString("tab.version"),
				new VersionInfoFormImpl(_bindings, _fileChooser));
		_tab.addTab(Messages.getString("tab.messages"),
				new MessagesFormImpl(_bindings));
	}

	public void clear(IValidatable bean) {
		_bindings.clear(bean);
	}

	public void put(IValidatable bean) {
		_bindings.put(bean);
	}

	public void get(IValidatable bean) {
		_bindings.get(bean);
	}
	
	public boolean isModified() {
		return _bindings.isModified();
	}
	
	public JTextArea getLogTextArea() {
		return _logTextArea;
	}
	
	public Binding getBinding(String property) {
		return _bindings.getBinding(property);
	}
}
