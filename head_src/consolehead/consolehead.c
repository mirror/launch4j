/*
	Launch4j (http://launch4j.sourceforge.net/)
	Cross-platform Java application wrapper for creating Windows native executables.

	Copyright (C) 2004, 2006 Grzegorz Kowal

	This library is free software; you can redistribute it and/or
	modify it under the terms of the GNU Lesser General Public
	License as published by the Free Software Foundation; either
	version 2.1 of the License, or (at your option) any later version.

	This library is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
	Lesser General Public License for more details.

	You should have received a copy of the GNU Lesser General Public
	License along with this library; if not, write to the Free Software
	Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA


	Compiled with Mingw port of GCC,
	Bloodshed Dev-C++ IDE (http://www.bloodshed.net/devcpp.html)
*/

#include "../resource.h"
#include "../head.h"

int main(int argc, char* argv[])
{
    setConsoleFlag();
	LPTSTR cmdLine = GetCommandLine();
	if (*cmdLine == '"') {
		if (*(cmdLine = strchr(cmdLine + 1, '"') + 1)) {
			cmdLine++;
		}
	} else if ((cmdLine = strchr(cmdLine, ' ')) != NULL) {
		cmdLine++;
	} else {
		cmdLine = "";
	}
	HMODULE hLibrary = NULL;
	if (!prepare(hLibrary, cmdLine)) {
		signalError();
		if (hLibrary != NULL) {
			FreeLibrary(hLibrary);
		}
		return 1;
	}
	FreeLibrary(hLibrary);

	int result = (int) execute(TRUE);
	if (result == -1) {
		signalError();
	} else {
		return result;
	}
}
