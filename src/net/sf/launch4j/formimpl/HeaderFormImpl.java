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
 * Created on May 1, 2006
 */
package net.sf.launch4j.formimpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.sf.launch4j.binding.Binding;
import net.sf.launch4j.binding.Bindings;
import net.sf.launch4j.config.Config;
import net.sf.launch4j.config.ConfigPersister;
import net.sf.launch4j.form.HeaderForm;

/**
 * @author Copyright (C) 2006 Grzegorz Kowal
 */
public class HeaderFormImpl extends HeaderForm {
	private final Bindings _bindings;

	public HeaderFormImpl(Bindings bindings) {
		_bindings = bindings;
		_bindings.add("headerTypeIndex", new JRadioButton[] { _guiHeaderRadio,
														_consoleHeaderRadio })
				.add("headerObjects", "customHeaderObjects", _headerObjectsCheck,
															_headerObjectsTextArea)
				.add("libs", "customLibs", _libsCheck, _libsTextArea);

		_guiHeaderRadio.addChangeListener(new HeaderTypeChangeListener());
		_headerObjectsCheck.addActionListener(new HeaderObjectsActionListener());
		_libsCheck.addActionListener(new LibsActionListener());
	}

	private class HeaderTypeChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			Config c = ConfigPersister.getInstance().getConfig();
			c.setHeaderType(_guiHeaderRadio.isSelected() ? Config.GUI_HEADER
														: Config.CONSOLE_HEADER);
			if (!_headerObjectsCheck.isSelected()) {
				Binding b = _bindings.getBinding("headerObjects");
				b.put(c);
			}
		}
	}

	private class HeaderObjectsActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!_headerObjectsCheck.isSelected()) {
				ConfigPersister.getInstance().getConfig().setHeaderObjects(null);
				Binding b = _bindings.getBinding("headerObjects");
				b.put(ConfigPersister.getInstance().getConfig());
			}
		}
	}

	private class LibsActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!_libsCheck.isSelected()) {
				ConfigPersister.getInstance().getConfig().setLibs(null);
				Binding b = _bindings.getBinding("libs");
				b.put(ConfigPersister.getInstance().getConfig());
			}
		}
	}
}
