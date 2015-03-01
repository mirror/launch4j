@echo off
type ..\src\launch4j.properties
findstr /C:"#define VERSION" ..\head_src\head.h 
findstr /C:"!define PRODUCT_VERSION" nsis\launch4j.nsi
findstr /C:"versionNumber>" ..\maven\pom.xml
findstr /C:"version>3." ..\maven\pom.xml
findstr /C:"Copyright (c)" nsis\launch4j-setup-license.txt
