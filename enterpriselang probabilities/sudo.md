# Sudo

## Context (https://attack.mitre.org/techniques/T1169/)

The sudoers file, /etc/sudoers, describes which users can run which commands and from which terminals. This also describes which commands users can run as other users or groups. This provides the idea of least privilege such that users are running in their lowest possible permissions for most of the time and only elevate to other users or permissions as needed, typically by prompting for a password. However, the sudoers file can also specify when to not prompt users for passwords with a line like user1 ALL=(ALL) NOPASSWD: ALL.

Adversaries can take advantage of these configurations to execute commands as other users or spawn processes with higher privileges. You must have elevated privileges to edit this file though.

According to the MITRE ATT&CK description, this technique can be blocked by proper Privilege Account Management and restrictions. The prevalence for this attack will thus be carried by the mitigations.

Adversaries can find exploits for unrestricted sudo commands in no time and execute them instantly, which is why we'll assume that the TTC is instantaneous.
 
## Result 

We assess this probability distribution to be binary.

