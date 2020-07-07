# Extra Window Memory Injection

## Context (https://attack.mitre.org/techniques/T1181/)

Before creating a window, graphical Windows-based processes must prescribe to or register a windows class, which stipulate appearance and behavior (via windows procedures, which are functions that handle input/output of data). Registration of new windows classes can include a request for up to 40 bytes of extra window memory (EWM) to be appended to the allocated memory of each instance of that class. This EWM is intended to store data specific to that window and has specific application programming interface (API) functions to set and get its value. 

Although small, the EWM is large enough to store a 32-bit pointer and is often used to point to a windows procedure. Malware may possibly utilize this memory location in part of an attack chain that includes writing code to shared sections of the process’s memory, placing a pointer to the code in EWM, then invoking execution by returning execution control to the address in the process’s EWM.

Execution granted through EWM injection may take place in the address space of a separate live process. Similar to Process Injection, this may allow access to both the target process's memory and possibly elevated privileges. Writing payloads to shared sections also avoids the use of highly monitored API calls such as WriteProcessMemory and CreateRemoteThread. More sophisticated malware samples may also potentially bypass protection mechanisms such as data execution prevention (DEP) by triggering a combination of windows procedures and other system functions that will rewrite the malicious payload inside an executable portion of the target process. 

https://www.elastic.co/fr/blog/ten-process-injection-techniques-technical-survey-common-and-trending-process
This technique is based on the execution of malicious DLLs via CreateProcess API. It is one of many process injection sub-technique, as suggested by the mentioned source.  

We can thus tweak the code by adding attemptProcessInjection as a child for this technique and assess the probability distribution for this technique as binary.

## Result

Binary probability distribution

## Discussion

Based on the source I found, I assumed that all the techniques that could be sub techniques of Process Injection would have the same probability distribution and TTC. There might be some variations in reality but for the sake of the model I decided to use a general probability distribution for all Process Injection subtechniques.
Further work could eventually lead to adding a probability for all the sub techniques for Process Injection and then remove the general probability distribution given to Process Injection.