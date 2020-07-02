# [Obfuscated Files Or Information](https://attack.mitre.org/techniques/T1027/)

## Context
>Adversaries may attempt to make an executable or file difficult to discover or analyze by encrypting, encoding, or otherwise obfuscating its contents on the system or in transit. This is common behavior that can be used across different platforms and the network to evade defenses.

## Findings
Recorded Future's report ["Defense Evasion Dominant in Top MITRE ATT&CK Tactics of 2019"](https://www.recordedfuture.com/mitre-attack-tactics/) puts Obfuscated Files or Information as occuring in 21,992 malware samples out of 26,057 total. This is ~84.39%. 

In [this](https://krisk.io/post/sok-attack-securecomm19.pdf) article on ATT&CK Techniques and Trends in Windows Malware, with a sample size of 951 the authors find that 604 samples use some kind of obfuscated files or information. This corresponds to ~63.5%

If we use the average of these two, we find that ~73.95% of malware exhibit this tactic. -> ```Bernoulli(0.7395)```. 

## Time to compromise
This is a really broad category. MITRE lists that "Payloads may be compressed, archived, or encrypted in order to avoid detection". First of all, a study from [sophos](https://nakedsecurity.sophos.com/2010/07/27/large-piece-malware/) found that in 2005, the average size of malware was 126kB, while in 2010 it was 338kB. So it grew by a factor of ~2.68 in 5 years. At the time of writing this, it's currently 10 years after 2010, so I will estimate that now the average size of malware has grown at the same rate as it did between 2005 and 2010. This comes out to ~1.8MB. To compress a file of this size, to get an estimate I found a picture on my computer with the size 1.83 MB, and compressing/encrypting this took a split second. (CPU: intel i7 7500 2.7GHz.) I think it's safe to estimate this as instant. 

## Result
```Bernoulli(0.7395)```