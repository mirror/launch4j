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
 * Created on Jun 14, 2006
 */
package net.sf.launch4j.binding;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * @author Copyright (C) 2006 Grzegorz Kowal
 */
public class JTextAreaBinding implements Binding {
	private final String _property;
	private final JTextArea _textArea;
	private final Color _validColor;

	public JTextAreaBinding(String property, JTextArea textArea) {
		if (property == null || textArea == null) {
			throw new NullPointerException();
		}
		if (property.equals("")) {
			throw new IllegalArgumentException();
		}
		_property = property;
		_textArea = textArea;
		_validColor = _textArea.getBackground();
	}

	public String getProperty() {
		return _property;
	}

	public void clear(IValidatable bean) {
		put(bean);
	}

	public void put(IValidatable bean) {
		try {
			List list = (List) PropertyUtils.getProperty(bean, _property);
			StringBuffer sb = new StringBuffer();
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					sb.append(list.get(i));
					if (i < list.size() - 1) {
						sb.append("\n");
					}
				}
			}
			_textArea.setText(sb.toString());
		} catch (Exception e) {
			throw new BindingException(e);
		}
	}

	public void get(IValidatable bean) {
		try {
			String text = _textArea.getText();
			if (!text.equals("")) {
				String[] items = text.split("\n");
				List list = new ArrayList();
				for (int i = 0; i < items.length; i++) {
					list.add(items[i]);
				}
				PropertyUtils.setProperty(bean, _property, list);
			} else {
				PropertyUtils.setProperty(bean, _property, null);
			}
		} catch (Exception e) {
			throw new BindingException(e);
		}
	}

	public void markValid() {
		_textArea.setBackground(_validColor);
		_textArea.requestFocusInWindow();
	}

	public void markInvalid() {
		_textArea.setBackground(Binding.INVALID_COLOR);
	}
	
	public void setEnabled(boolean enabled) {
		_textArea.setEnabled(enabled);
	}
}
