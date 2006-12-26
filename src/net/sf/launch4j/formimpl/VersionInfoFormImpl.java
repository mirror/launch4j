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

import net.sf.launch4j.binding.Bindings;
import net.sf.launch4j.config.VersionInfo;
import net.sf.launch4j.form.VersionInfoForm;

/**
 * @author Copyright (C) 2006 Grzegorz Kowal
 */
public class VersionInfoFormImpl extends VersionInfoForm {

	public VersionInfoFormImpl(Bindings bindings, JFileChooser fc) {
		bindings.addOptComponent("versionInfo", VersionInfo.class, _versionInfoCheck)
				.add("versionInfo.fileVersion", _fileVersionField)
				.add("versionInfo.productVersion", _productVersionField)
				.add("versionInfo.fileDescription", _fileDescriptionField)
				.add("versionInfo.internalName", _internalNameField)
				.add("versionInfo.originalFilename", _originalFilenameField)
				.add("versionInfo.productName", _productNameField)
				.add("versionInfo.txtFileVersion", _txtFileVersionField)
				.add("versionInfo.txtProductVersion", _txtProductVersionField)
				.add("versionInfo.companyName", _companyNameField)
				.add("versionInfo.copyright", _copyrightField);
	}
}
