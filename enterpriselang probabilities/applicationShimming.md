# Application Shimming

## Context (https://attack.mitre.org/techniques/T1138/)

The Microsoft Windows Application Compatibility Infrastructure/Framework (Application Shim) was created to allow for backward compatibility of software as the operating system codebase changes over time. For example, the application shimming feature allows developers to apply fixes to applications (without rewriting code) that were created for Windows XP so that it will work with Windows 10. [1] Within the framework, shims are created to act as a buffer between the program (or more specifically, the Import Address Table) and the Windows OS. When a program is executed, the shim cache is referenced to determine if the program requires the use of the shim database (.sdb). If so, the shim database uses Hooking to redirect the code as necessary in order to communicate with the OS.

A list of all shims currently installed by the default Windows installer (sdbinst.exe) is kept in:

- %WINDIR%\AppPatch\sysmain.sdb
- hklm\software\microsoft\windows nt\currentversion\appcompatflags\installedsdb

Custom databases are stored in:

- %WINDIR%\AppPatch\custom & %WINDIR%\AppPatch\AppPatch64\Custom
- hklm\software\microsoft\windows nt\currentversion\appcompatflags\custom

To keep shims secure, Windows designed them to run in user mode so they cannot modify the kernel and you must have administrator privileges to install a shim. However, certain shims can be used to Bypass User Account Control (UAC) (RedirectEXE), inject DLLs into processes (InjectDLL), disable Data Execution Prevention (DisableNX) and Structure Exception Handling (DisableSEH), and intercept memory addresses (GetProcAddress). Similar to Hooking, utilizing these shims may allow an adversary to perform several malicious acts such as elevate privileges, install backdoors, disable defenses like Windows Defender, etc.

https://www.elastic.co/fr/blog/ten-process-injection-techniques-technical-survey-common-and-trending-process
This technique is based on the execution of malicious DLLs via CreateProcess API. It is one of many process injection sub-technique, as suggested by the mentioned source.  

We can thus tweak the code by adding attemptProcessInjection as a child for this technique and assess the probability distribution for this technique as binary.

## Result

Binary probability distribution

## Discussion

Based on the source I found, I assumed that all the techniques that could be sub techniques of Process Injection would have the same probability distribution and TTC. There might be some variations in reality but for the sake of the model I decided to use a general probability distribution for all Process Injection subtechniques. 
Further work could eventually lead to adding a probability for all the sub techniques for Process Injection and then remove the general probability distribution given to Process Injection.