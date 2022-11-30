@echo off
rem Requires Java 11 or higher.

call clean.bat
echo building...
if not exist "mlib" mkdir mlib
javac -d mods\net.sf.launch4j.example src\net.sf.launch4j.example\module-info.java src\net.sf.launch4j.example\net\sf\launch4j\example\ModuleApp.java
jar --create --file=mlib\net.sf.launch4j.example.jar --main-class=net.sf.launch4j.example.ModuleApp -C mods\net.sf.launch4j.example .
jlink --module-path mlib --add-modules java.base,net.sf.launch4j.example --output ModuleApp
echo done.
