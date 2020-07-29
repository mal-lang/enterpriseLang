# [Plist Modification](https://attack.mitre.org/techniques/T1150/)

## Context
>Property list (plist) files contain all of the information that macOS and OS X uses to configure applications and services. These files are UTF-8 encoded and formatted like XML documents via a series of keys surrounded by < >. They detail when programs should execute, file paths to the executables, program arguments, required OS permissions, and many others. plists are located in certain locations depending on their purpose such as `/Library/Preferences` (which execute with elevated privileges) and `~/Library/Preferences` (which execute with a user's privileges). Adversaries can modify these plist files to point to their own code, can use them to execute their code in the context of another user, bypass whitelisting procedures, or even use them as a persistence mechanism.

## Findings
I am unable to find any estimates on how prevalent this particular technique is, so for now I will only gather info on the TTC.

## Time to compromise
The [MITRE ATT&CK matrix page for this attack](https://attack.mitre.org/techniques/T1150/) only has one reference that details this attack technique, and that's this technical analysis on [Sofacy’s ‘Komplex’ OS X Trojan](https://unit42.paloaltonetworks.com/unit42-sofacys-komplex-os-x-trojan/). The only part of the trojan that modifies the plist is the Komplex Dropper. To me, it seems like the only part that actually modifies the plist is this line of code:
```
launchctl load -w ~/Library/LaunchAgents/com.apple.updates.plist
```
What this does is to call the system command `launchctl` to add a plist entry into `launchd` to automatically execute the Komplex payload each time the system starts. I assume this is essentially instant. 

## Result
... instant TTC. 

## Discussion

This technique may need review as it is a parent for many other techniques.