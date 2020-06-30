# dylibHijacking 

## Context 
macOS and OS X use a common method to look for required dynamic libraries (dylib) to load into a program based on search paths. Adversaries can take advantage of ambiguous paths to plant dylibs to gain privilege escalation or persistence.

A common method is to see what dylibs an application uses, then plant a malicious version with the same name higher up in the search path. This typically results in the dylib being in the same folder as the application itself.

If the program is configured to run at a higher privilege level than the current user, then when the dylib is loaded into the application, the dylib will also run at that elevated level. This can be used by adversaries as a privilege escalation technique.

## Results 
This technique is similar to *DLL Search Order Hijacking*, on macOS and OS X. We'll assume that the probability distribution for dylibHijacking is the same as the one for DLL Search Order Hijacking : ``[Bernoulli(0.16)]``