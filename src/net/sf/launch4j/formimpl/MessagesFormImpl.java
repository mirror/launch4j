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
 * Created on Oct 7, 2006
 */
package net.sf.launch4j.formimpl;

import net.sf.launch4j.binding.Bindings;
import net.sf.launch4j.config.Msg;
import net.sf.launch4j.form.MessagesForm;

/**
 * @author Copyright (C) 2006 Grzegorz Kowal
 */
public class MessagesFormImpl extends MessagesForm {

	public MessagesFormImpl(Bindings bindings) {
		Msg m = new Msg();
		bindings.addOptComponent("messages", Msg.class, _messagesCheck)
				.add("messages.startupErr", _startupErrTextArea, 	m.getStartupErr())
				.add("messages.bundledJreErr", _bundledJreErrTextArea, m.getBundledJreErr())
				.add("messages.jreVersionErr", _jreVersionErrTextArea, m.getJreVersionErr())
				.add("messages.launcherErr", _launcherErrTextArea, m.getLauncherErr());			
	}
}
