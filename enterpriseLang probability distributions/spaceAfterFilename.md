# [Space After Filename](https://attack.mitre.org/techniques/T1151/)

## Context
>Adversaries can hide a program's true filetype by changing the extension of a file. With certain file types (specifically this does not work with .app extensions), appending a space to the end of a filename will change how the file is processed by the operating system.

## Findings
According to the MITRE ATT&CK page, there is only one procedure example of this attack, which is by a software known as [keydnap](https://attack.mitre.org/software/S0276/). It seems like there is no easy way to prevent this particular attack step, as seemingly all versions of Mac OS/X are affected by it since the way filenames are handled seems inherent to the operating system. This is something also stated in the MITRE ATT&CK matrix about the Space After Filename vulnerability, which states that there is no easy way to mitigate it thanks to the fact that it is based upon the exploitation of system features. So until Apple changes the way spaces are handled after filenames, this is a binary probability distribution. 

## Time To Compromise

This attack step relies on user execution. Once the malicious file is delivered on the user session, the user needs to double-click the file in order for the malware to be run. We assume that the time it takes for a user to execute the file is the same as for a file downloaded via spearphishing [Exponential(1)]. 

## Result
We asses the probability distribution for this attack step to be [Exponential(1)].