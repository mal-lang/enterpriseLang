# Elevated Execution With Prompt

## Context (https://attack.mitre.org/techniques/T1514/)

Adversaries may leverage the AuthorizationExecuteWithPrivileges API to escalate privileges by prompting the user for credentials. The purpose of this API is to give application developers an easy way to perform operations with root privileges, such as for application installation or updating. This API does not validate that the program requesting root privileges comes from a reputable source or has been maliciously modified. Although this API is deprecated, it still fully functions in the latest releases of macOS. When calling this API, the user will be prompted to enter their credentials but no checks on the origin or integrity of the program are made. The program calling the API may also load world writable files which can be modified to perform malicious behavior with elevated privileges.

Adversaries may abuse AuthorizationExecuteWithPrivileges to obtain root privileges in order to install malicious software on victims and install persistence mechanisms. This technique may be combined with Masquerading to trick the user into granting escalated privileges to malicious code.This technique has also been shown to work by modifying legitimate programs present on the machine that make use of this API.

## Relevant findings
https://www.carbonblack.com/blog/tau-threat-intelligence-notification-new-macos-malware-variant-of-shlayer-osx-discovered/
Once the targeted User has been tricked into installing the malware (via masquerading and/or spearphishing), a script is executed in a hidden directory and the user is almost instantaneously compromised.
The probability distribution carried by the masquerading attack step reflects the time it takes and the probability that the user will be tricked. We can thus assess this probability distribution as binary.

According to the MITRE ATT&CK framework, this API is still fully working on latest macOS versions.

## Code tweak

Advesaries can perform this technique with admin or user rights. We assume that a profesionnal adversary will always use masquerading for higher success rates (which is why masquerading is a parent of the & elevatedExecutionWithPrivilege step).

## Result 

We assess this probability distribution to be binary.
