@ECHO OFF
Start Vlc\vlcWin\vlc.exe  --intf telnet
java -jar wii.jar
taskkill /F /IM vlc.exe
