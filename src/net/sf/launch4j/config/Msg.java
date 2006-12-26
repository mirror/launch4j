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
 * Created on Oct 8, 2006
 */
package net.sf.launch4j.config;

import net.sf.launch4j.binding.IValidatable;
import net.sf.launch4j.binding.Validator;

/**
 * @author Copyright (C) 2006 Grzegorz Kowal
 */
public class Msg implements IValidatable {
	private String startupErr;
	private String bundledJreErr;
	private String jreVersionErr;
	private String launcherErr;

	public void checkInvariants() {
		Validator.checkOptString(startupErr, 1024, "startupErr",
				Messages.getString("Msg.startupErr"));
		Validator.checkOptString(bundledJreErr, 1024, "bundledJreErr",
				Messages.getString("Msg.bundledJreErr"));
		Validator.checkOptString(jreVersionErr, 1024, "jreVersionErr",
				Messages.getString("Msg.jreVersionErr"));
		Validator.checkOptString(launcherErr, 1024, "launcherErr",
				Messages.getString("Msg.launcherErr"));
	}

	public String getStartupErr() {
		return !Validator.isEmpty(startupErr) ? startupErr
				: "An error occurred while starting the application.";
	}
	
	public void setStartupErr(String startupErr) {
		this.startupErr = startupErr;
	}

	public String getBundledJreErr() {
		return !Validator.isEmpty(bundledJreErr) ? bundledJreErr
				: "This application was configured to use a bundled Java Runtime" +
						" Environment but the runtime is missing or corrupted.";
	}

	public void setBundledJreErr(String bundledJreErr) {
		this.bundledJreErr = bundledJreErr;
	}

	public String getJreVersionErr() {
		return !Validator.isEmpty(jreVersionErr) ? jreVersionErr
				: "This application requires a Java Runtime Environment";
	}

	public void setJreVersionErr(String jreVersionErr) {
		this.jreVersionErr = jreVersionErr;
	}
	
	public String getLauncherErr() {
		return !Validator.isEmpty(launcherErr) ? launcherErr
				: "The registry refers to a nonexistent Java Runtime Environment" +
						" installation or the runtime is corrupted.";
	}
	
	public void setLauncherErr(String launcherErr) {
		this.launcherErr = launcherErr;
	}
}
