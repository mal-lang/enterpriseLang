# IFEO Injection

## Context (https://attack.mitre.org/techniques/T1183/)

Image File Execution Options (IFEO) enable a developer to attach a debugger to an application. When a process is created, a debugger present in an application’s IFEO will be prepended to the application’s name, effectively launching the new process under the debugger (e.g., "C:\dbg\ntsd.exe -g notepad.exe"). 

IFEOs can be set directly via the Registry or in Global Flags via the GFlags tool. IFEOs are represented as Debugger values in the Registry under HKLM\SOFTWARE{{\Wow6432Node}}\Microsoft\Windows NT\CurrentVersion\Image File Execution Options\ where is the binary on which the debugger is attached.

IFEOs can also enable an arbitrary monitor program to be launched when a specified program silently exits (i.e. is prematurely terminated by itself or a second, non kernel-mode process). Similar to debuggers, silent exit monitoring can be enabled through GFlags and/or by directly modifying IEFO and silent process exit Registry values in HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Windows NT\CurrentVersion\SilentProcessExit\.

An example where the evil.exe process is started when notepad.exe exits: 

reg add "HKLM\SOFTWARE\Microsoft\Windows NT\CurrentVersion\Image File Execution Options\notepad.exe" /v GlobalFlag /t REG_DWORD /d 512
reg add "HKLM\SOFTWARE\Microsoft\Windows NT\CurrentVersion\SilentProcessExit\notepad.exe" /v ReportingMode /t REG_DWORD /d 1
reg add "HKLM\SOFTWARE\Microsoft\Windows NT\CurrentVersion\SilentProcessExit\notepad.exe" /v MonitorProcess /d "C:\temp\evil.exe"
Similar to Process Injection, these values may be abused to obtain persistence and privilege escalation by causing a malicious executable to be loaded and run in the context of separate processes on the computer. Installing IFEO mechanisms may also provide Persistence via continuous invocation.

Malware may also use IFEO for Defense Evasion by registering invalid debuggers that redirect and effectively disable various system and security applications.

https://www.elastic.co/fr/blog/ten-process-injection-techniques-technical-survey-common-and-trending-process
This technique is based on the execution of malicious DLLs via CreateProcess API. It is one of many process injection sub-technique, as suggested by the mentioned source.  

We can thus tweak the code by adding attemptProcessInjection as a child for this technique and assess the probability distribution for this technique as binary.

## Result

Binary probability distribution

## Discussion

Based on the source I found, I assumed that all the techniques that could be sub techniques of Process Injection would have the same probability distribution and TTC. There might be some variations in reality, especially since this specific technique has no mitigations, but for the sake of the model I decided to use a general probability distribution for all Process Injection subtechniques. Further results are welcome.