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
 * Created on May 10, 2005
 */
package net.sf.launch4j.binding;

import java.awt.Color;

import javax.swing.JComboBox;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * @author Copyright (C) 2007 Ian Roberts
 */
public class JComboBoxBinding implements Binding {
	private final String _property;
	private final JComboBox _combo;
	private final int _defaultValue;
	private final Color _validColor;

	public JComboBoxBinding(String property, JComboBox combo, int defaultValue) {
		if (property == null || combo == null) {
			throw new NullPointerException();
		}
		if (property.equals("")
				|| combo.getItemCount() == 0
				|| defaultValue < 0 || defaultValue >= combo.getItemCount()) {
			throw new IllegalArgumentException();
		}
		_property = property;
		_combo = combo;
		_defaultValue = defaultValue;
		_validColor = combo.getBackground();
	}

	public String getProperty() {
		return _property;
	}

	public void clear(IValidatable bean) {
		select(_defaultValue);
	}

	public void put(IValidatable bean) {
		try {
			Integer i = (Integer) PropertyUtils.getProperty(bean, _property);
			if (i == null) {
				throw new BindingException(
						Messages.getString("JComboBoxBinding.property.null"));
			}
			select(i.intValue());
		} catch (Exception e) {
			throw new BindingException(e);
		}
	}

	public void get(IValidatable bean) {
		try {
			PropertyUtils.setProperty(bean, _property, new Integer(_combo.getSelectedIndex()));
			return;
		} catch (Exception e) {
			throw new BindingException(e);
		}
	}

	private void select(int index) {
		if (index < 0 || index >= _combo.getItemCount()) {
			throw new BindingException(
					Messages.getString("JComboBoxBinding.index.out.of.bounds"));
		}
		_combo.setSelectedIndex(index);
	}

	public void markValid() {
		_combo.setBackground(_validColor);
		_combo.requestFocusInWindow();
	}

	public void markInvalid() {
		_combo.setBackground(Binding.INVALID_COLOR);
	}
	
	public void setEnabled(boolean enabled) {
		_combo.setEnabled(enabled);
	}
}
