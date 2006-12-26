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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

import net.sf.launch4j.binding.Bindings;
import net.sf.launch4j.binding.Validator;
import net.sf.launch4j.form.JreForm;

/**
 * @author Copyright (C) 2006 Grzegorz Kowal
 */
public class JreFormImpl extends JreForm {

	public JreFormImpl(Bindings bindings, JFileChooser fc) {
		bindings	.add("jre.path", _jrePathField)
				.add("jre.minVersion", _jreMinField)
				.add("jre.maxVersion", _jreMaxField)
				.add("jre.dontUsePrivateJres", _dontUsePrivateJresCheck)
				.add("jre.initialHeapSize", _initialHeapSizeField)
				.add("jre.maxHeapSize", _maxHeapSizeField)
				.add("jre.options", _jvmOptionsTextArea);

		_varCombo.setModel(new DefaultComboBoxModel(new String[] {
				"EXEDIR", "EXEFILE", "PWD", "OLDPWD",
				"HKEY_CLASSES_ROOT", "HKEY_CURRENT_USER", "HKEY_LOCAL_MACHINE",
				"HKEY_USERS", "HKEY_CURRENT_CONFIG" }));

		_varCombo.addActionListener(new VarComboActionListener());
		_varCombo.setSelectedIndex(0);

		_propertyButton.addActionListener(new PropertyActionListener());
		_optionButton.addActionListener(new OptionActionListener());

		_envPropertyButton.addActionListener(new EnvPropertyActionListener(_envVarField));
		_envOptionButton.addActionListener(new EnvOptionActionListener(_envVarField));
	}

	private class VarComboActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			_optionButton.setEnabled(((String) _varCombo.getSelectedItem())
					.startsWith("HKEY_"));
		}
	}

	private class PropertyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			final int pos = _jvmOptionsTextArea.getCaretPosition();
			final String var = (String) _varCombo.getSelectedItem();
			if (var.startsWith("HKEY_")) {
				_jvmOptionsTextArea.insert("-Dreg.key=\"%"
						+ var + "\\\\...%\"\n", pos);
			} else {
				_jvmOptionsTextArea.insert("-Dlaunch4j." + var.toLowerCase()
						+ "=\"%" + var + "%\"\n", pos);
			}
		}
	}

	private class OptionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			final int pos = _jvmOptionsTextArea.getCaretPosition();
			final String var = (String) _varCombo.getSelectedItem();
			if (var.startsWith("HKEY_")) {
				_jvmOptionsTextArea.insert("%" + var + "\\\\...%\n", pos);
			} else {
				_jvmOptionsTextArea.insert("%" + var + "%\n", pos);
			}
		}
	}

	private abstract class EnvActionListener extends AbstractAcceptListener {
		public EnvActionListener(JTextField f, boolean listen) {
			super(f, listen);
		}

		public void actionPerformed(ActionEvent e) {
			final int pos = _jvmOptionsTextArea.getCaretPosition();
			final String var = getText()
					.replaceAll("\"", "")
					.replaceAll("%", "");
			if (Validator.isEmpty(var)) {
				signalViolation(Messages.getString("specifyVar"));
				return;
			}
			add(var, pos);
			clear();
		}

		protected abstract void add(String var, int pos);
	}

	private class EnvPropertyActionListener extends EnvActionListener {
		public EnvPropertyActionListener(JTextField f) {
			super(f, true);
		}

		protected void add(String var, int pos) {
			final String prop = var
					.replaceAll(" ", ".")
					.replaceAll("_", ".")
					.toLowerCase();
			_jvmOptionsTextArea.insert("-Denv." + prop + "=\"%" + var
					+ "%\"\n", pos);
		}
	}

	private class EnvOptionActionListener extends EnvActionListener {
		public EnvOptionActionListener(JTextField f) {
			super(f, false);
		}

		protected void add(String var, int pos) {
			_jvmOptionsTextArea.insert("%" + var + "%\n", pos);	
		}
	}
}
