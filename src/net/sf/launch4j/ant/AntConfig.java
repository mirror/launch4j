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
 * Created on May 24, 2005
 */
package net.sf.launch4j.ant;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;

import net.sf.launch4j.config.Config;
import net.sf.launch4j.config.Splash;
import net.sf.launch4j.config.VersionInfo;

/**
 * @author Copyright (C) 2005 Grzegorz Kowal
 */
public class AntConfig extends Config {
	private final List wrappedHeaderObjects = new ArrayList();
	private final List wrappedLibs = new ArrayList();
	private final List wrappedVariables = new ArrayList();

	public void setJarPath(String path) {
		setJar(new File(path));
	}

	public void addObj(StringWrapper obj) {
		wrappedHeaderObjects.add(obj);
	}

	public void addLib(StringWrapper lib) {
		wrappedLibs.add(lib);
	}
	
	public void addVar(StringWrapper var) {
		wrappedVariables.add(var);
	}

	// __________________________________________________________________________________

	public void addClassPath(AntClassPath classPath) {
		checkNull(getClassPath(), "classPath");
		setClassPath(classPath);
	}

	public void addJre(AntJre jre) {
		checkNull(getJre(), "jre");
		setJre(jre);
	}

	public void addSplash(Splash splash) {
		checkNull(getSplash(), "splash");
		setSplash(splash);
	}

	public void addVersionInfo(VersionInfo versionInfo) {
		checkNull(getVersionInfo(), "versionInfo");
		setVersionInfo(versionInfo);
	}

	// __________________________________________________________________________________

	public void unwrap() {
		setHeaderObjects(StringWrapper.unwrap(wrappedHeaderObjects));
		setLibs(StringWrapper.unwrap(wrappedLibs));
		setVariables(StringWrapper.unwrap(wrappedVariables));
		if (getClassPath() != null) {
			((AntClassPath) getClassPath()).unwrap();
		}
		if (getJre() != null) {
			((AntJre) getJre()).unwrap();
		}
	}

	private void checkNull(Object o, String name) {
		if (o != null) {
			throw new BuildException(
					Messages.getString("AntConfig.duplicate.element")
					+ ": "
					+ name);
		}
	}
}
