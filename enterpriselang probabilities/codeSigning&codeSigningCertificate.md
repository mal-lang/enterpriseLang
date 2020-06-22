# Code Signing (Mitigation and attack step) 

## Context 
Code signing is a defense technique that consists in enforcing binary and application integrity with digital signature verification to prevent untrusted code from executing.

https://www.websecurity.digicert.com/security-topics/how-code-signing-works
A developer adds a digital signature to code or content using a unique private key from a code signing certificate. However, this key might get compromised and therefore the defense might fail:

Adversaries are known to use code signing certificates to masquerade malware and tools as legitimate binaries. The certificates used during an operation may be created, forged, or stolen by the adversary.

Code signing to verify software on first run can be used on modern Windows and macOS/OS X systems. It is not used on Linux due to the decentralized nature of the platform.

Code signing certificates may be used to bypass security policies that require signed code to execute on a system.

## Relevant findings and result
https://www.venafi.com/blog/study-how-well-are-you-protecting-code-signing-certificates#:~:text=The%20study%20found%20that%20although,process%20for%20code%20signing%20certificates
https://duo.com/decipher/attackers-are-signing-malware-with-valid-certificates
Only 28 percent of organizations consistently enforce a defined security process for code signing certificates.

We can thus assess that the probability of success of the codeSigningCertificate is ``Bernoulli(0.72)`` and the probability for the codeSigning mitigation to be enabled is ``Bernoulli(0.28)``

https://cqureacademy.com/blog/windows-internals/code-signing
Hacking a code Signing certificate wouldn't take more than 15 minutes for a professional adversary so we'll assess that the time to compromise is instantaneous. 




