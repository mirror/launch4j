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
package net.sf.launch4j.config;

import java.util.List;

import net.sf.launch4j.binding.IValidatable;
import net.sf.launch4j.binding.Validator;

/**
 * @author Copyright (C) 2006 Grzegorz Kowal
 */
public class ClassPath implements IValidatable {
	private String mainClass;
	private List paths;

	public void checkInvariants() {
		Validator.checkString(mainClass, Validator.MAX_PATH, "mainClass",
				Messages.getString("ClassPath.mainClass"));
		Validator.checkOptStrings(paths,
				Validator.MAX_PATH,
				Validator.MAX_BIG_STR,
				"paths",
				Messages.getString("ClassPath.path"));
	}

	public String getMainClass() {
		return mainClass;
	}

	public void setMainClass(String mainClass) {
		this.mainClass = mainClass;
	}

	public List getPaths() {
		return paths;
	}

	public void setPaths(List paths) {
		this.paths = paths;
	}

	public String getPathsString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < paths.size(); i++) {
			sb.append(paths.get(i));
			if (i < paths.size() - 1) {
				sb.append(';');
			}
		}
		return sb.toString();
	}
}
