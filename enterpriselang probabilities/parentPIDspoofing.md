# Parent PID spoofing

## Context (https://attack.mitre.org/techniques/T1134/004/, https://attack.mitre.org/versions/v6/techniques/T1502/)

Adversaries may spoof the parent process identifier (PPID) of a new process to evade process-monitoring defenses or to elevate privileges. New processes are typically spawned directly from their parent, or calling, process unless explicitly specified. One way of explicitly assigning the PPID of a new process is via the *CreateProcess API call*, which supports a parameter that defines the PPID to use. This functionality is used by Windows features such as User Account Control (UAC) to correctly set the PPID after a requested elevated process is spawned by SYSTEM (typically via svchost.exe or consent.exe) rather than the current user context.

Adversaries may abuse these mechanisms to evade defenses, such as those blocking processes spawning directly from Office documents, and analysis targeting unusual/potentially malicious parent-child process relationships, *such as* spoofing the PPID of PowerShell/Rundll32 to be explorer.exe rather than an Office document delivered as part of Spearphishing Attachment. *This spoofing could be executed via VBA Scripting within a malicious Office document or any code that can perform Execution through API*.

https://pentestlab.blog/2020/02/24/parent-pid-spoofing/
Explicitly assigning the PPID may also enable Privilege Escalation (given appropriate access rights to the parent process). For example, an adversary in a privileged user context (i.e. administrator) may spawn a new process and assign the parent as a process running as SYSTEM (*such as* lsass.exe), causing the new process to be elevated via the inherited access token.


## Relevant findings 

https://medium.com/@r3n_hat/parent-pid-spoofing-b0b17317168e
This technique is a type of process Injection that leverages the create Process API. Once the adversary has access to Execution Through API, it seems that they can almost instantly perform this technique. If they are already in a privileged admin context they can then use this technique for privilege escalation.

## Results

We could assess this probability distribution as binary with proper code improvement.

## Code improvement

The MITRE description and other findings suggest that this technique can only be used once the adversary has access to Execution Through API or through VBA Scripting in an Office document previously delivered via Spearphishing and executed by User Execution. This suggests that Execution Through API and Scripting should be a parent for this technique. Then, based on the current session of the adversary (user or admin), they may use this technique to get SYSTEM rights (via SYTEM processes *such as* lsass.exe). 

## Discussion

The previous parents were PowerShell and Rundll32 which I felt (from the description and the exploits I found) were mere examples rather than actual parents, so I decided to remove them. My interpretation may have been bad and thus the code I changed is up to discussion.