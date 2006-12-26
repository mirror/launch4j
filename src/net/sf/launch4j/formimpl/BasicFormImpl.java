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

import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.sf.launch4j.FileChooserFilter;
import net.sf.launch4j.binding.Bindings;
import net.sf.launch4j.config.Config;
import net.sf.launch4j.form.BasicForm;

/**
 * @author Copyright (C) 2006 Grzegorz Kowal
 */
public class BasicFormImpl extends BasicForm {

	public BasicFormImpl(Bindings bindings, JFileChooser fc) {
		bindings.add("outfile", _outfileField)
				.add("dontWrapJar", _dontWrapJarCheck)
				.add("jar", _jarField)
				.add("icon", _iconField)
				.add("cmdLine", _cmdLineField)
				.add("errTitle", _errorTitleField)
				.add("downloadUrl", _downloadUrlField, Config.DOWNLOAD_URL)
				.add("supportUrl", _supportUrlField)
				.add("chdir", _chdirField)
				.add("priorityIndex", new JRadioButton[] { _normalPriorityRadio,
															_idlePriorityRadio,
															_highPriorityRadio })
				.add("customProcName", _customProcNameCheck)
				.add("stayAlive", _stayAliveCheck);

		_dontWrapJarCheck.addChangeListener(new DontWrapJarChangeListener());

		_outfileButton.addActionListener(new BrowseActionListener(true, fc,
				new FileChooserFilter("Windows executables (.exe)", ".exe"),
				_outfileField));
		_jarButton.addActionListener(new BrowseActionListener(false, fc,
				new FileChooserFilter("Jar files", ".jar"), _jarField));
		_iconButton.addActionListener(new BrowseActionListener(false, fc,
				new FileChooserFilter("Icon files (.ico)", ".ico"), _iconField));
	}

	private class DontWrapJarChangeListener implements ChangeListener {

		public void stateChanged(ChangeEvent e) {
			boolean dontWrap = _dontWrapJarCheck.isSelected();
			if (dontWrap)  {
				_jarLabel.setIcon(loadImage("images/asterix-o.gif"));
			    _jarLabel.setText(Messages.getString("jarPath"));
			    _jarField.setToolTipText(Messages.getString("jarPathTip"));
			} else {
				_jarLabel.setIcon(loadImage("images/asterix.gif"));
				_jarLabel.setText(Messages.getString("jar"));
				_jarField.setToolTipText(Messages.getString("jarTip"));
			}
			_jarButton.setEnabled(!dontWrap);
		}
	}
}
