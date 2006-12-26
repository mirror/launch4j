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

import net.sf.launch4j.FileChooserFilter;
import net.sf.launch4j.binding.Bindings;
import net.sf.launch4j.config.Splash;
import net.sf.launch4j.form.SplashForm;

/**
 * @author Copyright (C) 2006 Grzegorz Kowal
 */
public class SplashFormImpl extends SplashForm {

	public SplashFormImpl(Bindings bindings, JFileChooser fc) {
		bindings.addOptComponent("splash", Splash.class, _splashCheck)
				.add("splash.file", _splashFileField)
				.add("splash.waitForWindow", _waitForWindowCheck, true)
				.add("splash.timeout", _timeoutField, "60")
				.add("splash.timeoutErr", _timeoutErrCheck, true);

		_splashFileButton.addActionListener(new BrowseActionListener(false, fc,
				new FileChooserFilter("Bitmap files (.bmp)", ".bmp"), _splashFileField));
	}
}
