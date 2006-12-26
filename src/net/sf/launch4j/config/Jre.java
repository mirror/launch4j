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
 * Created on Apr 21, 2005
 */
package net.sf.launch4j.config;

import java.util.List;

import net.sf.launch4j.binding.IValidatable;
import net.sf.launch4j.binding.Validator;

/**
 * @author Copyright (C) 2005 Grzegorz Kowal
 */
public class Jre implements IValidatable {

	// 1.x config properties_____________________________________________________________
	public static final String PATH = "jrepath";
	public static final String MIN_VERSION = "javamin";
	public static final String MAX_VERSION = "javamax";
	public static final String ARGS = "jvmArgs";

	// __________________________________________________________________________________
	public static final String VERSION_PATTERN = "(\\d\\.){2}\\d(_\\d+)?";

	private String path;
	private String minVersion;
	private String maxVersion;
	private boolean dontUsePrivateJres;
	private int initialHeapSize;
	private int maxHeapSize;
	private List options;

	public void checkInvariants() {
		Validator.checkOptString(minVersion, 10, VERSION_PATTERN,
				"jre.minVersion", Messages.getString("Jre.min.version"));
		Validator.checkOptString(maxVersion, 10, VERSION_PATTERN,
				"jre.maxVersion", Messages.getString("Jre.max.version"));
		if (Validator.isEmpty(path)) {
			Validator.checkFalse(Validator.isEmpty(minVersion),
					"jre.path", Messages.getString("Jre.specify.jre.path.min.version"));
		} else {
			Validator.checkString(path, Validator.MAX_PATH,
					"jre.path", Messages.getString("Jre.embedded.path"));
		}
		if (!Validator.isEmpty(maxVersion)) {
			Validator.checkFalse(Validator.isEmpty(minVersion),
					"jre.minVersion", Messages.getString("Jre.specify.min.version"));
			Validator.checkTrue(minVersion.compareTo(maxVersion) < 0,
					"jre.maxVersion", Messages.getString("Jre.max.greater.than.min"));
		}
		Validator.checkTrue(initialHeapSize >= 0, "jre.initialHeapSize",
				Messages.getString("Jre.initial.heap"));
		Validator.checkTrue(maxHeapSize == 0 || initialHeapSize <= maxHeapSize,
				"jre.maxHeapSize", Messages.getString("Jre.max.heap"));
		Validator.checkOptStrings(options,
				Validator.MAX_ARGS,
				Validator.MAX_ARGS,
				"[^\"]*|([^\"]*\"[^\"]*\"[^\"]*)*",
				"jre.options",
				Messages.getString("Jre.jvm.options"),
				Messages.getString("Jre.jvm.options.unclosed.quotation"));

		// Quoted variable references: "[^%]*|([^%]*\"([^%]*%[^%]+%[^%]*)+\"[^%]*)*"
		Validator.checkOptStrings(options,
				Validator.MAX_ARGS,
				Validator.MAX_ARGS,
				"[^%]*|([^%]*([^%]*%[^%]+%[^%]*)+[^%]*)*",
				"jre.options",
				Messages.getString("Jre.jvm.options"),
				Messages.getString("Jre.jvm.options.variable"));
	}

	/** JVM options */
	public List getOptions() {
		return options;
	}

	public void setOptions(List options) {
		this.options = options;
	}

	/** Max Java version (x.x.x) */
	public String getMaxVersion() {
		return maxVersion;
	}

	public void setMaxVersion(String maxVersion) {
		this.maxVersion = maxVersion;
	}

	/** Min Java version (x.x.x) */
	public String getMinVersion() {
		return minVersion;
	}

	public void setMinVersion(String minVersion) {
		this.minVersion = minVersion;
	}

	/** Include private JREs in search */
	public boolean isDontUsePrivateJres() {
		return dontUsePrivateJres;
	}

	public void setDontUsePrivateJres(boolean dontUsePrivateJres) {
		this.dontUsePrivateJres = dontUsePrivateJres;
	}

	/** JRE path */
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	/** Initial heap size in MB */
	public int getInitialHeapSize() {
		return initialHeapSize;
	}

	public void setInitialHeapSize(int initialHeapSize) {
		this.initialHeapSize = initialHeapSize;
	}

	/** Max heap size in MB */
	public int getMaxHeapSize() {
		return maxHeapSize;
	}

	public void setMaxHeapSize(int maxHeapSize) {
		this.maxHeapSize = maxHeapSize;
	}
}
