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

package net.sf.launch4j;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	private static final String BUNDLE_NAME = "net.sf.launch4j.messages";

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);
	private static final MessageFormat FORMATTER = new MessageFormat("");

	private Messages() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
	
	public static String getString(String key, String arg0) {
		return getString(key, new Object[] {arg0});
	}

	public static String getString(String key, String arg0, String arg1) {
		return getString(key, new Object[] {arg0, arg1});
	}

	public static String getString(String key, String arg0, String arg1, String arg2) {
		return getString(key, new Object[] {arg0, arg1, arg2});
	}

	public static String getString(String key, Object[] args) {
		try {
			FORMATTER.applyPattern(RESOURCE_BUNDLE.getString(key));
			return FORMATTER.format(args);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
