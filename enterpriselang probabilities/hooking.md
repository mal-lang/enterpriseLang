# Hooking

## Context (https://attack.mitre.org/techniques/T1181/)

Windows processes often leverage application programming interface (API) functions to perform tasks that require reusable system resources. Windows API functions are typically stored in dynamic-link libraries (DLLs) as exported functions.

Hooking involves redirecting calls to these functions and can be implemented via:

Hooks procedures, which intercept and execute designated code in response to events such as messages, keystrokes, and mouse inputs.
Import address table (IAT) hooking, which use modifications to a process’s IAT, where pointers to imported API functions are stored. 
Inline hooking, which overwrites the first bytes in an API function to redirect code flow.
Similar to Process Injection, adversaries may use hooking to load and execute malicious code within the context of another process, masking the execution while also allowing access to the process's memory and possibly elevated privileges. Installing hooking mechanisms may also provide Persistence via continuous invocation when the functions are called through normal use.

Malicious hooking mechanisms may also capture API calls that include parameters that reveal user authentication credentials for Credential Access. 

Hooking is commonly utilized by Rootkits to conceal files, processes, Registry keys, and other objects in order to hide malware and associated behaviors.

https://www.elastic.co/fr/blog/ten-process-injection-techniques-technical-survey-common-and-trending-process
This technique is based on the execution of malicious DLLs via CreateProcess API. It is one of many process injection sub-technique, as suggested by the mentioned source.  

We can thus tweak the code by adding attemptProcessInjection as a child for this technique and assess the probability distribution for this technique as binary.

## Result

Binary probability distribution

## Discussion

Based on the source I found, I assumed that all the techniques that could be sub techniques of Process Injection would have the same probability distribution and TTC. There might be some variations in reality but for the sake of the model I decided to use a general probability distribution for all Process Injection subtechniques. 
Further work could eventually lead to adding a probability for all the sub techniques for Process Injection and then remove the general probability distribution given to Process Injection.