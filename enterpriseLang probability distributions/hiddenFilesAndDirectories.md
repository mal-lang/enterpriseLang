# [Hidden Files and Directories](https://attack.mitre.org/techniques/T1158/)

## Context
>To prevent normal users from accidentally changing special files on a system, most operating systems have the concept of a ‘hidden’ file. These files don’t show up when a user browses the file system with a GUI or when using normal commands on the command line. Users must explicitly ask to show the hidden files either via a series of Graphical User Interface (GUI) prompts or with command line switches (dir /a for Windows and ls –a for Linux and macOS).

## Findings
In [fireEyes 2020 Mtrends report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html), they find that hidden files and directories are utilized in 0.44% of all attack lifecycles. 

In the article [SoK: ATT&CK Techniques and Trends in Windows Malware](https://krisk.io/publication/mitre-attack-securecomm19/), out of 951 samples they found that 16 samples used hidden files and directories. This is 1.68%. 

If we use the average of these two findings we get that (0.44 + 1.68)/2 = 1.06%. 

## Time to compromise
According to the mitre att&ck page, this is an attack based on system features. To perform this step on windows, "users can mark specific files as hidden by using the attrib.exe binary. Simply do `attrib +h filename` to mark a file or folder as hidden." While on linux/mac, "users can mark specific files as hidden simply by putting a "." as the first character in the file or folder name". This is an instant TTC since this step is probably done while the malware author(s) are creating the malware, and has thus already been done before the attack even starts. Even if it were to be performed while the attack was ongoing, it would still be nearly instant. As such, I assume an instant TTC.

## Result
```Bernoulli(0.0106)```. 