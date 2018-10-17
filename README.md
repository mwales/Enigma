# Enigma

# Fork history

Enigma seemed kinda crash happy to me when I was using it, so I looked around
for more updated versions with less bugs.  That brought me to the fork written
by jeanthom.

I'm forking it for the purpose of adding a string decryption hotkey.  This
feature won't add anything to the mappings (and who knows, the decrypted strings
may break other features!).

# Old Readme Contents

Enigma is "a tool for deobfuscation of Java bytecode" : you can use it to edit method or class names inside a `.jar` file.

![Enigma's GUI](docs/img/screenshot.png)

Enigma was originally a project from [Cuchaz Interactive](https://www.cuchazinteractive.com/enigma/). It was meant to help reverse engineer Minecraft jar binaries.

I have decided to fork it because it had a NULL-pointer exception bug when handling certain functions (a critical one in my case...), and also the gradle dependencies were not up to date. The original [README](readme.txt) is kept intact in this repository.

## Build

In order to build Enigma, you need to have OpenJDK development tools and gradle installed.

Note: New versions of gradle won't work. Gradle 2.14.1 is the version that I finally got to work

I installed gradle by doing the following:

## Install gradle

Install SdkMan

Website with directions and details:  https://sdkman.io

Basically boiled down to:

```
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk install gradle 2.14.1
```

## Building Enigma

I already had JDK installed.  It was having issues with the default versions, so I had it use 1.8 HotSpot 
version by controlling the path environment variable before calling gradle


```
PATH=/opt/jdk1.8.0_102/bin:$PATH; gradle clean
PATH=/opt/jdk1.8.0_102/bin:$PATH; gradle build
PATH=/opt/jdk1.8.0_102/bin:$PATH; gradle jar
```

Build files are located in `build/libs/`. `enigma-0.10.4b-all.jar` is the one you are looking for :-)
