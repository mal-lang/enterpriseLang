# [Securityd Memory](https://attack.mitre.org/techniques/T1555/002/)

## Context
>An adversary may obtain root access (allowing them to read securityd’s memory), then they can scan through memory to find the correct sequence of keys in relatively few tries to decrypt the user’s logon keychain. This provides the adversary with all the plaintext passwords for users, WiFi, mail, browsers, certificates, secure notes, etc.

## Findings
I will attempt to find the prevalence of this attack step. 

To begin with, it the only malware family that makes use of this attack step is (according to MITRE ATT&CK) is [Keydnap](https://attack.mitre.org/software/S0276/). In [this list](https://macos.checkpoint.com/) of mac OS malware, we find 57 different kinds of Mac OS malware, one of which is Keydnap. This means that 1/57 of all malware families get credentials from securityD memory, which I will use as an estimate of how prevalent this attack is. ~1.58%. 

I can't think of another way to estimate the prevalence, and I am also unable to find any source on the prevalence of this attack step, so for now -> ```Bernoulli(0.0158)``` is the estimated prevalence. 

## Time to compromise
In [this article](https://juusosalonen.com/post/30923743427/breaking-into-the-os-x-keychain) about getting credentials from the OSX keychain, the author writes "I found this particular technique interesting because it is instantaneous,[...]". The author of the article is also the author of [keychaindump](https://github.com/juuso/keychaindump), a proof of concept of this technique which is also used by the keydnap software. So, this attack step is instantaneous. 

## Result
```Bernoulli(0.0158)```

## Discussion
Ideally we want a much better source for the prevalence. 