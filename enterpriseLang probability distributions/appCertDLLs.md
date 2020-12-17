# AppCert DLLs

## Context (https://attack.mitre.org/techniques/T1182/)

Dynamic-link libraries (DLLs) that are specified in the AppCertDLLs Registry key under HKEY_LOCAL_MACHINE\System\CurrentControlSet\Control\Session Manager are loaded into every process that calls the ubiquitously used application programming interface (API) functions CreateProcess, CreateProcessAsUser, CreateProcessWithLoginW, CreateProcessWithTokenW, or WinExec. 

Similar to Process Injection, this value can be abused to obtain persistence and privilege escalation by causing a malicious DLL to be loaded and run in the context of separate processes on the computer.

https://www.elastic.co/fr/blog/ten-process-injection-techniques-technical-survey-common-and-trending-process
This technique is based on the execution of malicious DLLs via CreateProcess API. It is one of many process injection sub-technique, as suggested by the mentioned source. 

We can thus tweak the code by adding attemptProcessInjection as a child for AppCertDLLs and assess the probability distribution for this technique as binary.

## Result

Binary probability distribution

## Discussion

Based on the source I found, I assumed that all the techniques that could be sub techniques of Process Injection would have the same probability distribution and TTC. There might be some variations in reality but for the sake of the model I decided to use a general probability distribution for all Process Injection subtechniques.