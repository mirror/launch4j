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
package net.sf.launch4j.binding;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * @author Copyright (C) 2006 Grzegorz Kowal
 */
public class JListBinding implements Binding {
	private final String _property;
	private final JList _list;
	private final Color _validColor;

	public JListBinding(String property, JList list) {
		if (property == null || list == null) {
			throw new NullPointerException();
		}
		if (property.equals("")) {
			throw new IllegalArgumentException();
		}
		_property = property;
		_list = list;
		_validColor = _list.getBackground();
	}

	public String getProperty() {
		return _property;
	}

	public void clear(IValidatable bean) {
		_list.setModel(new DefaultListModel());
	}

	public void put(IValidatable bean) {
		try {
			List list = (List) PropertyUtils.getProperty(bean, _property);
			DefaultListModel model = new DefaultListModel();
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				model.addElement(iter.next());
			}
			_list.setModel(model);
		} catch (Exception e) {
			throw new BindingException(e);
		}
	}

	public void get(IValidatable bean) {
		try {
			DefaultListModel model = (DefaultListModel) _list.getModel();
			final int size = model.getSize();
			List list = new ArrayList(size);
			for (int i = 0; i < size; i++) {
				list.add(model.get(i));
			}
			PropertyUtils.setProperty(bean, _property, list);
		} catch (Exception e) {
			throw new BindingException(e);
		}
	}
	
	public void markValid() {
		_list.setBackground(_validColor);
		_list.requestFocusInWindow();
	}

	public void markInvalid() {
		_list.setBackground(Binding.INVALID_COLOR);
	}
	
	public void setEnabled(boolean enabled) {
		_list.setEnabled(enabled);
	}
}
