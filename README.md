# Centry
Java application to check the Joystick axes position and if they are centered.

## How to Use

1. Calibrate your joystick in Windows
2. Calibrate your joystick in the game
3. Open the .jar by clicking on it or from the command line `java -jar Centry.jar`

## Troubleshooting

**1. Error message missing DLL from command line and device not found:**
Check if you have the following files in the lib folder:
- jinput-dx8.dll
- jinput-raw.dll
- jinput-test.jar
- jinput-wintab.dll
- jinput.jar
- libjinput-linux.so
- libjinput-osx.jnilib 

These file must be in the same folder of the .jar

**2. DLLs not found but inside the .jar folder:**
Check in the Main class in the source code if there is `if(state.equals("build"))` and
replace with `if(!state.equals("build"))` and rebuild the .jar. and start the app
from the command line `java -Djava.library.path=. -jar Centry.jar`
This procedure is needed because 
`File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath()`
is not able to find the right directory path where the .jar is executed.

**3. Axis bars lag and don't increase or decrease smoothly:**
Increase `private static int max_bar` value in Main class.

**4. Still lag after changing max_bar:**
Decrease the sleep time in `Thread.sleep(50)`

### Please READ
The lib folder contain Jinput library .dll files. These file are not under LGPL licence please contact the owner
to ask more info.
