# [Exectuion Prevention](https://attack.mitre.org/mitigations/M1038/)

## Context
"Block execution of code on a system through application whitelisting, blacklisting, and/or script blocking."
## Findings

[One source from 2014](https://www.esecurityplanet.com/malware/whitelisting-why-and-how-it-works.html) states that 25% of organizations are already implementing whitelisting.

Perhaps a much better source, the [2019 SANS Survey on Next-Generation Endpoint Risks and Protections](https://www.sans.org/reading-room/whitepapers/bestprac/paper/39295), states that 62.9% use some form of application control (blacklisting/whitelisting/monitoring). 

In any case the average of these two is (0.25 + 0.629)/2 = 0.4395. 

## Result
43.95% corresponds to ```Bernoulli(0.4395)```. 