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
 * Created on May 21, 2005
 */
package net.sf.launch4j.config;

import net.sf.launch4j.binding.IValidatable;
import net.sf.launch4j.binding.Validator;

/**
 * @author Copyright (C) 2005 Grzegorz Kowal
 */
public class VersionInfo implements IValidatable {
	public static final String VERSION_PATTERN = "(\\d+\\.){3}\\d+";

	private String fileVersion;
	private String txtFileVersion;
	private String fileDescription;
	private String copyright;
	private String productVersion;
	private String txtProductVersion;
	private String productName;
	private String companyName;
	private String internalName;
	private String originalFilename;

	public void checkInvariants() {
		Validator.checkString(fileVersion, 20, VERSION_PATTERN,
				"versionInfo.fileVersion",
				Messages.getString("VersionInfo.file.version"));
		Validator.checkString(txtFileVersion, 50, "versionInfo.txtFileVersion",
				Messages.getString("VersionInfo.txt.file.version"));
		Validator.checkString(fileDescription, 150, "versionInfo.fileDescription",
				Messages.getString("VersionInfo.file.description"));
		Validator.checkString(copyright, 150, "versionInfo.copyright",
				Messages.getString("VersionInfo.copyright"));
		Validator.checkString(productVersion, 20, VERSION_PATTERN,
				"versionInfo.productVersion",
				Messages.getString("VersionInfo.product.version"));
		Validator.checkString(txtProductVersion, 50, "versionInfo.txtProductVersion",
				Messages.getString("VersionInfo.txt.product.version"));
		Validator.checkString(productName, 150, "versionInfo.productName",
				Messages.getString("VersionInfo.product.name"));
		Validator.checkOptString(companyName, 150, "versionInfo.companyName",
				Messages.getString("VersionInfo.company.name"));
		Validator.checkString(internalName, 50, 	"versionInfo.internalName",
				Messages.getString("VersionInfo.internal.name"));
		Validator.checkTrue(!internalName.endsWith(".exe"), "versionInfo.internalName",
				Messages.getString("VersionInfo.internal.name.not.exe"));
		Validator.checkString(originalFilename, 50, "versionInfo.originalFilename",
				Messages.getString("VersionInfo.original.filename"));
		Validator.checkTrue(originalFilename.endsWith(".exe"),
				"versionInfo.originalFilename",
				Messages.getString("VersionInfo.original.filename.exe"));
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getFileDescription() {
		return fileDescription;
	}

	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}

	public String getFileVersion() {
		return fileVersion;
	}

	public void setFileVersion(String fileVersion) {
		this.fileVersion = fileVersion;
	}

	public String getInternalName() {
		return internalName;
	}

	public void setInternalName(String internalName) {
		this.internalName = internalName;
	}

	public String getOriginalFilename() {
		return originalFilename;
	}

	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductVersion() {
		return productVersion;
	}

	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}

	public String getTxtFileVersion() {
		return txtFileVersion;
	}

	public void setTxtFileVersion(String txtFileVersion) {
		this.txtFileVersion = txtFileVersion;
	}

	public String getTxtProductVersion() {
		return txtProductVersion;
	}

	public void setTxtProductVersion(String txtProductVersion) {
		this.txtProductVersion = txtProductVersion;
	}
}
