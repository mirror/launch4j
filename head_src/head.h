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

#ifndef _LAUNCH4J_HEAD__INCLUDED_
#define _LAUNCH4J_HEAD__INCLUDED_

#define WIN32_LEAN_AND_MEAN		// VC - Exclude rarely-used stuff from Windows headers

// Windows Header Files:
#include <windows.h>

// C RunTime Header Files
#include <stdlib.h>
#include <malloc.h>
#include <memory.h>
#include <tchar.h>
#include <shellapi.h>
#include <direct.h>
#include <fcntl.h>
#include <stdio.h>
#include <sys/stat.h>
#include <io.h>
#include <process.h>

#define NO_JAVA_FOUND 0
#define FOUND_JRE 1
#define FOUND_SDK 2

#define LAUNCH4J_TMP_DIR "\\launch4j-tmp\\"
#define MANIFEST ".manifest"

#define HKEY_STR "HKEY"
#define HKEY_CLASSES_ROOT_STR "HKEY_CLASSES_ROOT"
#define HKEY_CURRENT_USER_STR "HKEY_CURRENT_USER"
#define HKEY_LOCAL_MACHINE_STR "HKEY_LOCAL_MACHINE"
#define HKEY_USERS_STR "HKEY_USERS"
#define HKEY_CURRENT_CONFIG_STR "HKEY_CURRENT_CONFIG"

#define STR 128
#define BIG_STR 1024
#define MAX_VAR_SIZE 32767
#define MAX_ARGS 32768

#define TRUE_STR "true"
#define FALSE_STR "false"

void msgBox(const char* text);
void signalError();
BOOL loadString(const HMODULE hLibrary, const int resID, char* buffer);
BOOL loadBool(const HMODULE hLibrary, const int resID);
int loadInt(const HMODULE hLibrary, const int resID);
BOOL regQueryValue(const char* regPath, unsigned char* buffer,
		unsigned long bufferLength);
void regSearch(const HKEY hKey, const char* keyName, const int searchType);
BOOL findJavaHome(char* path, const BOOL dontUsePrivateJres);
int getExePath(char* exePath);
void catJavaw(char* jrePath);
void appendAppClasspath(char* dst, const char* src, const char* classpath);
BOOL isJrePathOk(const char* path);
BOOL expandVars(char *dst, const char *src, const char *exePath,
		const int pathLen);
BOOL prepare(HMODULE hLibrary, const char *lpCmdLine);
void closeHandles();
BOOL appendToPathVar(const char* path);
DWORD execute(const BOOL wait);

#endif // _LAUNCH4J_HEAD__INCLUDED_
