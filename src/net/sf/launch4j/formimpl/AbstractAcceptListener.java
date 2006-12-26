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

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import net.sf.launch4j.binding.Binding;

/**
 * @author Copyright (C) 2006 Grzegorz Kowal
 */
public abstract class AbstractAcceptListener implements ActionListener {
	final JTextField _field;

	public AbstractAcceptListener(JTextField f, boolean listen) {
		_field = f;
		if (listen) {
			_field.addActionListener(this);
		}
	}

	protected String getText() {
		return _field.getText();
	}
	
	protected void clear() {
		_field.setText("");
		_field.requestFocusInWindow();
	}

	protected void signalViolation(String msg) {
		final Color bg = _field.getBackground();
		_field.setBackground(Binding.INVALID_COLOR);
		MainFrame.getInstance().warn(msg);
		_field.setBackground(bg);
		_field.requestFocusInWindow();
	}
}
