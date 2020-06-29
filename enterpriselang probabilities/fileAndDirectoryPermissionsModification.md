# [File and Directory Permissions Modification](https://attack.mitre.org/techniques/T1222/)

## Context
>File and directory permissions are commonly managed by discretionary access control lists (DACLs) specified by the file or directory owner. File and directory DACL implementations may vary by platform, but generally explicitly designate which users/groups can perform which actions (ex: read, write, execute, etc.).

>Adversaries may modify file or directory permissions/attributes to evade intended DACLs. Modifications may include changing specific access rights, which may require taking ownership of a file or directory and/or elevated permissions such as Administrator/root depending on the file or directory's existing permissions to enable malicious activity such as modifying, replacing, or deleting specific files/directories. Specific file and directory modifications may be a required step for many techniques, such as establishing Persistence via Accessibility Features, Logon Scripts, or tainting/hijacking other instrumental binary/configuration files.

## Findings
I was unfortunately unable to find data on how common it is for malware to use this technique, so I decided to look at some specific malware that use this technique, and then find how common they are. According to the MITRE ATT&CK page, one of the malwares that uses this technique is [OSX/Shlayer](https://attack.mitre.org/software/S0402/). According to [kaspersky in a malware report called "Threats to macOS users"](https://securelist.com/threats-to-macos-users/93116/), the share of unique users attacked by this malware out of all users of Kaspersky security solutions for macOS who have been attacked is 21.74%. I will extrapolate from this and roughly assume that this means that 21.74% of attacks will use File and Directory Permissions Modifications. -> ```Bernoulli(0.2174)```. 

## Time to compromise
regarding OSX/Shlayer's file and directory permissions modifications, it uses the command ```chmod+x``` to "Makes the binary within the unzipped .app executable" [source](https://www.carbonblack.com/2019/02/12/tau-threat-intelligence-notification-new-macos-malware-variant-of-shlayer-osx-discovered/). I am assuming this procedure is instant. 

## Results
```Bernoulli(0.2174)```