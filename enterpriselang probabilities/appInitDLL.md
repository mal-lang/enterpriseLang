# AppInit DLL

## Context 

Dynamic-link libraries (DLLs) that are specified in the AppInit_DLLs value in the Registry keys HKEY_LOCAL_MACHINE\Software\Microsoft\Windows NT\CurrentVersion\Windows or HKEY_LOCAL_MACHINE\Software\Wow6432Node\Microsoft\Windows NT\CurrentVersion\Windows are loaded by user32.dll into every process that loads user32.dll. In practice this is nearly every program, since user32.dll is a very common library. Similar to Process Injection, these values can be abused to obtain persistence and privilege escalation by causing a malicious DLL to be loaded and run in the context of separate processes on the computer.

The AppInit DLL functionality is disabled in Windows 8 and later versions when secure boot is enabled.

## Relevant findings

https://www.spiceworks.com/marketing/network-security/pdf-report/
According to this report, 32% of companies still used Windows XP on at least one device in 2019 and 79% of companies still used Windows 7. We can't really know the overlap but we'll assume all companies that still use Windows XP are included in companies that wtill use Windows 7. We can thus assume that 79% of companies are vulnerable to this technique.

## TTC

This technique is said to be similar to process injection (loading and running malicious DLL). We'll then assume the average TTC for this technique to be the same as for Process Injection : Exponential(127.1)

## Result

Based on our findings, we'll assume the probability distribution for this technique to be [Bernoulli(0.79)*Exponential(127.1)].